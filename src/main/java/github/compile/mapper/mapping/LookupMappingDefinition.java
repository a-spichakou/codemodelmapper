package github.compile.mapper.mapping;

public class LookupMappingDefinition extends SimpleMappingDefinition {
	public static final String LookupMappingDefinition="LookupMappingDefinition";

	private String mappingClass;
	private String lookupMethod;

	public String getMappingClass() {
		return mappingClass;
	}

	public void setMappingClass(String mappingClass) {
		this.mappingClass = mappingClass;
	}

	public String getLookupMethod() {
		return lookupMethod;
	}

	public void setLookupMethod(String lookupMethod) {
		this.lookupMethod = lookupMethod;
	}

	@Override
	public String getType() {
		return LookupMappingDefinition;
	}
}
