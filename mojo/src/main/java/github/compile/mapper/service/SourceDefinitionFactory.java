package github.compile.mapper.service;

import github.compile.mapper.mapping.ConverterMappingDefinition;
import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IConverterParam;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.LookupMappingDefinition;
import github.compile.mapper.mapping.PathConverterParam;
import github.compile.mapper.mapping.PathNode;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.ComplexSourcePathNodeType;
import github.compile.mapper.source.ConverterSourceDefinition;
import github.compile.mapper.source.DefaultValueSourceDefinition;
import github.compile.mapper.source.IConverterSourceParam;
import github.compile.mapper.source.ISourceDefinition;
import github.compile.mapper.source.LookupSourceDefinition;
import github.compile.mapper.source.PathConverterSourceParam;
import github.compile.mapper.source.SimpleSourceDefinition;
import github.compile.mapper.source.SourcePathNode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Conver "text"-based mapping definition to Java "class"-based definition
 * 
 * @author aspichakou
 * 
 */
public class SourceDefinitionFactory {
	private Class source;
	private Class target;

	/**
	 * 
	 * @param source
	 *            - source class object
	 * @param target
	 *            - target class object
	 */
	public SourceDefinitionFactory(Class source, Class target) {
		this.source = source;
		this.target = target;
	}

	public ISourceDefinition getSourceDefinition(IMappingDefinition mappingDefinition) throws ClassNotFoundException {
		if (mappingDefinition.getType().equals(SimpleMappingDefinition.SimpleMappingDefinition)) {
			final SimpleMappingDefinition def = (SimpleMappingDefinition) mappingDefinition;
			final List<PathNode> source = def.getSourcePath();
			final List<PathNode> target = def.getTargetPath();

			final List<SourcePathNode> sourcePath = buildSourcePath(source, this.source);
			final List<SourcePathNode> targetPath = buildSourcePath(target, this.target);

			final SimpleSourceDefinition codemodel = new SimpleSourceDefinition();
			codemodel.setTargetPath(targetPath);
			codemodel.setSourcePath(sourcePath);

			return codemodel;
		} else if (mappingDefinition.getType().equals(DefaultValueMappingDefinition.DefaultValueMappingDefinition)) {
			final DefaultValueMappingDefinition def = (DefaultValueMappingDefinition) mappingDefinition;
			final List<PathNode> targetPath = def.getTargetPath();
			final List<SourcePathNode> sourcePath = buildSourcePath(targetPath, this.target);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();
			codemodel.setDefultValue(def.getDefaultValue());
			codemodel.setTargetPath(sourcePath);
			codemodel.setSourcePath(new ArrayList<SourcePathNode>());

			return codemodel;
		} else if (mappingDefinition.getType().equals(LookupMappingDefinition.LookupMappingDefinition)) {
			final LookupMappingDefinition def = (LookupMappingDefinition) mappingDefinition;
			final List<PathNode> source = def.getSourcePath();
			final List<PathNode> target = def.getTargetPath();

			final List<SourcePathNode> sourcePath = buildSourcePath(source, this.source);
			final List<SourcePathNode> targetPath = buildSourcePath(target, this.target);

			final LookupSourceDefinition codemodel = new LookupSourceDefinition();
			codemodel.setTargetPath(targetPath);
			codemodel.setSourcePath(sourcePath);

			final Class<?> targetClass = getClass().getClassLoader().loadClass(def.getMappingClass());
			codemodel.setLookupClass(targetClass);
			final Method[] methods = targetClass.getMethods();
			Method lookupMethod = null;
			for (Method method : methods) {
				if (method.getName().equalsIgnoreCase(def.getLookupMethod())) {
					lookupMethod = method;
					break;
				}
			}

			codemodel.setLookupMethod(lookupMethod);

			return codemodel;

		} else if (mappingDefinition.getType().equals(ConverterMappingDefinition.ConverterMappingDefinition)) {
			final ConverterMappingDefinition def = (ConverterMappingDefinition) mappingDefinition;
			final List<PathNode> source = def.getSourcePath();
			final List<PathNode> target = def.getTargetPath();

			final List<SourcePathNode> sourcePath = buildSourcePath(source, this.source);
			final List<SourcePathNode> targetPath = buildSourcePath(target, this.target);

			final ConverterSourceDefinition codemodel = new ConverterSourceDefinition();
			codemodel.setTargetPath(targetPath);
			codemodel.setSourcePath(sourcePath);

			final Class<?> targetClass = getClass().getClassLoader().loadClass(def.getCovrenerClass());
			codemodel.setConverterClass(targetClass);
			final Method[] methods = targetClass.getMethods();
			Method lookupMethod = null;
			for (Method method : methods) {
				if (method.getName().equalsIgnoreCase(def.getConvertMethod())) {
					lookupMethod = method;
					break;
				}
			}
			codemodel.setConverterMethod(lookupMethod);

			// Build converter params
			final List<IConverterParam> converterParams = def.getConverterParams();
			final List<IConverterSourceParam> converterSourceParams = new ArrayList<IConverterSourceParam>();
			for (IConverterParam param : converterParams) {
				if (param instanceof PathConverterParam) {
					final PathConverterParam pathParam = (PathConverterParam) param;
					final List<PathNode> paramPath = pathParam.getSourcePath();
					final List<SourcePathNode> paramSourcePath = buildSourcePath(paramPath, this.source);
					final PathConverterSourceParam pathConverterSourceParam = new PathConverterSourceParam();
					pathConverterSourceParam.setSourcePath(paramSourcePath);
					converterSourceParams.add(pathConverterSourceParam);
				}
			}
			codemodel.setConverterSourceParams(converterSourceParams);
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
			if (prevClass == null) {
				methods = rootClass.getMethods();
			} else {
				methods = prevClass.getMethods();
			}

			final Method setmethod = getMethod(methods, node.getField(), true);
			final Method getmethod = getMethod(methods, node.getField(), false);
			
			if(setmethod==null || getmethod==null)
			{
				throw new IllegalArgumentException("There no such getter or setters for field: " + node.getField());
			}

			prevClass = targetClass;

			final SourcePathNode sourceNode = new SourcePathNode();
			sourceNode.setClazz(targetClass);
			sourceNode.setSetMethod(setmethod);
			sourceNode.setGetMethod(getmethod);

			final String type = node.getType();
			if (ComplexSourcePathNodeType.SIMPLE.getType().equals(type)) {
				sourceNode.setType(ComplexSourcePathNodeType.SIMPLE);
			}
			if (ComplexSourcePathNodeType.ARRAY.getType().equals(type)) {
				sourceNode.setType(ComplexSourcePathNodeType.ARRAY);
				sourceNode.setComplexParam(Integer.parseInt(node.getComplexParam()));
			}
			if (ComplexSourcePathNodeType.LIST.getType().equals(type)) {
				sourceNode.setType(ComplexSourcePathNodeType.LIST);
				sourceNode.setComplexParam(Integer.parseInt(node.getComplexParam()));
			}
			if (ComplexSourcePathNodeType.MAP.getType().equals(type)) {
				sourceNode.setType(ComplexSourcePathNodeType.MAP);
				sourceNode.setComplexParam(node.getComplexParam());
			}			

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
