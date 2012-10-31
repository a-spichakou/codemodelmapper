package test.tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class BuildTestTreeDefaultValue1levelTest extends TestCase{
	
	public void testMapping()
	{
		final BuildTestTreeDefaultValue1level mapper = new BuildTestTreeDefaultValue1level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.map();
		final TargetLevel1 level1 = mapper.target.getLevel1();
		assertNotNull(level1);
		
		assertEquals(98,level1.getLevel1primitive());
		assertEquals("StringValueLevel1",level1.getLevel1String());
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		
		Date parse=null;
		try {
			parse = formatter.parse("2012-11-15 12:15:22 -0200");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		assertEquals(parse,level1.getLevel1Complex());
	}

}
