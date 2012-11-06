package github.compile.mapper.source;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;

public class ConverterSourceDefinition extends SimpleSourceDefinition {
	private static final String CONVERTER_PARAM_METHOD_NAME = "getParam";
	private static final String CONVERTER_CONVERT_METHOD_NAME = "convert";
	private static final String CONVERTER_VALUE_MEMBER_NAME = "converter";
	private Class<?> converterClass;
	private Method converterMethod;

	private List<IConverterSourceParam> converterSourceParams;
	
	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {
		// Create getParam() method
		final JMethod getParams = mapClass.method(JMod.PUBLIC, List.class, CONVERTER_PARAM_METHOD_NAME);
		buildGetParamsMethod(getParams, codeModel, mapClass);
		
		// build getValue method
		final JMethod convertMethod = mapClass.method(JMod.PUBLIC, converterMethod.getReturnType(), CONVERTER_CONVERT_METHOD_NAME);
		buildInvokeConverterMethod(convertMethod, getParams, codeModel, mapClass);
		
		// build set method
		getValueMethod = mapClass.method(JMod.PUBLIC, Void.TYPE, getMapMethodName());		
		buildSetStatement(getValueMethod, codeModel, convertMethod);		
		
		return getValueMethod;
	}
	
	private void buildInvokeConverterMethod(JMethod jmethod, JMethod getParams, JCodeModel codeModel, JDefinedClass mapClass)
	{
		// create filed with converter object
		final JFieldVar converterMemberField = mapClass.field(JMod.PUBLIC, converterClass, CONVERTER_VALUE_MEMBER_NAME);
		
		
		final JConditional nullCheck = jmethod.body()._if(JExpr.direct(converterMemberField.name()+"==null"));
		nullCheck._then()._return(JExpr._null());
		
		// create class method getValue()
		final JMethod getValueMethod = mapClass.method(JMod.PUBLIC, Object.class, GET_VALUE_METHOD_NAME);
		buildGetStatement(getValueMethod, codeModel);
		
		// invoke getValue() method and set to "value" var
		final JVar value = jmethod.body().decl(getValueMethod.type(), "value");
		jmethod.body().assign(value, JExpr.invoke(getValueMethod));
		
		// invoke converetr method		
		final JInvocation invoke = converterMemberField.invoke(converterMethod.getName());
		// take convert method first arg type
		final JType lookupMethodArgType = codeModel._ref(converterMethod.getParameterTypes()[0]);
		final JVar valueCastedToLookupArg = jmethod.body().decl(lookupMethodArgType, "valueCasted");
		final JExpressionImpl cast = JExpr.cast(lookupMethodArgType, value);
		// invoke convert() method
		jmethod.body().assign(valueCastedToLookupArg, cast);
		
		invoke.arg(valueCastedToLookupArg);
		// Add second param as list of getParams() 
		invoke.arg(JExpr.invoke(getParams));
		
		jmethod.body().add(invoke);		
		jmethod.body()._return(invoke);
	}
	
	private void buildGetParamsMethod(JMethod getParams, JCodeModel codeModel, JDefinedClass mapClass)
	{	
		// add local var:
		// List params = new ArrayList();
		final JVar paramsList = getParams.body().decl(codeModel.ref(List.class), "params", JExpr._new(codeModel.ref(ArrayList.class)));
		
		int idx = 0;
		for(IConverterSourceParam param:converterSourceParams)
		{
			if(param instanceof PathConverterSourceParam)
			{
				final PathConverterSourceParam pathConverterSourceParam = (PathConverterSourceParam)param;
				pathConverterSourceParam.setSourceField(getSourceField());
				// Build separate getter for every param in list
				// public Object getParam0(){};
				final JMethod getParamMethod = mapClass.method(JMod.PUBLIC, Object.class, CONVERTER_PARAM_METHOD_NAME+"_"+idx);
				idx++;
				pathConverterSourceParam.buildGetStatement(getParamMethod, codeModel);
				// Add result of invoke of method getParam0 to list
				final JInvocation invoke = paramsList.invoke("add");
				invoke.arg(JExpr.invoke(getParamMethod));
				getParams.body().add(invoke);
			}
		}
		// add return statement
		getParams.body()._return(paramsList);
	}
	
	public Class<?> getConverterClass() {
		return converterClass;
	}

	public void setConverterClass(Class<?> converterClass) {
		this.converterClass = converterClass;
	}

	public Method getConverterMethod() {
		return converterMethod;
	}

	public void setConverterMethod(Method converterMethod) {
		this.converterMethod = converterMethod;
	}

	public List<IConverterSourceParam> getConverterSourceParams() {
		return converterSourceParams;
	}

	public void setConverterSourceParams(List<IConverterSourceParam> converterSourceParams) {
		this.converterSourceParams = converterSourceParams;
	}

}
