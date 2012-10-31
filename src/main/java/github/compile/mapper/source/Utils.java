package github.compile.mapper.source;

import java.util.Date;
import java.util.List;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;

public class Utils {

	public static void initList(List list, int size) {
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
	}

	public static JExpression getLiteralByValue(JCodeModel codeModel, Object value)
	{
		if(value instanceof Integer)
		{
			return JExpr.lit((Integer)value);
		}
		if(value instanceof Boolean)
		{
			return JExpr.lit((Boolean)value);
		}
		if(value instanceof Character)
		{
			return JExpr.lit((Character)value);
		}
		if(value instanceof Double)
		{
			return JExpr.lit((Double)value);
		}
		if(value instanceof Float)
		{
			return JExpr.lit((Float)value);
		}
		if(value instanceof Long)
		{
			return JExpr.lit((Long)value);
		}
		if(value instanceof String)
		{
			return JExpr.lit((String)value);
		}
		if(value instanceof Date)
		{
			final JInvocation newDate= JExpr._new(codeModel.ref(Date.class));
			newDate.arg(JExpr.lit(((Date)value).getTime()));
			return newDate;
		}
		return JExpr.direct(value+"");
	}
}
