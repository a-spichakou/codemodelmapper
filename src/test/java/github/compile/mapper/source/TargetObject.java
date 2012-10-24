package github.compile.mapper.source;

import java.util.Date;

public class TargetObject {


	private Date target1;
	private String target2;
	private InnerTargetClass1 target3;

	public InnerTargetClass1 getTarget3() {
		return target3;
	}

	public void setTarget3(InnerTargetClass1 target3) {
		this.target3 = target3;
	}

	public Date getTarget1() {
		return target1;
	}

	public void setTarget1(Date target1) {
		this.target1 = target1;
	}

	public String getTarget2() {
		return target2;
	}

	public void setTarget2(String target2) {
		this.target2 = target2;
	}
}