package github.compile.mapper.service;

import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JCodeModel;

import junit.framework.TestCase;

public class MapperSourceGeneratorTest extends TestCase {

	public void testGenerateMapperDefaultValue()
	{		
		final MapperSourceGenerator generator = new MapperSourceGenerator("test.mapper.GenerateMapperDefaultValue",SourceObject.class, TargetObject.class);
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
		node.setField("tg2");		
		targetPath.add(node);
		
		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("tg3");		
		targetPath.add(node);
		
		e.setTargetPath(targetPath);
		
		definitionList.add(e);
		
		definitions.setDefinitions(definitionList);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File("./src/test/java"));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
	}
	
	public void testGenerateMapperSimple()
	{		
		final MapperSourceGenerator generator = new MapperSourceGenerator("test.mapper.GenerateMapperSimple",SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();
		
		SimpleMappingDefinition e = new SimpleMappingDefinition();
		
		final List<PathNode> targetPath = new ArrayList<PathNode>();
		PathNode node = new PathNode();
		node.setClazz(InnerTargetClass1.class.getName());
		node.setField("target3");		
		targetPath.add(node);
		
		node = new PathNode();
		node.setClazz(InnerTargetClass2.class.getName());
		node.setField("tg2");		
		targetPath.add(node);
		
		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("tg3");		
		targetPath.add(node);
		
		e.setTargetPath(targetPath);
		
		final List<PathNode> sourcePath = new ArrayList<PathNode>();
		node = new PathNode();
		node.setClazz(InnerSourceClass1.class.getName());
		node.setField("src1");		
		sourcePath.add(node);
		
		node = new PathNode();
		node.setClazz(InnerSourceClass2.class.getName());
		node.setField("src2");		
		sourcePath.add(node);
		
		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("source");		
		sourcePath.add(node);
		
		e.setSourcePath(sourcePath);			
		definitionList.add(e);
		definitions.setDefinitions(definitionList);
				
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File("./src/test/java"));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
	}
}
