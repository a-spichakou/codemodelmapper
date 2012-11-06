package github.compile.mapper.source.annotation;

import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;
import junit.framework.TestCase;

public class AnnotatedPathBuilderTest extends TestCase{

	public void testSimple()
	{
		final AnnotatedPathBuilder builder = new AnnotatedPathBuilder("/annotated/SimplePathConfig1.xml");
		
		final MappingDefinitions build = builder.build(Source.class, Target.class);
		assertNotNull(build);
	}
	
	/*public void testSaveConfig()
	{
		final AnnotatedPathConfig config = new AnnotatedPathConfig();
		final DefaultValueMappingDefinition defaultValueMappingDefinition = new DefaultValueMappingDefinition();
		defaultValueMappingDefinition.setDefaultValue("dafultValue");
		
		final SimpleMappingDefinition iMappingDefinition = new SimpleMappingDefinition();
		
		config.putDefinitionByIndex("level0primitive", iMappingDefinition);
		config.putDefinitionByIndex("level0String", defaultValueMappingDefinition);
		
		final XStream xstream = new XStream();
		
		final String xml = xstream.toXML(config);
		
	}*/
	
}
