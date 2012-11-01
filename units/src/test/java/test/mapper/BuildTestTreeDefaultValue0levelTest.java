package test.tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

public class BuildTestTreeDefaultValue0levelTest extends TestCase{
	
	public void testMapping()
	{
		final BuildTestTreeDefaultValue0level mapper = new BuildTestTreeDefaultValue0level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.map();
		
		assertEquals(99,mapper.target.getLevel0primitive());
		assertEquals("StringValue",mapper.target.getLevel0String());
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		
		Date parse=null;
		try {
			parse = formatter.parse("2012-10-31 12:15:22 -0200");
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		assertEquals(parse,mapper.target.getLevel0Complex());
	}

}
