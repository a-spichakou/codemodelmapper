package github.compile.mapper.source;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionImpl;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;

/**
 * Source generator for getValue and custom mapper method
 * @author aspichakou
 *
 */
public abstract class AbstractSourceDefinition implements ISourceDefinition {
	protected JMethod getValueMethod;
	
	private JFieldVar sourceField;
	private JFieldVar targetField;

	private List<SourcePathNode> targetPath;
	private List<SourcePathNode> sourcePath;

	public List<SourcePathNode> getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(List<SourcePathNode> targetPath) {
		this.targetPath = targetPath;
	}

	public List<SourcePathNode> getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(List<SourcePathNode> sourcePath) {
		this.sourcePath = sourcePath;
	}

	/**
	 * Generate getValue() method
	 * @param jmethod - Codemodel getValue() method
	 * @param codeModel - Codemodel model
	 * @return
	 */
	public JVar buildGetStatement(JMethod jmethod, JCodeModel codeModel) {
		final Iterator<SourcePathNode> iterator = sourcePath.iterator();

		int idx = 0;
		JVar prevDecl = null;
		while (iterator.hasNext()) {
			final SourcePathNode node = iterator.next();

			final Class clazz = node.getClazz();
			final Method method = node.getGetMethod();

			final JClass directClass = codeModel.ref(clazz);
			final String simpleClassName = clazz.getSimpleName();
			final String localVarName = simpleClassName.toLowerCase() + idx;
			idx++;
			// InnerSourceClass1 innersourceclass10;
			final JVar decl = jmethod.body().decl(directClass, localVarName);

			// innersourceclass10 = source.getSrc1();
			// or
			// innersourceclass21 = innersourceclass10.getSrc2();
			JExpression invoke = null;
			if (prevDecl != null) {				
				invoke = node.addParamToGetMethod(codeModel,jmethod,prevDecl);				
			} else {
				invoke = node.addParamToGetMethod(codeModel,jmethod,sourceField);				
			}
			jmethod.body().assign(decl, invoke);

			prevDecl = decl;

			/*
			 * if ((innersourceclass10==null)) { return null; }
			 */
			final JConditional ifCond = jmethod.body()._if(JExpr.direct(localVarName + "==null"));
			ifCond._then()._return(JExpr._null());
		}
		jmethod.body()._return(prevDecl);
		return prevDecl;
	}

	/**
	 * Generate Set method
	 * @param jmethod - separate method for mapping source to target
	 * @param codeModel - Codemodel model
	 * @param getValueMethod - Codemodel method getValue() for this target field
	 */
	public void buildSetStatement(JMethod jmethod, JCodeModel codeModel, JMethod getValueMethod) {
		final Iterator<SourcePathNode> iterator = targetPath.iterator();

		JVar prevDecl = null;
		int idx = 0;
		while (iterator.hasNext()) {
			final SourcePathNode node = iterator.next();
			if (!iterator.hasNext()) {
				break;
			}

			final Class clazz = node.getClazz();
			final Method method = node.getGetMethod();

			final JClass directClass = codeModel.ref(clazz);
			final String simpleClassName = clazz.getSimpleName();
			final String localVarName = simpleClassName.toLowerCase() + idx;
			idx++;
			// InnerTargetClass1 innertargetclass10;
			final JVar decl = jmethod.body().decl(directClass, localVarName);
			
			/*
			 * if ((innertargetclass10==null)) { 
			 *  innertargetclass10 = new InnerTargetClass1(); 
			 *  target.setTarget3(innertargetclass10);
			 * }
			 */			
			// innertargetclass10 = target.getTarget3();
			if (prevDecl != null) {
				prevDecl = (JVar)node.addParamToSetWithInitMethod(codeModel,jmethod,prevDecl,decl);
			} else {
				prevDecl = (JVar)node.addParamToSetWithInitMethod(codeModel,jmethod,targetField,decl);
			}			
		}		
		 // Object value;		       		     		        
		final JVar value = jmethod.body().decl(getValueMethod.type(), "value");
		final SourcePathNode sourcePathNode = targetPath.get(targetPath.size() - 1);
		final JClass typeCastToThisClass = codeModel.ref(sourcePathNode.getClazz());
		// String decl;
		final JVar decl = jmethod.body().decl(typeCastToThisClass, "decl");
		// value = getValue();
		jmethod.body().assign(value, JExpr.invoke(getValueMethod));
		//decl = ((String) value);
		final JExpressionImpl cast = JExpr.cast(typeCastToThisClass, value);
		jmethod.body().assign(decl, cast);
	
		if(prevDecl==null)
		{			
			prevDecl = targetField;
		}
		sourcePathNode.addSet(codeModel, jmethod, prevDecl, decl);				
	}

	public JFieldVar getSourceField() {
		return sourceField;
	}

	public void setSourceField(JFieldVar sourceField) {
		this.sourceField = sourceField;
	}

	public JFieldVar getTargetField() {
		return targetField;
	}

	public void setTargetField(JFieldVar targetField) {
		this.targetField = targetField;
	}

	public JMethod getGetValueMethod() {
		return getValueMethod;
	}

	public void setGetValueMethod(JMethod getValueMethod) {
		this.getValueMethod = getValueMethod;
	}
	
}