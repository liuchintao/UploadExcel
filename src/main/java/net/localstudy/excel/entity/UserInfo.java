package net.localstudy.excel.entity;

public class UserInfo {
	//student's identifiable number
	private long stuId;
	
	//student's group number
	private int stuGroup;
	
	//student's score in course
	private double stuScore;

	public long getStuNum() {
		return stuId;
	}

	public void setStuNum(long stuNum) {
		this.stuId = stuNum;
	}

	public int getStuGroup() {
		return stuGroup;
	}

	public void setStuGroup(int stuGroup) {
		this.stuGroup = stuGroup;
	}

	public double getStuScore() {
		return stuScore;
	}

	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}

	
}
