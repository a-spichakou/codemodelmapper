package github.compile.mapper.service;

import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.source.ISourceDefinition;
import github.compile.mapper.source.SourceDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
/**
 * Source generator
 * @author aspichakou
 *
 */
public class MapperSourceGenerator {
	/**
	 * Source class
	 */
	private Class<?> source;
	/**
	 * Target class
	 */
	private Class<?> target;
	/**
	 * Name for generating file
	 */
	private String fullClassName;

	/**
	 * 
	 * @param fullClassName - Name for new class (with package)
	 * @param source - source class
	 * @param target - target class
	 */
	public MapperSourceGenerator(String fullClassName, Class<?> source, Class<?> target) {
		this.fullClassName = fullClassName;
		this.source = source;
		this.target = target;
	}

	/**
	 * Generate source
	 * @param definitions
	 * @throws JClassAlreadyExistsException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public JCodeModel generateMapper(MappingDefinitions definitions) throws JClassAlreadyExistsException, IOException, ClassNotFoundException {
		final List<IMappingDefinition> definitionsList = definitions.getDefinitions();
		if (definitionsList == null) {
			throw new IllegalArgumentException("Definition list should not null");
		}
		if (source == null) {
			throw new IllegalArgumentException("Given source object should not be null");
		}
		if (target == null) {
			throw new IllegalArgumentException("Given target object should not be null");
		}

		final SourceDefinitionFactory factory = new SourceDefinitionFactory(source, target);
		final List<ISourceDefinition> codeModelDefinitions = new ArrayList<ISourceDefinition>();
		final SourceDefinitions sourceDefinitions = new SourceDefinitions();
		sourceDefinitions.setDefinitions(codeModelDefinitions);
		int index=0;
		for (IMappingDefinition def : definitionsList) {			
			final ISourceDefinition sourceDefinition = factory.getSourceDefinition(def, index);
			index++;
			codeModelDefinitions.add(sourceDefinition);
		}
		final JCodeModel buildMapper = buildMapper(codeModelDefinitions);
		return buildMapper;
	}

	private JCodeModel buildMapper(List<ISourceDefinition> codeModelDefinitions) throws JClassAlreadyExistsException, IOException {
		final JCodeModel codeModel = new JCodeModel();
		final JDefinedClass mapClass = codeModel._class(fullClassName); 
		final JFieldVar sourceField = mapClass.field(JMod.PUBLIC, source, ISourceDefinition.SOURCE_MEMBER);
		final JFieldVar targetField = mapClass.field(JMod.PUBLIC, target, ISourceDefinition.TARGET_MEMBER);

		final JMethod method = mapClass.method(JMod.PUBLIC, Void.TYPE, "map");

		int index=0;
		for (ISourceDefinition sources : codeModelDefinitions) {
			sources.setSourceField(sourceField);
			sources.setTargetField(targetField);

			final JMethod extendJMethod = sources.extendJMethod(codeModel, mapClass);
			extendJMethod.name(extendJMethod.name()+index);
			final JMethod getValueMethod = sources.getGetValueMethod();
			getValueMethod.name(getValueMethod.name()+index);
			index++;

			method.body().invoke(extendJMethod);
		}
		return codeModel;
	}

}