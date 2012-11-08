package github.compile.example;

import java.util.Date;
import java.util.List;

public class SampleConverter {

	public int convert(Date value, List params) {
		if (value == null) {
			return 0;
		}
		if (params == null || params.size() == 0) {
			return -1;
		}
		for (Object param : params) {
			if ("paramValue".equals(param)) {
				return value.getYear();
			}
		}
		return -2;
	}

}
