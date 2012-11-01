package github.compile.mapper.test1;

import java.util.List;
import java.util.Map;

public class InnerSourceClass1 {

	private InnerSourceClass2 src2;
	private InnerSourceClass2[] tgArray;
	private List<InnerSourceClass2> tgList;
	private Map<String, InnerSourceClass2> tgMap;

	public InnerSourceClass2 getSrc2() {
		return src2;
	}

	public void setSrc2(InnerSourceClass2 src2) {
		this.src2 = src2;
	}

	public InnerSourceClass2[] getTgArray() {
		return tgArray;
	}

	public void setTgArray(InnerSourceClass2[] tgArray) {
		this.tgArray = tgArray;
	}

	public List<InnerSourceClass2> getTgList() {
		return tgList;
	}

	public void setTgList(List<InnerSourceClass2> tgList) {
		this.tgList = tgList;
	}

	public Map<String, InnerSourceClass2> getTgMap() {
		return tgMap;
	}

	public void setTgMap(Map<String, InnerSourceClass2> tgMap) {
		this.tgMap = tgMap;
	}

}
