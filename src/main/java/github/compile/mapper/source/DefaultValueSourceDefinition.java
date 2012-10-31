package github.compile.mapper.source;

import java.util.Date;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
/**
 * Source definition for constant value
 * @author aspichakou
 *
 */
public class DefaultValueSourceDefinition extends AbstractSourceDefinition{
	private Object defultValue;

	public Object getDefultValue() {
		return defultValue;
	}

	public void setDefultValue(Object defultValue) {
		this.defultValue = defultValue;
	}

	/**
	 * Map method generator
	 */
	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {

		getValueMethod = buildGetValueMethod(codeModel, mapClass);
		final JMethod jmethod = mapClass.method(JMod.PUBLIC, Void.TYPE, MAP_VALE_METHOD_NAME+"_"+getTargetField().name());
		buildSetStatement(jmethod, codeModel, getValueMethod);
		
		return jmethod;
	}
	
	/**
	 * Put constant value to separate getValue() method
	 * @param mapClass
	 * @return
	 */
	private JMethod buildGetValueMethod(JCodeModel codeModel, JDefinedClass mapClass)
	{
		final JMethod method = mapClass.method(JMod.PUBLIC, defultValue.getClass(), GET_VALUE_METHOD_NAME);
		if(defultValue instanceof Integer)
		{
			method.body()._return(JExpr.lit((Integer)defultValue));
		}
		if(defultValue instanceof Boolean)
		{
			method.body()._return(JExpr.lit((Boolean)defultValue));
		}
		if(defultValue instanceof Character)
		{
			method.body()._return(JExpr.lit((Character)defultValue));
		}
		if(defultValue instanceof Double)
		{
			method.body()._return(JExpr.lit((Double)defultValue));
		}
		if(defultValue instanceof Float)
		{
			method.body()._return(JExpr.lit((Float)defultValue));
		}
		if(defultValue instanceof Long)
		{
			method.body()._return(JExpr.lit((Long)defultValue));
		}
		if(defultValue instanceof String)
		{
			method.body()._return(JExpr.lit((String)defultValue));
		}
		if(defultValue instanceof Date)
		{
			final JInvocation newDate= JExpr._new(codeModel.ref(Date.class));
			newDate.arg(JExpr.lit(((Date)defultValue).getTime()));
			method.body()._return(newDate);
		}
		return method;
	}
}
