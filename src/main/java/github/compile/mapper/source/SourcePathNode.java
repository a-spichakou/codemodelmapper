package github.compile.mapper.source;

import java.lang.reflect.Method;
/**
 * Source definition path node
 * @author aspichakou
 *
 */
public class SourcePathNode {

	/**
	 * Object type
	 */
	private Class clazz;
	/**
	 * Setter form Parent class
	 */
	private Method setMethod;
	/**
	 * Getter form Parent class
	 */
	private Method getMethod;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Method getSetMethod() {
		return setMethod;
	}

	public void setSetMethod(Method setMethod) {
		this.setMethod = setMethod;
	}

	public Method getGetMethod() {
		return getMethod;
	}

	public void setGetMethod(Method getMethod) {
		this.getMethod = getMethod;
	}

}
