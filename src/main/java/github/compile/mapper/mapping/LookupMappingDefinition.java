package github.compile.mapper.mapping;

public class LookupMappingDefinition extends SimpleMappingDefinition {

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

}
