package test.mapper;

import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;
import junit.framework.TestCase;

public class GenerateMapperComplexTest extends TestCase{
	
	public void testComplexMapping()
	{
		final GenerateMapperComplex mapper = new GenerateMapperComplex();
		mapper.source = new SourceObject();
		final InnerSourceClass1 src1 = new InnerSourceClass1(); 
		mapper.source.setSrc1(src1);
		
		InnerSourceClass2[] tgArray = new InnerSourceClass2[]{new InnerSourceClass2()};
		src1.setTgArray(tgArray);
		
		tgArray[0].setSource("value");
		
		mapper.target = new TargetObject();
				
		mapper.map();
	
		final InnerTargetClass1 target3 = mapper.target.getTarget3();
		assertNotNull(target3);
		final InnerTargetClass2 tg2 = target3.getTg2();
		assertNotNull(tg2);
		final String tg1 = tg2.getTg3();
		assertEquals("value", tg1);
	}


}
