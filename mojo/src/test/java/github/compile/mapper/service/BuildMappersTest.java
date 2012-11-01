package github.compile.mapper.service;

import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.service.MapperSourceGenerator;
import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

import java.io.File;

import junit.framework.TestCase;

import com.sun.codemodel.JCodeModel;
import com.thoughtworks.xstream.XStream;

public class BuildMappersTest extends TestCase{
	private static final String PATH_TO_PUT = "../unit/src/test/java";
	
	public void testBuildTestTreeDefaultValue0level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeDefaultValue_0level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeDefaultValue0level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testBuildTestTreeDefaultValue1level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeDefaultValue_1level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeDefaultValue1level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void testBuildTestTreeComplex0level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeComplex_0level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeComplex0level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void testBuildTestTreeComplex1level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeComplex_1level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeComplex1level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void testBuildTestTreeSimple0level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeSimple_0level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeSimple0level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void testBuildTestTreeSimple1level()
	{
		final XStream xstream = new XStream();
		final MappingDefinitions definitions = (MappingDefinitions)xstream.fromXML(getClass().getResourceAsStream("/TestTreeSimple_1level.xml"));
		final MapperSourceGenerator generator = new MapperSourceGenerator(getClass().getPackage().getName() + ".BuildTestTreeSimple1level", Source.class, Target.class);
		
		try {
			final JCodeModel generateMapper = generator.generateMapper(definitions);
			generateMapper.build(new File(PATH_TO_PUT));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
