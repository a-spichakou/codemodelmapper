package github.compile.mapper.source;

import java.util.List;
/**
 * Source definition container
 * @author aspichakou
 *
 */
public class SourceDefinitions {

	private List<ISourceDefinition> definitions;

	public List<ISourceDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<ISourceDefinition> definitions) {
		this.definitions = definitions;
	}

}
