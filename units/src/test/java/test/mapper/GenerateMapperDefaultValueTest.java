package test.mapper;

import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.InnerTargetClass2;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;
import junit.framework.TestCase;


public class GenerateMapperDefaultValueTest extends TestCase{
	
	public void testDeafultValue()
	{
		final GenerateMapperDefaultValue mapper = new GenerateMapperDefaultValue();
		mapper.source = new SourceObject();
		mapper.target = new TargetObject();
		mapper.map();
		
		final InnerTargetClass1 target3 = mapper.target.getTarget3();
		assertNotNull(target3);
		final InnerTargetClass2 tg2 = target3.getTg2();
		assertNotNull(tg2);
		final String tg3 = tg2.getTg3();
		assertEquals(tg3,"defaultValue");
	}

}
