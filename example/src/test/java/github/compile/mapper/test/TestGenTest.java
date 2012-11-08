package github.compile.mapper.test;

import github.compile.mapper.mapping.ConverterMappingDefinition;
import github.compile.mapper.mapping.IConverterParam;
import github.compile.mapper.mapping.LookupMappingDefinition;
import github.compile.mapper.source.StringConverterParam;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.thoughtworks.xstream.XStream;

public class TestGenTest extends TestCase{
	
	public void testGenerate()
	{
		// converter		
		final ConverterMappingDefinition def = new ConverterMappingDefinition();
		def.setConvertMethod("convert");
		final List<IConverterParam> converterParams = new ArrayList<IConverterParam>();
		StringConverterParam stringConverterParam1 = new StringConverterParam();
		
		converterParams.add(stringConverterParam1);
		
		def.setConverterParams(converterParams);
		def.setCovrenerClass("github.compile.example.SampleConverter");
		
		// lookup
		final LookupMappingDefinition def1 = new LookupMappingDefinition();
		def1.setLookupMethod("lookup");
		def1.setMappingClass("github.compile.example.SampleLookup");		

		final XStream xstream = new XStream();
		
		final String xml = xstream.toXML(def);
		final String xml1 = xstream.toXML(def1);
		
	}

}
