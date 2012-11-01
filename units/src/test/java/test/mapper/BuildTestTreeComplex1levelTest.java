package test.mapper;

import github.compile.mapper.test.Source;
import github.compile.mapper.test.Target;
import github.compile.mapper.test.TargetLevel1;
import junit.framework.TestCase;

public class BuildTestTreeComplex1levelTest extends TestCase{
	public void testMapping()
	{
		final BuildTestTreeComplex1level mapper = new BuildTestTreeComplex1level();
		mapper.source = new Source();
		mapper.target = new Target();
		
		mapper.map();
		final TargetLevel1 level1 = mapper.target.getLevel1();
		assertNotNull(level1);
		
		final int[] level1primitiveArray = level1.getLevel1primitiveArray();
		assertNotNull(level1primitiveArray);
		
		assertEquals(96,level1primitiveArray[2]);
		
		final String[] level1StriingArray = level1.getLevel1StriingArray();
		assertNotNull(level1StriingArray);
		
		assertEquals("StringValueComplexLevel1",level1StriingArray[1]);		
	}

}
