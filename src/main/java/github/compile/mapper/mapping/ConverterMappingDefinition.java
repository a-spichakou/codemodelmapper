package github.compile.mapper.mapping;

public class ConverterMappingDefinition extends SimpleMappingDefinition {

	public static final String ConverterMappingDefinition = "ConverterMappingDefinition";

	private String covrenerClass;
	private String convertMethod;

	@Override
	public String getType() {
		return ConverterMappingDefinition;
	}

	public String getCovrenerClass() {
		return covrenerClass;
	}

	public void setCovrenerClass(String covrenerClass) {
		this.covrenerClass = covrenerClass;
	}

	public String getConvertMethod() {
		return convertMethod;
	}

	public void setConvertMethod(String convertMethod) {
		this.convertMethod = convertMethod;
	}

}
