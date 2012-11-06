package github.compile.mapper.mapping;

import java.util.List;

public interface IMappingDefinition {
	
	public String getType();
	
	public void setTargetPath(List<PathNode> targetPath);

}
