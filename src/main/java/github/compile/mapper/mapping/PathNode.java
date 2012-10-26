package github.compile.mapper.mapping;

/**
 * Mapping path node
 * 
 * @author aspichakou
 * 
 */
public class PathNode {
	/**
	 * Type of path node (simple/array/list/map)
	 */
	private String type;
	/**
	 * Param to locate value in complex type
	 */
	private String complexParam;

	/**
	 * Class of object in this node
	 */
	private String clazz;
	/**
	 * Field name of this node in Parent class
	 */
	private String field;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComplexParam() {
		return complexParam;
	}

	public void setComplexParam(String complexParam) {
		this.complexParam = complexParam;
	}

}
