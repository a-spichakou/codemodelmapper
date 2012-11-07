package github.compile.mapper.test;

import github.compile.example.Source;
import junit.framework.TestCase;

public class MapSource2TargetTest extends TestCase{
	
	public void testMapper(){
		final MapSource2Target mapper = new MapSource2Target();
		
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.source.setLevel0primitive(99);
		
		mapper.map();
		
		// test simple mapping
		assertEquals(99, mapper.target.getLevel0primitive());
		// test default value mapping
		assertEquals("dafultValue", mapper.target.getLevel0String());
		
	}
}
