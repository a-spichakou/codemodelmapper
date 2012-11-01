package github.compile.mapper.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InnerTargetClass1 {

	private String tg1;
	private InnerTargetClass2 tg2;
	private String[] stringArray;
	private ArrayList stringList;
	private HashMap stringMap;

	public InnerTargetClass2 getTg2() {
		return tg2;
	}

	public void setTg2(InnerTargetClass2 tg2) {
		this.tg2 = tg2;
	}

	public String getTg1() {
		return tg1;
	}

	public void setTg1(String tg1) {
		this.tg1 = tg1;
	}

	public String[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	public ArrayList getStringList() {
		return stringList;
	}

	public void setStringList(ArrayList stringList) {
		this.stringList = stringList;
	}

	public HashMap getStringMap() {
		return stringMap;
	}

	public void setStringMap(HashMap stringMap) {
		this.stringMap = stringMap;
	}



}