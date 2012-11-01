package github.compile.mapper.service;

import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.ComplexSourcePathNodeType;
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
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class ComplexMapperSourceGeneratorTest extends TestCase{

	private static final String TEST_PACKAGE = "test.mapper.";
	private static final String PATH_TO_PUT = "./src/test/java";
	
	public void testGenerateMapperComplex0() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperComplex0", SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();

		SimpleMappingDefinition e = new SimpleMappingDefinition();

		final List<PathNode> targetPath = new ArrayList<PathNode>();
		PathNode node = new PathNode();
		node.setClazz(InnerTargetClass1.class.getName());
		node.setField("target3");
		targetPath.add(node);

		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("stringArray");
		node.setComplexParam("2");
		node.setType(ComplexSourcePathNodeType.ARRAY.getType());
		targetPath.add(node);

		e.setTargetPath(targetPath);

		final List<PathNode> sourcePath = new ArrayList<PathNode>();
		node = new PathNode();
		node.setClazz(InnerSourceClass1.class.getName());
		node.setField("src1");
		sourcePath.add(node);

		node = new PathNode();
		node.setClazz(InnerSourceClass2.class.getName());
		node.setField("tgArray");
		node.setComplexParam("0");
		node.setType("array");
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		XStream s = new XStream();
		final String xml = s.toXML(definitions);
	}
	
	public void testGenerateMapperComplex1() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperComplex1", SourceObject.class, TargetObject.class);
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
		node.setField("tgArray");
		node.setComplexParam("0");
		node.setType("array");
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		XStream s = new XStream();
		final String xml = s.toXML(definitions);
	}
	
	
	public void testGenerateMapperComplex2() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperComplex2", SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();

		SimpleMappingDefinition e = new SimpleMappingDefinition();

		final List<PathNode> targetPath = new ArrayList<PathNode>();
		PathNode node = new PathNode();
		node.setClazz(InnerTargetClass1.class.getName());
		node.setField("target3");
		targetPath.add(node);

		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("stringList");
		node.setComplexParam("2");
		node.setType(ComplexSourcePathNodeType.LIST.getType());
		targetPath.add(node);

		e.setTargetPath(targetPath);

		final List<PathNode> sourcePath = new ArrayList<PathNode>();
		node = new PathNode();
		node.setClazz(InnerSourceClass1.class.getName());
		node.setField("src1");
		sourcePath.add(node);

		node = new PathNode();
		node.setClazz(InnerSourceClass2.class.getName());
		node.setField("tgArray");
		node.setComplexParam("0");
		node.setType("array");
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		XStream s = new XStream();
		final String xml = s.toXML(definitions);
	}
	
	public void testGenerateMapperComplex3() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperComplex3", SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();

		SimpleMappingDefinition e = new SimpleMappingDefinition();

		final List<PathNode> targetPath = new ArrayList<PathNode>();
		PathNode node = new PathNode();
		node.setClazz(InnerTargetClass1.class.getName());
		node.setField("target3");
		targetPath.add(node);

		node = new PathNode();
		node.setClazz(String.class.getName());
		node.setField("stringMap");
		node.setComplexParam("2");
		node.setType(ComplexSourcePathNodeType.MAP.getType());
		targetPath.add(node);

		e.setTargetPath(targetPath);

		final List<PathNode> sourcePath = new ArrayList<PathNode>();
		node = new PathNode();
		node.setClazz(InnerSourceClass1.class.getName());
		node.setField("src1");
		sourcePath.add(node);

		node = new PathNode();
		node.setClazz(InnerSourceClass2.class.getName());
		node.setField("tgArray");
		node.setComplexParam("0");
		node.setType("array");
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		XStream s = new XStream();
		final String xml = s.toXML(definitions);
	}
}
