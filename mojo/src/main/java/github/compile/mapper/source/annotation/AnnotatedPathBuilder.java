package github.compile.mapper.source.annotation;

import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.ComplexSourcePathNodeType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.ClassUtils;

import com.thoughtworks.xstream.XStream;

public class AnnotatedPathBuilder {
	private AnnotatedPathConfig config;

	private Map<String, List<PathNode>> mappingSource = new HashMap<String, List<PathNode>>();
	private Map<String, List<PathNode>> mappingTarget = new HashMap<String, List<PathNode>>();

	public AnnotatedPathBuilder(String path2config) {
		final XStream xstream = new XStream();
		config = (AnnotatedPathConfig) xstream.fromXML(getClass().getResourceAsStream(path2config));
	}

	public MappingDefinitions build(Class<?> source, Class<?> target) {
		extactPath(source, mappingSource, true);
		extactPath(target, mappingTarget, false);

		final MappingDefinitions definitions = new MappingDefinitions();
		final List<IMappingDefinition> definitionList = new ArrayList<IMappingDefinition>();
		definitions.setDefinitions(definitionList);

		final Set<Entry<String, List<PathNode>>> entrySet = mappingTarget.entrySet();
		for (Entry<String, List<PathNode>> entry : entrySet) {
			final String key = entry.getKey();
			final List<PathNode> sourcePath = mappingSource.get(key);
			final List<PathNode> targetPath = entry.getValue();

			IMappingDefinition definitionByIndex = config.getDefinitionByIndex(key);
			if (definitionByIndex == null) {
				// Create default mapping definition
				definitionByIndex = new SimpleMappingDefinition();
			}
			if (definitionByIndex instanceof SimpleMappingDefinition) {
				((SimpleMappingDefinition) definitionByIndex).setSourcePath(sourcePath);
			}
			definitionByIndex.setTargetPath(targetPath);

			definitionList.add(definitionByIndex);
		}
		return definitions;
	}

	private void extactPath(Class<?> clazz, Map<String, List<PathNode>> mapping, boolean isSource) {
		final Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			final Annotation annotation = getAnnotation(isSource, method);
			if (annotation == null) {
				continue;
			}
			final String index = getIndex(isSource, annotation);
			List<PathNode> list = mapping.get(index);

			if (list == null) {
				list = new ArrayList<PathNode>();
				mapping.put(index, list);
			}
			final PathNode pathNode = new PathNode();
			list.add(pathNode);

			final ComplexSourcePathNodeType type = getType(isSource, annotation);
			pathNode.setType(type.getType());

			Class<?> returnType = null;
			if (type != ComplexSourcePathNodeType.SIMPLE) {
				final String complexParam = getComplexParam(isSource, annotation);
				pathNode.setComplexParam(complexParam);
				returnType = getClass(isSource, annotation);
			} else {
				returnType = method.getReturnType();
			}

			pathNode.setClazz(getFullClassName(returnType));

			final String name = method.getName();
			final String replaceFirst = name.replaceFirst("get", "");
			final String field = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
			pathNode.setField(field);

			if (!ClassUtils.isPrimitiveOrWrapper(returnType)) {
				extactPath(returnType, mapping, isSource);
			}
		}
	}

	private String getFullClassName(Class<?> clazz) {
		Class<?> clazz2convert = clazz;
		if (ClassUtils.isPrimitiveOrWrapper(clazz)) {
			clazz2convert = ClassUtils.primitiveToWrapper(clazz);			
		}		
		return clazz2convert.getName();
	}

	private Class<?> getClass(boolean isSource, Annotation annotation) {
		if (isSource) {
			return ((SourceMappingAnnotation) annotation).exactClass();
		} else {
			return ((TargetMappingAnnotation) annotation).exactClass();
		}
	}

	private Annotation getAnnotation(boolean isSource, Method method) {
		if (isSource) {
			return method.getAnnotation(SourceMappingAnnotation.class);
		} else {
			return method.getAnnotation(TargetMappingAnnotation.class);
		}
	}

	private String getIndex(boolean isSource, Annotation annotation) {
		if (isSource) {
			return ((SourceMappingAnnotation) annotation).index();
		} else {
			return ((TargetMappingAnnotation) annotation).index();
		}
	}

	private String getComplexParam(boolean isSource, Annotation annotation) {
		if (isSource) {
			return ((SourceMappingAnnotation) annotation).complexParam();
		} else {
			return ((TargetMappingAnnotation) annotation).complexParam();
		}
	}

	private ComplexSourcePathNodeType getType(boolean isSource, Annotation annotation) {
		if (isSource) {
			return ((SourceMappingAnnotation) annotation).type();
		} else {
			return ((TargetMappingAnnotation) annotation).type();
		}
	}

	public void setConfig(AnnotatedPathConfig config) {
		this.config = config;
	}

}
