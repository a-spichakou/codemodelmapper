package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.SourceLevel1;
import github.compile.mapper.test.Target;
import github.compile.mapper.test.TargetLevel1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import junit.framework.TestCase;

public class BuildTestTreeSimple1levelTest extends TestCase{
	public void testMapping()
	{
		final BuildTestTreeSimple1level mapper = new BuildTestTreeSimple1level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		final SourceLevel1 level1 = new SourceLevel1();
		mapper.source.setLevel1(level1 );
		
		level1.setLevel1primitive(99);
		level1.setLevel1String("level0String");
		final Date level1Complex = new Date();
		level1.setLevel1Complex(level1Complex);
		
		level1.setLevel1primitiveArray(new int[]{16,15});
		final ArrayList level0List = new ArrayList();
		level0List.add("1");
		level0List.add("2");
		level1.setLevel1List(level0List);
		HashMap level1Map = new HashMap();
		level1Map.put("key1","value1");
		level1Map.put("key2","value2");
		level1.setLevel1Map(level1Map);
		
		mapper.map();
		
		final TargetLevel1 targetLevel1 = mapper.target.getLevel1();
		assertEquals(99, targetLevel1.getLevel1primitive());
		assertEquals("level0String",targetLevel1.getLevel1String());
		assertEquals(level1Complex, targetLevel1.getLevel1Complex());
		
		final int[] level0primitiveArray = targetLevel1.getLevel1primitiveArray();
		assertNotNull(level0primitiveArray);
		assertEquals(15, level0primitiveArray[2]);
		final ArrayList level1List2 = targetLevel1.getLevel1List();
		assertNotNull(level1List2);
		assertEquals("2", level1List2.get(2));
		final HashMap level0Map2 = targetLevel1.getLevel1Map();
		assertNotNull(level0Map2);
		assertEquals("value1", level0Map2.get("key2"));
	}
}
