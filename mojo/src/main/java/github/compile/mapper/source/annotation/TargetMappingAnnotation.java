package github.compile.mapper.source.annotation;

import github.compile.mapper.source.ComplexSourcePathNodeType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * By this annotation developer should mark target Get method
 * @author aliaksandr_spichakou
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetMappingAnnotation {
	String index();	
	ComplexSourcePathNodeType type() default ComplexSourcePathNodeType.SIMPLE;
	String complexParam() default "";
	Class<?> exactClass() default Object.class;
}
