package github.compile.mapper.source;

import java.lang.reflect.Method;

public class ConverterSourceDefinition extends SimpleSourceDefinition {
	private static final String CONVERTER_VALUE_METHOD_NAME = "converter";
	private static final String CONVERTER_VALUE_MEMBER_NAME = "convert";
	private Class converterClass;
	private Method converterMethod;

	public Class getConverterClass() {
		return converterClass;
	}

	public void setConverterClass(Class converterClass) {
		this.converterClass = converterClass;
	}

	public Method getConverterMethod() {
		return converterMethod;
	}

	public void setConverterMethod(Method converterMethod) {
		this.converterMethod = converterMethod;
	}

}
