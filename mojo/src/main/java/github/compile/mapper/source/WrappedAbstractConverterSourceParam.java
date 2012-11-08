package github.compile.mapper.source;

import github.compile.mapper.mapping.AbstractConverterParam;

public class WrappedAbstractConverterSourceParam extends AbstractConverterSourceParam {

	private AbstractConverterParam valueContainer;

	@Override
	public Object getValue() {
		return valueContainer.getValue();
	}

	public void setContainer(AbstractConverterParam valueContainer)
	{
		this.valueContainer = valueContainer;
	}
}