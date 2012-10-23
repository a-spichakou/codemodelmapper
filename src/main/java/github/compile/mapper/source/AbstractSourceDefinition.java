package github.compile.mapper.source;

import java.lang.reflect.Method;

public abstract class AbstractSourceDefinition implements ISourceDefinition{

	private Class targetClazz;
	private Method targetMethod;

	public AbstractSourceDefinition() {
		super();
	}

	public Class getTargetClazz() {
		return targetClazz;
	}

	public void setTargetClazz(Class targetClazz) {
		this.targetClazz = targetClazz;
	}

	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

}