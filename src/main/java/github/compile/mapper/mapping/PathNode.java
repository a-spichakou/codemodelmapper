package github.compile.mapper.mapping;

/**
 * Mapping path node
 * @author aspichakou
 *
 */
public class PathNode {
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

}
