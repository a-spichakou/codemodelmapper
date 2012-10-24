package github.compile.mapper.source;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

public class SimpleSourceDefinition extends AbstractSourceDefinition {

	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {
		final JMethod getValueMethod = mapClass.method(JMod.PUBLIC, Void.TYPE, GET_VALUE_METHOD_NAME);
		buildGetStatement(getValueMethod, codeModel);		
		
		final JMethod jmethod = mapClass.method(JMod.PUBLIC, Void.TYPE, MAP_VALE_METHOD_NAME+"_"+getTargetField().name());		
		buildSetStatement(jmethod, codeModel, getValueMethod);
		
		return jmethod;
	}
	

}
