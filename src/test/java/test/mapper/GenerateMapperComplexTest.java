package test.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import github.compile.mapper.source.InnerSourceClass1;
import github.compile.mapper.source.InnerSourceClass2;
import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;
import junit.framework.TestCase;

public class GenerateMapperComplexTest extends TestCase{
	
	public void testComplex3Mapping()
	{
		final GenerateMapperComplex3 mapper = new GenerateMapperComplex3();
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
		final HashMap stringMap = target3.getStringMap();
		assertNotNull(stringMap);
		final String tg1 = (String)stringMap.get("2");
		assertEquals("value", tg1);
	}
	
	public void testComplex2Mapping()
	{
		final GenerateMapperComplex2 mapper = new GenerateMapperComplex2();
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
		final ArrayList stringList = target3.getStringList();		
		assertNotNull(stringList);
		final String tg1 = (String)stringList.get(2);
		assertEquals("value", tg1);
	}
	
	public void testComplex1Mapping()
	{
		final GenerateMapperComplex1 mapper = new GenerateMapperComplex1();
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
		final String tg3 = tg2.getTg3();
		assertEquals("value", tg3);
	}

	public void testComplex0Mapping()
	{
		final GenerateMapperComplex0 mapper = new GenerateMapperComplex0();
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
		final String[] stringArray = target3.getStringArray();
		assertNotNull(stringArray);		
		assertEquals("value", stringArray[2]);
	}

}
