package github.compile.mapper.source;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

public class DefaultValueSourceDefinition extends AbstractSourceDefinition{
	private Object defultValue;

	public Object getDefultValue() {
		return defultValue;
	}

	public void setDefultValue(Object defultValue) {
		this.defultValue = defultValue;
	}

	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {

		final JMethod getValueMethod = buildGetValueMethod(mapClass);
		final JMethod jmethod = mapClass.method(JMod.PUBLIC, Void.TYPE, MAP_VALE_METHOD_NAME+"_"+getTargetField().name());
		buildSetStatement(jmethod, codeModel, getValueMethod);
		
		return jmethod;
	}
	
	private JMethod buildGetValueMethod(JDefinedClass mapClass)
	{
		final JMethod method = mapClass.method(JMod.PUBLIC, defultValue.getClass(), GET_VALUE_METHOD_NAME);
		method.body()._return(JExpr.lit(defultValue.toString()));
		return method;
	}
}
