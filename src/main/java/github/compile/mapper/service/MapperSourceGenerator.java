package github.compile.mapper.service;

import github.compile.mapper.mapping.IMappingDefinition;
import github.compile.mapper.mapping.MappingDefinitions;
import github.compile.mapper.source.ISourceDefinition;
import github.compile.mapper.source.SourceDefinitions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

public class MapperSourceGenerator {

	private Class source;
	private Class target;
	private String fullClassName;
	
	public MapperSourceGenerator(Class source, Class target, String fullClassName)
	{
		this.source = source;
		this.target = target;
		this.fullClassName = fullClassName;
	}
	
	public void generateMapper( MappingDefinitions definitions) throws JClassAlreadyExistsException, IOException {
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

		final SourceDefinitionFactory factory = new SourceDefinitionFactory();
		final List<ISourceDefinition> codeModelDefinitions = new ArrayList<ISourceDefinition>();
		final SourceDefinitions sourceDefinitions = new SourceDefinitions();
		sourceDefinitions.setDefinitions(codeModelDefinitions);
		for (IMappingDefinition def : definitionsList) {
			final ISourceDefinition sourceDefinition = factory.getSourceDefinition(source, target, def);
			codeModelDefinitions.add(sourceDefinition);
		}
		final String buildMapper = buildMapper(codeModelDefinitions);
		
		System.out.print(buildMapper);
	}

	private String buildMapper(List<ISourceDefinition> codeModelDefinitions) throws JClassAlreadyExistsException, IOException {
		final JCodeModel codeModel = new JCodeModel();
		final JDefinedClass mapClass = codeModel._class(fullClassName); // Creates a new class
		
		mapClass.field(JMod.PUBLIC, source, ISourceDefinition.SOURCE_MEMBER);
		mapClass.field(JMod.PUBLIC, target, ISourceDefinition.TARGET_MEMBER);

		final JMethod method = mapClass.method(JMod.PUBLIC, Void.TYPE, "map");
		
		for(ISourceDefinition sources: codeModelDefinitions)
		{
			sources.extendJMethod(method);
		}
		
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		codeModel.build(new SingleStreamCodeWriter(out));
		final String clazz = new String(out.toByteArray());
		
		return clazz;
	}

}