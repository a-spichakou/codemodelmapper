package github.compile.mapper.source;

import java.lang.reflect.Method;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
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
		
		if(type==ComplexSourcePathNodeType.ARRAY)
		{			
			jmethod.body().assign(decl, invoke);
			final  JExpression component = decl.component(JExpr.direct(complexParam.toString()));			
			return component;
		}
		if(type==ComplexSourcePathNodeType.LIST)
		{			
			jmethod.body().assign(decl, invoke);
			final JInvocation invoke2 = decl.invoke("get");			
			invoke2.arg(JExpr.direct(complexParam.toString()));
			return invoke2;
		}
		if(type==ComplexSourcePathNodeType.MAP)
		{			
			jmethod.body().assign(decl, invoke);
			final JInvocation invoke2 = decl.invoke("get");			
			invoke2.arg(JExpr.direct(complexParam.toString()));
			return invoke2;
		}
		return invoke;
	}

	public void addParamToSetMethod() {

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
