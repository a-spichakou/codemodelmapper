package github.compile.mapper.source;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JPrimitiveType;
import com.sun.codemodel.JVar;

/**
 * Source definition path node
 * 
 * @author aspichakou
 * 
 */
public class SourcePathNode {

	/**
	 * Object type
	 */
	private Class clazz;
	/**
	 * Setter form Parent class
	 */
	private Method setMethod;
	/**
	 * Getter form Parent class
	 */
	private Method getMethod;

	private ComplexSourcePathNodeType type;
	private Object complexParam;

	public ComplexSourcePathNodeType getType() {
		return type;
	}

	public void setType(ComplexSourcePathNodeType type) {
		this.type = type;
	}

	public Object getComplexParam() {
		return complexParam;
	}

	public void setComplexParam(Object complexParam) {
		this.complexParam = complexParam;
	}

	public JExpression addParamToGetMethod(JCodeModel codeModel, JMethod jmethod, JVar source) {
		final JInvocation invoke = source.invoke(getMethod.getName());
		if(complexParam==null)
		{
			return invoke;
		}
		final JVar decl = jmethod.body().decl(codeModel.ref(getMethod.getReturnType()), "varFromGetter");
		
		final JExpression complexParamAsLiteral = getComplexParamAsLiteral(codeModel);
		if(type==ComplexSourcePathNodeType.ARRAY)
		{			
			jmethod.body().assign(decl, invoke);
			final JConditional ifCond = jmethod.body()._if(decl.eq(JExpr._null()));
			ifCond._then()._return(JExpr._null());
			final  JExpression component = decl.component(complexParamAsLiteral);			
			return component;
		}
		if(type==ComplexSourcePathNodeType.LIST)
		{			
			jmethod.body().assign(decl, invoke);
			final JInvocation invoke2 = decl.invoke("get");				
			invoke2.arg(complexParamAsLiteral);
			return invoke2;
		}
		if(type==ComplexSourcePathNodeType.MAP)
		{			
			jmethod.body().assign(decl, invoke);
			final JInvocation invoke2 = decl.invoke("get");									
			invoke2.arg(complexParamAsLiteral);			
			return invoke2;
		}
		return invoke;
	}
	
	public void addSet(JCodeModel codeModel, JMethod jmethod, JVar target, JVar value)
	{		
		if(complexParam==null)
		{						
			final JInvocation invoke = target.invoke(setMethod.getName());
			jmethod.body().add(invoke);
			invoke.arg(value);
		}
		if(type==ComplexSourcePathNodeType.ARRAY)
		{				
			// Generate initialization of value if need
			final JVar declNewDelcare = jmethod.body().decl(codeModel.ref(getMethod.getReturnType()), "declNewDelcare");			
			addParamToSetWithInitMethod(codeModel,jmethod,target,declNewDelcare);
			
			jmethod.body().assign(declNewDelcare.component(JExpr.direct(complexParam.toString())), value);
		}	
		if(type==ComplexSourcePathNodeType.LIST)
		{				
			// Generate initialization of value if need
			JVar declNewDelcare=null;
			if(getMethod.getReturnType().getName()==List.class.getName())
			{
				declNewDelcare = jmethod.body().decl(codeModel.ref(ArrayList.class), "declNewDelcare");
			}
			else
			{
				declNewDelcare = jmethod.body().decl(codeModel.ref(getMethod.getReturnType()), "declNewDelcare");
			}
						
			final JExpressionImpl addParamToSetWithInitMethod = addParamToSetWithInitMethod(codeModel,jmethod,target,declNewDelcare);
			final JInvocation invoke = addParamToSetWithInitMethod.invoke("add");
			jmethod.body().add(invoke);
			invoke.arg(JExpr.direct(complexParam.toString()));
			invoke.arg(value);
		}
		if(type==ComplexSourcePathNodeType.MAP)
		{				
			// Generate initialization of value if need
			JVar declNewDelcare=null;
			if(getMethod.getReturnType().getName()==Map.class.getName())
			{
				declNewDelcare = jmethod.body().decl(codeModel.ref(ArrayList.class), "declNewDelcare");
			}
			else
			{
				declNewDelcare = jmethod.body().decl(codeModel.ref(getMethod.getReturnType()), "declNewDelcare");
			}
						
			final JExpressionImpl addParamToSetWithInitMethod = addParamToSetWithInitMethod(codeModel,jmethod,target,declNewDelcare);
			final JInvocation invoke = addParamToSetWithInitMethod.invoke("put");
			jmethod.body().add(invoke);
			final JExpression complexParamAsLiteral = getComplexParamAsLiteral(codeModel);
			invoke.arg(complexParamAsLiteral);
			invoke.arg(value);
		}
	}
	
