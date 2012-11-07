package github.compile.mapper.source.annotation;

import github.compile.mapper.source.ComplexSourcePathNodeType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * By this annotation developer should mark source path Get method
 * @author aliaksandr_spichakou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SourceMappingAnnotation {
	/**
	 * This index should be the same for one Path (both source and target path)
	 * @return
	 */
	String index();	
	/**
	 * Node type. Can be simple/array/list/map
	 * @return
	 */
	ComplexSourcePathNodeType type() default ComplexSourcePathNodeType.SIMPLE;
	/**
	 * Complex param or default value
	 * @return
	 */
	String complexParam() default "";
	/**
	 * Class that contains array/list or map in values()
	 * @return
	 */
	Class<?> exactClass() default Object.class;
}
