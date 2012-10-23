package github.compile.mapper.service;

import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.service.MapperSourceGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;


public class MapperSourceGeneratorTest extends TestCase {

	public void testGenerateMapper()
	{		
		
		final MappingDefinitions definitions = new MappingDefinitions();
		
		final DefaultValueMappingDefinition def1 = new DefaultValueMappingDefinition();
		def1.setDefaultValue(new Date());
		def1.setTargetPath("target1");
		final SimpleMappingDefinition def2 = new SimpleMappingDefinition();
		def2.setSourcePath("param2");
		def2.setTargetPath("target2");
		
		
		final List<IMappingDefinition> list = new ArrayList<IMappingDefinition>();
		list.add(def1);
		list.add(def2);
		
		final MapperSourceGenerator generator = new MapperSourceGenerator(SourceObject.class,TargetObject.class, "test.mapper.Mapper");	
		definitions.setDefinitions(list );
		try {
			generator.generateMapper(definitions);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	public class SourceObject {
		private String param1;
		private String param2;		

		public String getParam1() {
			return param1;
		}

		public void setParam1(String param1) {
			this.param1 = param1;
		}

		public String getParam2() {
			return param2;
		}

		public void setParam2(String param2) {
			this.param2 = param2;
		}
	}
	
	public class TargetObject
	{
		private Date target1;
		private String target2;
		public Date getTarget1() {
			return target1;
		}
		public void setTarget1(Date target1) {
			this.target1 = target1;
		}
		public String getTarget2() {
			return target2;
		}
		public void setTarget2(String target2) {
			this.target2 = target2;
		}		
	}
}
