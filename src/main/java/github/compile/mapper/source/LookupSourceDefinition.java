package github.compile.mapper.source;

import java.lang.reflect.Method;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;

public class LookupSourceDefinition extends AbstractSourceDefinition {
	private Class lookupClass;
	private Method lookupMethod;

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

	public JMethod extendJMethod(JMethod method) {
		// TODO Auto-generated method stub
		return method;
	}

	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
