package github.compile.mapper.source;

import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.InnerTargetClass2;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

import junit.framework.TestCase;

public class AbstractSourceDefinitionTest extends TestCase {
	
	@Ignore
	public void testBuildGetStatement() {
		final SimpleSourceDefinition simpleSourceDefinition = new SimpleSourceDefinition();

		final JCodeModel codeModel = new JCodeModel();
		JDefinedClass mapClass = null;
		try {
			mapClass = codeModel._class("test.mapper.Mapper");
		} catch (JClassAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Creates a new class

		final JFieldVar sourceField = mapClass.field(JMod.PUBLIC, SourceObject.class, ISourceDefinition.SOURCE_MEMBER);

		final JMethod method = mapClass.method(JMod.PUBLIC, Void.TYPE, "map");

		final List<SourcePathNode> path = new ArrayList<SourcePathNode>();
		SourcePathNode node = new SourcePathNode();
		node.setClazz(InnerTargetClass1.class);
		try {
			node.setGetMethod(TargetObject.class.getDeclaredMethod("getTarget3", null));
			node.setSetMethod(TargetObject.class.getDeclaredMethod("setTarget3", InnerTargetClass1.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		node = new SourcePathNode();
		node.setClazz(InnerTargetClass2.class);
		try {
			node.setGetMethod(InnerTargetClass1.class.getDeclaredMethod("getTg2", null));
			node.setSetMethod(InnerTargetClass1.class.getDeclaredMethod("setTg2", InnerTargetClass2.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		node = new SourcePathNode();
		node.setClazz(String.class);
		try {
			node.setGetMethod(InnerTargetClass2.class.getDeclaredMethod("getTg3", null));
			node.setSetMethod(InnerTargetClass2.class.getDeclaredMethod("setTg3", String.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		
		simpleSourceDefinition.setSourcePath(path);
		simpleSourceDefinition.setSourceField(sourceField);
		simpleSourceDefinition.buildGetStatement(method, codeModel);

		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			codeModel.build(new SingleStreamCodeWriter(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String clazz = new String(out.toByteArray());
	}
	

//	@Ignore
	public void testBuildSetStatement() {
		final SimpleSourceDefinition simpleSourceDefinition = new SimpleSourceDefinition();

		final JCodeModel codeModel = new JCodeModel();
		JDefinedClass mapClass = null;
		try {
			mapClass = codeModel._class("test.mapper.Mapper");
		} catch (JClassAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Creates a new class

		final JFieldVar targetField = mapClass.field(JMod.PUBLIC, TargetObject.class, ISourceDefinition.TARGET_MEMBER);

		final JMethod method = mapClass.method(JMod.PUBLIC, Void.TYPE, ISourceDefinition.GET_VALUE_METHOD_NAME);
		final JMethod methodGetValue = mapClass.method(JMod.PUBLIC, Integer.TYPE, "getValue");

		final List<SourcePathNode> path = new ArrayList<SourcePathNode>();
		SourcePathNode node = new SourcePathNode();
		node.setClazz(InnerTargetClass1.class);
		try {
			node.setGetMethod(TargetObject.class.getDeclaredMethod("getTarget3", null));
			node.setSetMethod(TargetObject.class.getDeclaredMethod("setTarget3", InnerTargetClass1.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		node = new SourcePathNode();
		node.setClazz(InnerTargetClass2.class);
		try {
			node.setGetMethod(InnerTargetClass1.class.getDeclaredMethod("getTg2", null));
			node.setSetMethod(InnerTargetClass1.class.getDeclaredMethod("setTg2", InnerTargetClass2.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		node = new SourcePathNode();
		node.setClazz(String.class);
		try {
			node.setGetMethod(InnerTargetClass2.class.getDeclaredMethod("getTg3", null));
			node.setSetMethod(InnerTargetClass2.class.getDeclaredMethod("setTg3", String.class));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		path.add(node);
		
		
		simpleSourceDefinition.setTargetPath(path);
		simpleSourceDefinition.setTargetField(targetField);
		simpleSourceDefinition.buildSetStatement(method, codeModel, methodGetValue);

		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			codeModel.build(new SingleStreamCodeWriter(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String clazz = new String(out.toByteArray());
	}
}
