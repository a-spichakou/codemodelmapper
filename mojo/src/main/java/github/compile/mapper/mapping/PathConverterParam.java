package github.compile.mapper.mapping;

import java.util.List;

public class PathConverterParam implements IConverterParam {
	private List<PathNode> sourcePath;

	public List<PathNode> getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(List<PathNode> sourcePath) {
		this.sourcePath = sourcePath;
	}	
}
