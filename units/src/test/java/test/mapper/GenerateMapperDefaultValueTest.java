package test.mapper;

import junit.framework.TestCase;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

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
