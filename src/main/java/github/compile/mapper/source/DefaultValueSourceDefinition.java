package github.compile.mapper.source;

import java.util.Date;

import com.sun.codemodel.JMethod;

public class DefaultValueSourceDefinition extends AbstractSourceDefinition implements ISourceDefinition {
	private Object defultValue;

	public Object getDefultValue() {
		return defultValue;
	}

	public void setDefultValue(Object defultValue) {
		this.defultValue = defultValue;
	}

	public JMethod extendJMethod(JMethod method) {

		final StringBuffer statement = new StringBuffer();
		statement.append("// Set default value\r\n");
		statement.append(TARGET_MEMBER);
		statement.append(".");
		statement.append(getTargetMethod().getName());
		statement.append("(");
		final String guessDefaultValueType = guessDefaultValueType();
		statement.append(guessDefaultValueType);
		statement.append(");");

		final String statementStr = statement.toString();
		method.body().directStatement(statementStr);
		return method;
	}

	private String guessDefaultValueType() {
		if (defultValue == null) {
			return "";
		}

		if (defultValue instanceof Date) {
			return "new Date(" + ((Date) defultValue).getTime() + "l)";
		} else {
			return defultValue.toString();
		}
	}
}
