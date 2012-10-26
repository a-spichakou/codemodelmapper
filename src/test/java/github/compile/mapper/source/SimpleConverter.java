package github.compile.mapper.source;

import java.util.List;

public class SimpleConverter {
	
	public String convert(String value, List params)
	{
		if(value==null)
		{
			return "<empty>";
		}
		if(params==null || params.size()==0)
		{
			return "<paramsEmpty>";
		}
		for(Object param:params)
		{
			if("paramValue1".equals(param))
			{
				return value+"param1";
			}
			if("paramValue2".equals(param))
			{
				return value+"param2";
			}
		}
		return null;
	}

}