	public JExpressionImpl addParamToSetWithInitMethod(JCodeModel codeModel, JMethod jmethod, JVar prevDecl, JVar newObjectVar) {
		final JClass returnClass = codeModel.ref(clazz);	
		jmethod.body().assign(newObjectVar, prevDecl.invoke(getMethod.getName()));
		// if(getMethod()==null)
		final JConditional ifCond = jmethod.body()._if(newObjectVar.eq(JExpr._null()));				

		if(complexParam==null)
		{						
			final JExpression newObject = JExpr._new(codeModel.ref(clazz));
			// TargetObject newTargetObject = new TargetObject()
			ifCond._then().assign(newObjectVar, newObject);
			// target.setMethod(newTargetObject)			
			ifCond._then().add(prevDecl.invoke(setMethod.getName()).arg(newObjectVar));
			return newObjectVar;
		}
		final Class<?> returnType = getMethod.getReturnType();
		if(type==ComplexSourcePathNodeType.ARRAY)
		{				
			final int index = Integer.parseInt(complexParam.toString());
			final int size = index+1;
			// TargetObject[] newTargetArray = new TargetObject[idx+1]
			JExpression newObject = null;
			final boolean wrapper = ClassUtils.isPrimitiveOrWrapper(clazz);
			if(wrapper)
			{
				newObject = JExpr.newArray(JPrimitiveType.parse(codeModel, ClassUtils.wrapperToPrimitive(clazz).getName()),size);
			}
			else
			{
				newObject = JExpr.newArray(returnClass,size);
			}
						
			ifCond._then().assign(newObjectVar, newObject);
			// target.setMethod(newTargetArray)			
			ifCond._then().add(prevDecl.invoke(setMethod.getName()).arg(newObjectVar));
			final JExpressionImpl arrComponent = newObjectVar.component(JExpr.direct(complexParam.toString()));
			
			// Check array size
			//String[] newSizeArray;
			final JVar newSizeArray = jmethod.body().decl(codeModel.ref(returnType), "newSizeArray");
			
			//if (declNewDelcare.length<(3)) {
			final JConditional checkSizeIf = jmethod.body()._if(newObjectVar.ref("length").lt(JExpr.direct(size+"")));	
			// newSizeArray = new String[ 3 ] ;
			checkSizeIf._then().assign(newSizeArray, newObject);
			// innertargetclass10 .setStringArray(newSizeArray);
			final JInvocation invoke = prevDecl.invoke(setMethod.getName());
			checkSizeIf._then().add(invoke);
			invoke.arg(newSizeArray);
			
			// System.arraycopy(declNewDelcare, (0), newSizeArray, (0), (3));
			final JInvocation staticInvokeCopyArray = codeModel.ref(System.class).staticInvoke("arraycopy");
			checkSizeIf._then().add(staticInvokeCopyArray);
			staticInvokeCopyArray.arg(newObjectVar);
			staticInvokeCopyArray.arg(JExpr.direct("0"));
			staticInvokeCopyArray.arg(newSizeArray);
			staticInvokeCopyArray.arg(JExpr.direct("0"));
			staticInvokeCopyArray.arg(JExpr.direct(size+""));
			
			// Check element null
			// if (declNewDelcare[(2)] == null) {		
			if(!wrapper)
			{
				final JConditional ifCondElement = checkSizeIf._else()._if(arrComponent.eq(JExpr._null()));
				//declNewDelcare[(2)] = new String();
				ifCondElement._then().assign(newObjectVar.component(JExpr.direct(complexParam.toString())), JExpr._new(returnClass));					
			}
												
			return newObjectVar.component(JExpr.direct(complexParam.toString()));
		}
		if(type==ComplexSourcePathNodeType.LIST)
		{			
			final int index = Integer.parseInt(complexParam.toString());
			final int size = index+1;
			// ArrayList newTargetArrayList = new ArrayList()
			JExpression newObject = null;
			if(returnType.getName()==List.class.getName())
			{
				newObject = JExpr._new(codeModel.ref(ArrayList.class));
			}
			else
			{
				newObject = JExpr._new(codeModel.ref(returnType));
			}
						
			ifCond._then().assign(newObjectVar, newObject);
			// target.setMethod(newTargetList)			
			ifCond._then().add(prevDecl.invoke(setMethod.getName()).arg(newObjectVar));
			
			// Check list size
			//ArrayList newSizeList;
			final JVar newSizeArray = jmethod.body().decl(codeModel.ref(ArrayList.class), "newSizeList");
			
			//if (declNewDelcare.size()<(3)) {
			final JExpression directSize = JExpr.direct(size+"");
			final JConditional checkSizeIf = jmethod.body()._if(newObjectVar.invoke("size").lt(directSize));	
			// newSizeList = new ArrayList() ;
			//if (declNewDelcare.size()<(3)) {
			checkSizeIf._then().assign(newSizeArray, JExpr._new(codeModel.ref(ArrayList.class)).arg(directSize));		
			final JInvocation staticInvokeFillyList = codeModel.ref(Utils.class).staticInvoke("initList");
			staticInvokeFillyList.arg(newSizeArray);
			staticInvokeFillyList.arg(directSize);
			checkSizeIf._then().add(staticInvokeFillyList);
			//innertargetclass10 .setStringList(newSizeList);
			final JInvocation invoke = prevDecl.invoke(setMethod.getName());
			checkSizeIf._then().add(invoke);
			invoke.arg(newSizeArray);
			
			// Collections.copy(newSizeArray, declNewDelcare);
			final JInvocation staticInvokeCopyList = codeModel.ref(Collections.class).staticInvoke("copy");
			checkSizeIf._then().add(staticInvokeCopyList);
			staticInvokeCopyList.arg(newSizeArray);			
			staticInvokeCopyList.arg(newObjectVar);
			//else {
            //	newSizeList = declNewDelcare;
        	//	}
			checkSizeIf._else().assign(newSizeArray, newObjectVar);
			
			// Check element null
			// if (declNewDelcare.get(2) == null) {			
			final JInvocation getByIndexInvoke = newSizeArray.invoke("get").arg(JExpr.direct(complexParam.toString()));
			final JConditional ifCondElement = checkSizeIf._else()._if(getByIndexInvoke.eq(JExpr._null()));
			//declNewDelcare.set(2, new String());
			final JInvocation setInvoke = newSizeArray.invoke("add");
			ifCondElement._then().add(setInvoke);
			setInvoke.arg(JExpr.direct(complexParam.toString()));
			setInvoke.arg(JExpr._new((returnClass)));					
			
			return newSizeArray;
		}
		if(type==ComplexSourcePathNodeType.MAP)
		{			
			// HashMap newTargetMap = new HashMap()
			JExpressionImpl newObject = null;
			if(returnType.getName()==List.class.getName())
			{
				newObject = JExpr._new(codeModel.ref(HashMap.class));
			}
			else
			{
				newObject = JExpr._new(codeModel.ref(returnType));
			}
						
			ifCond._then().assign(newObjectVar, newObject);
			// target.setMethod(newTargetList)			
			ifCond._then().add(prevDecl.invoke(setMethod.getName()).arg(newObjectVar));				
						
			// Check element null
			// if (declNewDelcare.get(2) == null) {						
			final JExpression complexParamAsLiteral = getComplexParamAsLiteral(codeModel);
			final JInvocation getByIndexInvoke = newObjectVar.invoke("get").arg(complexParamAsLiteral);
			final JConditional ifCondElement = jmethod.body()._if(getByIndexInvoke.eq(JExpr._null()));
			//declNewDelcare.set(2, new String());
			final JInvocation setInvoke = newObjectVar.invoke("put");
			ifCondElement._then().add(setInvoke);
			setInvoke.arg(complexParamAsLiteral);
			setInvoke.arg(JExpr._new((returnClass)));					
			
			return newObjectVar;
		}	
		return null;								
		
	}	
	
	private JExpression getComplexParamAsLiteral(JCodeModel codeModel)
	{
		final JExpression literalByValue = Utils.getLiteralByValue(codeModel, complexParam);
		return literalByValue;
	}
	
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Method getSetMethod() {
		return setMethod;
	}

	public void setSetMethod(Method setMethod) {
		this.setMethod = setMethod;
	}

	public Method getGetMethod() {
		return getMethod;
	}

	public void setGetMethod(Method getMethod) {
		this.getMethod = getMethod;
	}

}
