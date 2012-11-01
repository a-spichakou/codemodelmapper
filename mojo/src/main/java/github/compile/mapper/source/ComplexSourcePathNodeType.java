package github.compile.mapper.source;

public enum ComplexSourcePathNodeType {
	SIMPLE("simple"), ARRAY("array"), MAP("map"), LIST("list");

	private String type;

	private ComplexSourcePathNodeType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

	public String getType() {
		return type;
	}
}
