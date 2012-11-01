package github.compile.mapper.test1;

public class SimpleLookup {

	public String lookup(String param) {
		if (param == null) {
			return "zero";
		}
		if ("param1".equalsIgnoreCase(param)) {
			return "value1";
		}
		if ("param2".equalsIgnoreCase(param)) {
			return "value2";
		}
		return "<empty>";
	}

}
