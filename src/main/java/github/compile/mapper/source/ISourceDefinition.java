package github.compile.mapper.source;

import com.sun.codemodel.JMethod;

public interface ISourceDefinition {
	
	public static final String SOURCE_MEMBER="source";
	public static final String TARGET_MEMBER="target";

	public JMethod extendJMethod(JMethod method);

}
