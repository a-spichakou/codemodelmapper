package github.compile.mapper.mapping;

import java.util.List;

public class SimpleMappingDefinition extends DefaultValueMappingDefinition {
	private List<PathNode> sourcePath;

	public List<PathNode> getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(List<PathNode> sourcePath) {
		this.sourcePath = sourcePath;
	}

}
