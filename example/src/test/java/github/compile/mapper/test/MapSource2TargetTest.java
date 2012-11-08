package github.compile.mapper.test;

import github.compile.example.SampleConverter;
import github.compile.example.Source;

import java.util.Date;

import junit.framework.TestCase;

public class MapSource2TargetTest extends TestCase{
	
	public void testMapper(){
		final MapSource2Target mapper = new MapSource2Target();
		
		mapper.source = new Source();
		mapper.target = new github.compile.example.Target();
		
		mapper.source.setLevel0primitive(99);		
		final Date level0Complex = new Date();
		mapper.source.setLevel0Complex(level0Complex);		
		mapper.converter = new SampleConverter();
		
		mapper.map();
		
		// test simple mapping
		assertEquals(99, mapper.target.getLevel0primitive());
		// test default value mapping
		assertEquals("dafultValue", mapper.target.getLevel0String());
		// converter
		assertEquals(level0Complex.getYear(), mapper.target.getLevel1().getLevel1primitiveArray()[2]);
		
		
	}
}
