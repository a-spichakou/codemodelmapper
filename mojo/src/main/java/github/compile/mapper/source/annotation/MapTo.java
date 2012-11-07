package github.compile.mapper.source.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * By this annotation developer should mark Source class
 * @author aliaksandr_spichakou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MapTo {

	/**
	 * Map target
	 * 
	 * @return
	 */
	Class<?> target();

	/**
	 * Path to XML config with complex params and etc.
	 * 
	 * @return
	 */
	String path2config();
	
	/**
	 * Mapper class name with package
	 * @return
	 */
	String mapperClassNameWithPackage();
}
