package github.compile.mapper.source;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;

public interface ISourceDefinition {
	public static final String GET_VALUE_METHOD_NAME = "getValue";
	public static final String MAP_VALE_METHOD_NAME = "map";

	public static final String SOURCE_MEMBER = "source";
	public static final String TARGET_MEMBER = "target";

	public JMethod extendJMethod(JCodeModel codeModel, JDefinedClass mapClass);

	public void setTargetField(JFieldVar targetField);

	public void setSourceField(JFieldVar sourceField);
}
