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

/**
 * Conver "text"-based mapping definition to Java "class"-based definition
 * @author aspichakou
 *
 */
public class SourceDefinitionFactory {
	private Class source;
	private Class target;


	/**
	 * 
	 * @param source - source class object
	 * @param target - target class object
	 */
	public SourceDefinitionFactory(Class source, Class target) {		
		this.source = source;
		this.target = target;
	}

	public ISourceDefinition getSourceDefinition(IMappingDefinition mappingDefinition) throws ClassNotFoundException {
		if (mappingDefinition instanceof SimpleMappingDefinition) {
			final SimpleMappingDefinition def = (SimpleMappingDefinition) mappingDefinition;
			final List<PathNode> source = def.getSourcePath();
			final List<PathNode> target = def.getTargetPath();

			final List<SourcePathNode> sourcePath = buildSourcePath(source, this.source);
			final List<SourcePathNode> targetPath = buildSourcePath(target, this.target);

			final SimpleSourceDefinition codemodel = new SimpleSourceDefinition();
			codemodel.setTargetPath(targetPath);
			codemodel.setSourcePath(sourcePath);

			return codemodel;
		} else if (mappingDefinition instanceof DefaultValueMappingDefinition) {
			final DefaultValueMappingDefinition def = (DefaultValueMappingDefinition) mappingDefinition;
			final List<PathNode> targetPath = def.getTargetPath();
			final List<SourcePathNode> sourcePath = buildSourcePath(targetPath, this.target);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();
			codemodel.setDefultValue(def.getDefaultValue());
			codemodel.setTargetPath(sourcePath);
			codemodel.setSourcePath(new ArrayList<SourcePathNode>());
			
			return codemodel;
		} else if (mappingDefinition instanceof LookupMappingDefinition) {
			final LookupMappingDefinition def = (LookupMappingDefinition) mappingDefinition;
			final List<PathNode> targetPath = def.getTargetPath();
			final List<SourcePathNode> sourcePath = buildSourcePath(targetPath, this.target);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();
			codemodel.setTargetPath(sourcePath);

			return codemodel;
		}
		return null;
	}

	private List<SourcePathNode> buildSourcePath(List<PathNode> path, Class rootClass) throws ClassNotFoundException {
		final List<SourcePathNode> sourcePath = new ArrayList<SourcePathNode>();

		Class<?> prevClass = null;
		for (PathNode node : path) {
			final String clazz = node.getClazz();
			final Class<?> targetClass = getClass().getClassLoader().loadClass(clazz);
			
			// Get getters/setter from Parent class
			Method[] methods = null;
			if(prevClass==null)
			{
				methods = rootClass.getMethods();				
			}
			else
			{
				methods = prevClass.getMethods();
			}
			final Method setmethod = getMethod(methods, node.getField(), true);
			final Method getmethod = getMethod(methods, node.getField(), false);
			
			prevClass = targetClass;

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
