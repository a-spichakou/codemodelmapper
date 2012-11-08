package github.compile.mapper.test;

import github.compile.mapper.mapping.ConverterMappingDefinition;
import github.compile.mapper.mapping.IConverterParam;
import github.compile.mapper.source.StringConverterParam;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.thoughtworks.xstream.XStream;

public class TestGenTest extends TestCase{
	
	public void testGenerate()
	{
		final ConverterMappingDefinition def = new ConverterMappingDefinition();
		def.setConvertMethod("convert");
		final List<IConverterParam> converterParams = new ArrayList<IConverterParam>();
		StringConverterParam stringConverterParam1 = new StringConverterParam();
		
		converterParams.add(stringConverterParam1);
		
		def.setConverterParams(converterParams);
		def.setCovrenerClass("github.compile.example.SampleConverter");

		final XStream xstream = new XStream();
		
		final String xml = xstream.toXML(def);
		
	}

}
