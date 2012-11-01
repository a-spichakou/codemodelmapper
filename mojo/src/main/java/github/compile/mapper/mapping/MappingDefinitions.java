package github.compile.mapper.mapping;

import java.util.List;
/**
 * Container for mapping definitions
 * @author aspichakou
 *
 */
public class MappingDefinitions {

	private List<IMappingDefinition> definitions;

	public List<IMappingDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<IMappingDefinition> definitions) {
		this.definitions = definitions;
	}
}
