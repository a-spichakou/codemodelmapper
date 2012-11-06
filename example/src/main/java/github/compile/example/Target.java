package github.compile.example;

import github.compile.mapper.source.annotation.TargetMappingAnnotation;
import github.compile.mapper.test.TargetLevel1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Target {

	private int level0primitive;
	private String level0String;
	private Date level0Complex;

	private int[] level0primitiveArray;
	private int[][] level0primitiveArray2dim;

	private String[] level0StriingArray;
	private String[][] level0StringArray2dim;

	private Date[] level0DateArray;
	private Date[][] level0DateArray2dim;

	private ArrayList level0List;
	private HashMap level0Map;

	private TargetLevel1 level1;

	@TargetMappingAnnotation(index="level0primitive")
	public int getLevel0primitive() {
		return level0primitive;
	}
	
	public void setLevel0primitive(int level0primitive) {
		this.level0primitive = level0primitive;
	}

	@TargetMappingAnnotation(index="level0String")
	public String getLevel0String() {
		return level0String;
	}

	public void setLevel0String(String level0String) {
		this.level0String = level0String;
	}

	public Date getLevel0Complex() {
		return level0Complex;
	}

	public void setLevel0Complex(Date level0Complex) {
		this.level0Complex = level0Complex;
	}

	public int[] getLevel0primitiveArray() {
		return level0primitiveArray;
	}

	public void setLevel0primitiveArray(int[] level0primitiveArray) {
		this.level0primitiveArray = level0primitiveArray;
	}

	public int[][] getLevel0primitiveArray2dim() {
		return level0primitiveArray2dim;
	}

	public void setLevel0primitiveArray2dim(int[][] level0primitiveArray2dim) {
		this.level0primitiveArray2dim = level0primitiveArray2dim;
	}

	public String[] getLevel0StriingArray() {
		return level0StriingArray;
	}

	public void setLevel0StriingArray(String[] level0StriingArray) {
		this.level0StriingArray = level0StriingArray;
	}

	public String[][] getLevel0StringArray2dim() {
		return level0StringArray2dim;
	}

	public void setLevel0StringArray2dim(String[][] level0StringArray2dim) {
		this.level0StringArray2dim = level0StringArray2dim;
	}

	public ArrayList getLevel0List() {
		return level0List;
	}

	public void setLevel0List(ArrayList level0List) {
		this.level0List = level0List;
	}

	public HashMap getLevel0Map() {
		return level0Map;
	}

	public void setLevel0Map(HashMap level0Map) {
		this.level0Map = level0Map;
	}

	public TargetLevel1 getLevel1() {
		return level1;
	}

	public void setLevel1(TargetLevel1 level1) {
		this.level1 = level1;
	}

	public Date[] getLevel0DateArray() {
		return level0DateArray;
	}

	public void setLevel0DateArray(Date[] level0DateArray) {
		this.level0DateArray = level0DateArray;
	}

	public Date[][] getLevel0DateArray2dim() {
		return level0DateArray2dim;
	}

	public void setLevel0DateArray2dim(Date[][] level0DateArray2dim) {
		this.level0DateArray2dim = level0DateArray2dim;
	}

}
