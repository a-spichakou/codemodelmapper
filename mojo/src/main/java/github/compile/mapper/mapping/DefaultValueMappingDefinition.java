package github.compile.mapper.mapping;

import java.util.List;
/**
 * Mapping definition for constant
 * @author aspichakou
 *
 */
public class DefaultValueMappingDefinition implements IMappingDefinition {
	public static final String DefaultValueMappingDefinition="DefaultValueMappingDefinition";
	/**
	 * Constant value
	 */
	private Object defaultValue;
	/**
	 * Path to map in Target object
	 */
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

	public String getType() {		
		return DefaultValueMappingDefinition;
	}

}
