package github.compile.mapper.source;

import github.compile.mapper.mapping.AbstractConverterParam;

public class StringConverterParam extends AbstractConverterParam {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
