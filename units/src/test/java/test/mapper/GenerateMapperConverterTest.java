package test.mapper;


import github.compile.mapper.source.SimpleConverter;
import github.compile.mapper.test1.InnerSourceClass1;
import github.compile.mapper.test1.InnerSourceClass2;
import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.InnerTargetClass2;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;

import junit.framework.TestCase;

public class GenerateMapperConverterTest extends TestCase{
	public void testConverMapping() {
		final GenerateMapperConverter mapper = new GenerateMapperConverter();
		mapper.source = new SourceObject();
		final InnerSourceClass1 src1 = new InnerSourceClass1();
		mapper.source.setSrc1(src1);
		mapper.source.setParam1("paramValue2");

		final InnerSourceClass2 src2 = new InnerSourceClass2();
		src1.setSrc2(src2);
		src2.setSource("param1");
		mapper.target = new TargetObject();
		mapper.converter0 = new SimpleConverter();

		mapper.map();

		final InnerTargetClass1 target3 = mapper.target.getTarget3();
		assertNotNull(target3);
		final InnerTargetClass2 tg2 = target3.getTg2();
		assertNotNull(tg2);
		final String tg1 = tg2.getTg3();
		assertEquals("param1param2", tg1);
	}
}
