package github.compile.mapper.service;

import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.LookupMappingDefinition;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.DefaultValueSourceDefinition;
import github.compile.mapper.source.ISourceDefinition;
import github.compile.mapper.source.SimpleSourceDefinition;
import github.compile.mapper.source.SourcePathNode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SourceDefinitionFactory {

	public ISourceDefinition getSourceDefinition(IMappingDefinition mappingDefinition) throws ClassNotFoundException {
		if (mappingDefinition instanceof SimpleMappingDefinition) {
			final SimpleMappingDefinition def = (SimpleMappingDefinition) mappingDefinition;
			final List<PathNode> source = def.getSourcePath();
			final List<PathNode> target = def.getTargetPath();

			final List<SourcePathNode> sourcePath = buildSourcePath(source);
			final List<SourcePathNode> targetPath = buildSourcePath(target);

			final SimpleSourceDefinition codemodel = new SimpleSourceDefinition();
			codemodel.setTargetPath(targetPath);
			codemodel.setSourcePath(sourcePath);

			return codemodel;
		} else if (mappingDefinition instanceof DefaultValueMappingDefinition) {
			final DefaultValueMappingDefinition def = (DefaultValueMappingDefinition) mappingDefinition;
			final List<PathNode> targetPath = def.getTargetPath();
			final List<SourcePathNode> sourcePath = buildSourcePath(targetPath);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();
			codemodel.setDefultValue(def.getDefaultValue());
			codemodel.setTargetPath(sourcePath);
			codemodel.setSourcePath(new ArrayList<SourcePathNode>());
			
			return codemodel;
		} else if (mappingDefinition instanceof LookupMappingDefinition) {
			final LookupMappingDefinition def = (LookupMappingDefinition) mappingDefinition;
			final List<PathNode> targetPath = def.getTargetPath();
			final List<SourcePathNode> sourcePath = buildSourcePath(targetPath);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();
			codemodel.setTargetPath(sourcePath);

			return codemodel;
		}
		return null;
	}

	private List<SourcePathNode> buildSourcePath(List<PathNode> path) throws ClassNotFoundException {
		final List<SourcePathNode> sourcePath = new ArrayList<SourcePathNode>();

		for (PathNode node : path) {
			final String clazz = node.getClazz();
			final Class<?> targetClass = getClass().getClassLoader().loadClass(clazz);
			final Method[] methods = targetClass.getMethods();
			final Method setmethod = getMethod(methods, node.getField(), true);
			final Method getmethod = getMethod(methods, node.getField(), false);

			final SourcePathNode sourceNode = new SourcePathNode();
			sourceNode.setClazz(targetClass);
			sourceNode.setSetMethod(setmethod);
			sourceNode.setGetMethod(getmethod);
			sourcePath.add(sourceNode);
		}
		return sourcePath;
	}

	private Method getMethod(Method[] methods, String propertyName, boolean setMethod) {
		String fullGetterName = null;
		if (setMethod) {
			fullGetterName = "set" + propertyName;
		} else {
			fullGetterName = "get" + propertyName;
		}

		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(fullGetterName)) {
				return method;
			}
		}
		return null;
	}
}
