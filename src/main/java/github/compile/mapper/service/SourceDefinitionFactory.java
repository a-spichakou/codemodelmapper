package github.compile.mapper.service;

import github.compile.mapper.mapping.DefaultValueMappingDefinition;
import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.SimpleMappingDefinition;
import github.compile.mapper.source.DefaultValueSourceDefinition;
import github.compile.mapper.source.ISourceDefinition;
import github.compile.mapper.source.SimpleSourceDefinition;

import java.lang.reflect.Method;


public class SourceDefinitionFactory {

	public ISourceDefinition getSourceDefinition(Class sourceClazz, Class targetClazz, IMappingDefinition mappingDefinition) {
		final Method[] sourceMethods = sourceClazz.getMethods();
		final Method[] targetMethods = targetClazz.getMethods();

		if (mappingDefinition instanceof SimpleMappingDefinition) {
			final SimpleMappingDefinition def = (SimpleMappingDefinition) mappingDefinition;
			final String sourcePath = def.getSourcePath();
			final Method sourceMethod = getMethod(sourceMethods, sourcePath, false);
			final Method targetMethod = getMethod(targetMethods, def.getTargetPath(), true);

			final SimpleSourceDefinition codemodel = new SimpleSourceDefinition();

			codemodel.setSourceClazz(sourceClazz);
			codemodel.setTargetClazz(targetClazz);

			codemodel.setSourceMethod(sourceMethod);
			codemodel.setTargetMethod(targetMethod);

			return codemodel;
		} else if (mappingDefinition instanceof DefaultValueMappingDefinition) {
			final DefaultValueMappingDefinition def = (DefaultValueMappingDefinition) mappingDefinition;
			final Method targetMethod = getMethod(targetMethods, def.getTargetPath(), true);

			final DefaultValueSourceDefinition codemodel = new DefaultValueSourceDefinition();

			codemodel.setTargetClazz(targetClazz);
			codemodel.setTargetMethod(targetMethod);

			codemodel.setDefultValue(def.getDefaultValue());
			return codemodel;
		}

		return null;
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
