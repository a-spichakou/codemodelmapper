package github.compile.mapper.service;

import github.compile.mapper.mapping.ConverterMappingDefinition;
import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IConverterParam;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.LookupMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.PathConverterParam;
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

import junit.framework.TestCase;

import com.sun.codemodel.JCodeModel;

public class MapperSourceGeneratorTest extends TestCase {

	private static final String TEST_PACKAGE = "test.mapper.";
	private static final String PATH_TO_PUT = "./src/test/java";

	public void testGenerateMapperDefaultValue() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperDefaultValue", SourceObject.class, TargetObject.class);
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}	
	}

	public void testGenerateMapperSimple() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperSimple", SourceObject.class, TargetObject.class);
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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void testGenerateMapperLookup() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperLookup", SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();

		LookupMappingDefinition e = new LookupMappingDefinition();
		e.setLookupMethod("lookup");
		e.setMappingClass("github.compile.mapper.source.SimpleLookup");

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
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void testGenerateMapperConverter() {
		final MapperSourceGenerator generator = new MapperSourceGenerator(TEST_PACKAGE + "GenerateMapperConverter", SourceObject.class, TargetObject.class);
		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();

		ConverterMappingDefinition e = new ConverterMappingDefinition();
		e.setConvertMethod("convert");
		e.setCovrenerClass("github.compile.mapper.source.SimpleConverter");

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
		// adding converter params list
		final List<IConverterParam> converterParams = new ArrayList<IConverterParam>();
		final PathConverterParam pathConverterParam = new PathConverterParam();
		final List<PathNode> paramSourcePath = new ArrayList<PathNode>();
		final PathNode paramSourceNode = new PathNode();
		paramSourceNode.setClazz(String.class.getName());
		paramSourceNode.setField("param1");
		paramSourcePath.add(paramSourceNode);
		pathConverterParam.setSourcePath(paramSourcePath);
		
		converterParams.add(pathConverterParam);
		e.setConverterParams(converterParams);
		
		definitions.setDefinitions(definitionList);

		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
}
