package github.compile.mapper.source.annotation;

import github.compile.mapper.source.ComplexSourcePathNodeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * By this annotation developer should mark target Get method
 * @author aliaksandr_spichakou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetMappingAnnotation {
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
