package github.compile.mapper.source;

import java.util.Iterator;
import java.util.List;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JVar;

public class PathConverterSourceParam implements IConverterSourceParam {
	private JFieldVar sourceField;
	private List<SourcePathNode> sourcePath;

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

			final Class<?> clazz = node.getClazz();
			//final Method method = node.getGetMethod();

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

	public JFieldVar getSourceField() {
		return sourceField;
	}

	public void setSourceField(JFieldVar sourceField) {
		this.sourceField = sourceField;
	}
}
