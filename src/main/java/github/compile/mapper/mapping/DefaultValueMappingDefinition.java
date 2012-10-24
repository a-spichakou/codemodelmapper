package github.compile.mapper.mapping;

import java.util.List;

public class DefaultValueMappingDefinition implements IMappingDefinition {
	private Object defaultValue;
	private List<PathNode> targetPath;

	public List<PathNode> getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(List<PathNode> targetPath) {
		this.targetPath = targetPath;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

}
