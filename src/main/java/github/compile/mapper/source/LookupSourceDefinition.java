package github.compile.mapper.source;

import java.lang.reflect.Method;

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

public class LookupSourceDefinition extends AbstractSourceDefinition {
	private static final String LOOKUP_VALUE_METHOD_NAME = "lookup";
	private static final String LOOKUP_VALUE_MEMBER_NAME = "lookup";
	private Class lookupClass;
	private Method lookupMethod;

	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {
		// build lookup method
		final JMethod lookup = mapClass.method(JMod.PUBLIC, lookupMethod.getReturnType(), LOOKUP_VALUE_METHOD_NAME+"_"+getTargetField().name());
		buildLookupMethod(lookup, codeModel, mapClass);
		
		// build set method
		final JMethod setMethod = mapClass.method(JMod.PUBLIC, Void.TYPE, MAP_VALE_METHOD_NAME+"_"+getTargetField().name());		
		buildSetStatement(setMethod, codeModel, lookup);		
		
		return setMethod;
	}
	
	private void buildLookupMethod(JMethod jmethod, JCodeModel codeModel, JDefinedClass mapClass)
	{
		// create filed with lookup object
		final JFieldVar lookupMemberField = mapClass.field(JMod.PUBLIC, lookupClass, LOOKUP_VALUE_MEMBER_NAME);
		
		
		final JConditional nullCheck = jmethod.body()._if(JExpr.direct(lookupMemberField.name()+"==null"));
		nullCheck._then()._return(JExpr._null());
		
		// create class method getValue()
		final JMethod getValueMethod = mapClass.method(JMod.PUBLIC, Object.class, GET_VALUE_METHOD_NAME);
		buildGetStatement(getValueMethod, codeModel);
		
		// invoke getValue() method and set to "value" var
		final JVar value = jmethod.body().decl(getValueMethod.type(), "value");
		jmethod.body().assign(value, JExpr.invoke(getValueMethod));
		
		// invoke lookup method		
		final JInvocation invoke = lookupMemberField.invoke(lookupMethod.getName());
		// take lookup method first arg type
		final JType lookupMethodArgType = codeModel._ref(lookupMethod.getParameterTypes()[0]);
		final JVar valueCastedToLookupArg = jmethod.body().decl(lookupMethodArgType, "valueCasted");
		final JExpressionImpl cast = JExpr.cast(lookupMethodArgType, value);
		// invoke lookup method
		jmethod.body().assign(valueCastedToLookupArg, cast);
		
		invoke.arg(valueCastedToLookupArg);
		
		jmethod.body().add(invoke);		
		jmethod.body()._return(invoke);
	}
	
	public Class getLookupClass() {
		return lookupClass;
	}

	public void setLookupClass(Class lookupClass) {
		this.lookupClass = lookupClass;
	}

	public Method getLookupMethod() {
		return lookupMethod;
	}

	public void setLookupMethod(Method lookupMethod) {
		this.lookupMethod = lookupMethod;
	}
}
