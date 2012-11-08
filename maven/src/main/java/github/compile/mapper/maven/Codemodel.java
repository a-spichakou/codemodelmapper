package github.compile.mapper.maven;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.sun.codemodel.JCodeModel;

import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.AnnotationDetector.TypeReporter;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.service.MapperSourceGenerator;
import github.compile.mapper.source.annotation.AnnotatedPathBuilder;
import github.compile.mapper.source.annotation.MapTo;

/**
 * @author aspichakou
 */
public class Codemodel {

	public void execute(String path2generate, String package2scan) throws MojoExecutionException, MojoFailureException {
		final List<Class<?>> annotated = new ArrayList<Class<?>>();

		final AnnotationDetector cf = new AnnotationDetector(new TypeReporter() {

			@SuppressWarnings("unchecked")
			public Class<? extends Annotation>[] annotations() {
				return new Class[] { MapTo.class };
			}

			public void reportTypeAnnotation(Class<? extends Annotation> annotation, String className) {
				try {
					annotated.add(Class.forName(className));
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Something went wrong: " + e.getMessage());
				}
			}
		});

		try {
			cf.detect(package2scan);
		} catch (IOException e1) {
			throw new RuntimeException("Something went wrong: " + e1.getMessage());
		}

		for (Class<?> source : annotated) {
			final MapTo annotation = source.getAnnotation(MapTo.class);
			final String mapperClassNameWithPackage = annotation.mapperClassNameWithPackage();
			final Class<?> target = annotation.target();
			final String path2config = annotation.path2config();

			final MapperSourceGenerator generator = new MapperSourceGenerator(mapperClassNameWithPackage, source, target);
			final AnnotatedPathBuilder builder = new AnnotatedPathBuilder(path2config);

			try {
				final MappingDefinitions build = builder.build(source, target);
				final JCodeModel generateMapper = generator.generateMapper(build);
				generateMapper.build(new File(path2generate));
			} catch (Exception e) {
				throw new RuntimeException("Something went wrong: " + e.getMessage());
			}
		}
	}
}
