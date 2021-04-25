package exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{
	
	private static int counter = 0;
	
	private int ID; // 学号
	private String name; // 姓名
	private Date birDate; // 出生日期
	private boolean gender; // 性别 false->female true->male
	
	public Student(String name, Date birth, boolean gender) {
		this.ID = ++counter;
		this.name = name;
		this.birDate = birth;
		this.gender = gender;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirDate() {
		return birDate;
	}
	
	public void setBirDate(Date birDate) {
		this.birDate = birDate;
	}
	
	public boolean getGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	@Override
	public int compareTo(Student stu) {
		return this.ID > stu.ID ? 1 : 
			this.ID == stu.ID ? 0 : -1;
	}
	
	@Override
	public String toString() {
		return String.format("学号: %d, 姓名: %s, 出生日期: %s, 性别: %s", this.ID, 
				this.name, new SimpleDateFormat("yyyy-MM-dd").format(birDate), gender ? "男" : "女");
	}
	
}
