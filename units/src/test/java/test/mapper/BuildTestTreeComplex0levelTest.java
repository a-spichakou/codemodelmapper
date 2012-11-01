package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class BuildTestTreeComplex0levelTest extends TestCase{
	public void testMapping()
	{
		final BuildTestTreeComplex0level mapper = new BuildTestTreeComplex0level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.map();
		
		final int[] level1primitiveArray = mapper.target.getLevel0primitiveArray();
		assertNotNull(level1primitiveArray);
		assertEquals(97, level1primitiveArray[11]);
		
		final String[] level1StriingArray = mapper.target.getLevel0StriingArray();
		assertNotNull(level1StriingArray);
		assertEquals("StringValueComplexLevel0", level1StriingArray[13]);
		
		final Date[] level1Complex = mapper.target.getLevel0DateArray();
		assertNotNull(level1Complex);		
				
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		
		Date parse=null;
		try {
			parse = formatter.parse("2012-10-11 12:15:22 -0200");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		assertEquals(parse,level1Complex[2]);
	}
}
