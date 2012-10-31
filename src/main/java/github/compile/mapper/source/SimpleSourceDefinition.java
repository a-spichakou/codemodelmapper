package github.compile.mapper.source;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

/**
 * Simple mapper from one node of Source object to one field in Target object 
 * @author aspichakou
 *
 */
public class SimpleSourceDefinition extends AbstractSourceDefinition {

	/**
	 * Generator for separate map method
	 */
	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {
		getValueMethod = mapClass.method(JMod.PUBLIC, Object.class, GET_VALUE_METHOD_NAME);
		buildGetStatement(getValueMethod, codeModel);		
		
		final JMethod jmethod = mapClass.method(JMod.PUBLIC, Void.TYPE, MAP_VALE_METHOD_NAME+"_"+getTargetField().name());		
		buildSetStatement(jmethod, codeModel, getValueMethod);
		
		return jmethod;
	}
	

}
