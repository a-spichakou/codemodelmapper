package github.compile.mapper.service;

import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MapperSourceGeneratorTest extends TestCase {

	public void testGenerateMapper()
	{		
		final MapperSourceGenerator generator = new MapperSourceGenerator("test.mapper.Mapper",SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();
		
		DefaultValueMappingDefinition e = new DefaultValueMappingDefinition();
		e.setDefaultValue("defaultValue");
		final List<PathNode> targetPath = new ArrayList<PathNode>();
		PathNode node = new PathNode();
		node.setClazz(InnerTargetClass1.class.getName());
		node.setField("target3");		
		targetPath.add(node);
		
		node = new PathNode();
		node.setClazz(InnerTargetClass2.class.getName());
		node.setField("tg3");		
		targetPath.add(node);
		
		e.setTargetPath(targetPath);
		
		definitionList.add(e);
		
		definitions.setDefinitions(definitionList);
		
		try {
			generator.generateMapper(definitions);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
	}
}
