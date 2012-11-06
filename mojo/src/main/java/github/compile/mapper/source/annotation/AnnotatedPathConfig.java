package github.compile.mapper.source.annotation;

import github.compile.mapper.mapping.IMappingDefinition;

import java.util.HashMap;
import java.util.Map;

public class AnnotatedPathConfig {

	private Map<String, IMappingDefinition> pathConfigMap = new HashMap<String, IMappingDefinition>();
	
	public Map<String, IMappingDefinition> getPathConfigMap() {
		return pathConfigMap;
	}

	public void setPathConfigMap(Map<String, IMappingDefinition> pathConfigMap) {
		this.pathConfigMap = pathConfigMap;
	}

	public IMappingDefinition getDefinitionByIndex(String index)
	{
		final IMappingDefinition iMappingDefinition = pathConfigMap.get(index);
		return iMappingDefinition;
	}
	
	public void putDefinitionByIndex(String index, IMappingDefinition iMappingDefinition)
	{
		pathConfigMap.put(index, iMappingDefinition);		
	}
		
}
