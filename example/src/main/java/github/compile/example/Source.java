package github.compile.example;

import github.compile.mapper.source.annotation.MapTo;
import github.compile.mapper.source.annotation.SourceMappingAnnotation;
import github.compile.mapper.test.SourceLevel1;
import github.compile.mapper.test.Target;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@MapTo(path2config="/MapConfig.xml",target=Target.class,mapperClassNameWithPackage="github.compile.mapper.test.MapSource2Target" )
public class Source {
	
	private int level0primitive;
	private String level0String;
	private Date level0Complex;
	
	private int[] level0primitiveArray;
	private int[][] level0primitiveArray2dim;
	
	private String[] level0StriingArray;
	private String[][] level0StringArray2dim;
	
	private ArrayList level0List;
	private HashMap level0Map;
	
	private SourceLevel1 level1;

	@SourceMappingAnnotation(index="level0primitive")
	public int getLevel0primitive() {
		return level0primitive;
	}

	public void setLevel0primitive(int level0primitive) {
		this.level0primitive = level0primitive;
	}

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

	public SourceLevel1 getLevel1() {
		return level1;
	}

	public void setLevel1(SourceLevel1 level1) {
		this.level1 = level1;
	}
	
}
