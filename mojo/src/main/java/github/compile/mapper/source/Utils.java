package github.compile.mapper.source;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;

/**
 * Utilites
 * 
 * @author aliaksandr_spichakou
 * 
 */
public class Utils {
	private static final Map<String, Class<?>> BUILT_IN_MAP = new ConcurrentHashMap<String, Class<?>>();
	private static final Map<String, Object> BUILT_IN_VAL_MAP = new ConcurrentHashMap<String, Object>();

	static {
		for (Class<?> c : new Class[] { void.class, boolean.class, byte.class, char.class, short.class, int.class, float.class, double.class, long.class })
			BUILT_IN_MAP.put(c.getName(), c);
		
		BUILT_IN_VAL_MAP.put(boolean.class.getName(), false);
		
		for (Class<?> c : new Class[] {byte.class, char.class, short.class, int.class, float.class, double.class, long.class })
			BUILT_IN_VAL_MAP.put(c.getName(), 0);
	}

	/**
	 * Init list by null
	 * 
	 * @param list
	 * @param size
	 */
	public static void initList(List list, int size) {
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
	}

	/**
	 * Detect Codemodel java type by Object value
	 * 
	 * @param codeModel
	 * @param value
	 * @return
	 */
	public static JExpression getLiteralByValue(JCodeModel codeModel, Object value) {
		if (value instanceof Integer) {
			return JExpr.lit((Integer) value);
		}
		if (value instanceof Boolean) {
			return JExpr.lit((Boolean) value);
		}
		if (value instanceof Character) {
			return JExpr.lit((Character) value);
		}
		if (value instanceof Double) {
			return JExpr.lit((Double) value);
		}
		if (value instanceof Float) {
			return JExpr.lit((Float) value);
		}
		if (value instanceof Long) {
			return JExpr.lit((Long) value);
		}
		if (value instanceof String) {
			return JExpr.lit((String) value);
		}
		if (value instanceof Date) {
			final JInvocation newDate = JExpr._new(codeModel.ref(Date.class));
			newDate.arg(JExpr.lit(((Date) value).getTime()));
			return newDate;
		}
		return JExpr.direct(value + "");
	}
	public static <T> T forNameValue(Class<T> clazz) throws ClassNotFoundException {
		Object o = BUILT_IN_VAL_MAP.get(clazz.getName());
		return (T)o;
	}
	
	public static Class<?> forName(String name) throws ClassNotFoundException {
		Class<?> c = BUILT_IN_MAP.get(name);
		if (c == null)
			// assumes you have only one class loader!
			BUILT_IN_MAP.put(name, c = Class.forName(name));
		return c;
	}
}
