package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import junit.framework.TestCase;

public class BuildTestTreeSimple0levelTest extends TestCase{
	
	public void testMapping()
	{
		final BuildTestTreeSimple0level mapper = new BuildTestTreeSimple0level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.source.setLevel0primitive(99);
		mapper.source.setLevel0String("level0String");
		final Date level0Complex = new Date();
		mapper.source.setLevel0Complex(level0Complex);
		
		mapper.source.setLevel0primitiveArray(new int[]{16,15});
		final ArrayList level0List = new ArrayList();
		level0List.add("1");
		level0List.add("2");
		mapper.source.setLevel0List(level0List);
		HashMap level0Map = new HashMap();
		level0Map.put("key1","value1");
		level0Map.put("key2","value2");
		mapper.source.setLevel0Map(level0Map);
		
		mapper.map();
		
		assertEquals(99, mapper.target.getLevel0primitive());
		assertEquals("level0String", mapper.target.getLevel0String());
		assertEquals(level0Complex, mapper.target.getLevel0Complex());
		
		final int[] level0primitiveArray = mapper.target.getLevel0primitiveArray();
		assertNotNull(level0primitiveArray);
		assertEquals(15, level0primitiveArray[2]);
		final ArrayList level0List2 = mapper.target.getLevel0List();
		assertNotNull(level0List2);
		assertEquals("2", level0List2.get(2));
		final HashMap level0Map2 = mapper.target.getLevel0Map();
		assertNotNull(level0Map2);
		assertEquals("value1", level0Map2.get("key2"));
	}

}
