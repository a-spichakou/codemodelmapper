package github.compile.mapper.source;

import java.lang.reflect.Method;

import com.sun.codemodel.JMethod;

public class SimpleSourceDefinition extends AbstractSourceDefinition{
	private Class sourceClazz;	
	private Method sourceMethod;	

	public Class getSourceClazz() {
		return sourceClazz;
	}

	public void setSourceClazz(Class sourceClazz) {
		this.sourceClazz = sourceClazz;
	}

	public Method getSourceMethod() {
		return sourceMethod;
	}

	public void setSourceMethod(Method sourceMethod) {
		this.sourceMethod = sourceMethod;
	}

	public JMethod extendJMethod(JMethod method) {
		
		final StringBuffer statement = new StringBuffer();
		statement.append("// Set value from getter\r\n");		
		statement.append(TARGET_MEMBER);
		statement.append(".");
		statement.append(getTargetMethod().getName());
		statement.append("(");
		statement.append(SOURCE_MEMBER);
		statement.append("." );
		statement.append(sourceMethod.getName());
		statement.append("());");
		
		final String statementStr = statement.toString();
		method.body().directStatement(statementStr);
		return method;
	}
}
