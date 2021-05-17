package exercise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
	
	
	private List<Student> students;
	private Scanner scanner;

	
	public StudentManager() {
		this.students = new ArrayList<Student>();
		this.scanner = new Scanner(System.in);
	}
	//插入功能
	private void insert() {
		if (students.size() > 20) {
			System.out.println("最多可以保存20个学生信息！");
			return;
		}
		System.out.println("输入姓名: ");
		String name = scanner.next();
		System.out.println("输入出生日期(1999-01-01): ");
		String birthStr = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birth;
		try {
			birth = dateFormat.parse(birthStr);
		} catch (Exception e) {
			birth = new Date();
			e.printStackTrace();
		}
		System.out.println("输入性别(男 或 女): ");
		String sex = scanner.next();
		boolean gender = true;
		if (sex.equals("女")) {
			gender = false;
		}
		students.add(new Student(name, birth, gender));
		System.out.println("添加成功！");
	}
	
	private void print() {
		for (Student stu : students) {
			System.out.println(stu);
		}
	}
	//查找功能
	private void search() {
		System.out.println("输入姓名开始查找: ");
		String name = scanner.next();
		boolean find = false;
		for (Student stu : students) {
			if (stu.getName().equals(name)) {
				System.out.println(stu);
				find = true;
			}
		}
		if (!find) {
			System.out.println("没有找到对应的学生信息！");
		}
	}
	//删除功能
	private void delete() {
		System.out.println("输入姓名开始删除: ");
		String name = scanner.next();
		List<Student> list = new ArrayList<Student>();
		boolean find = false;
		for (Student stu : students) {
			if (stu.getName().equals(name)) {
				list.add(stu);
				find = true;
			}
		}
		students.removeAll(list);
		if (!find) {
			System.out.println("没有找到对应的学生信息！");
		} else {
			System.out.println("删除成功！");
		}
	}
	//修改信息
	private void update() {
		System.out.println("输入姓名开始修改信息: ");
		String name = scanner.next();
		boolean find = false;
		for (Student stu : students) {
			if (stu.getName().equals(name)) {
				System.out.println("找到该姓名的学生，开始修改: ");
				System.out.println("选择新的出生日期(1999-01-01): ");
				String birthStr = scanner.next();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date birth;
				try {
					birth = dateFormat.parse(birthStr);
				} catch (Exception e) {
					birth = new Date();
					e.printStackTrace();
				}
				stu.setBirDate(birth);
				System.out.println("修改成功！");
				find = true;
			}
		}
		if (!find) {
			System.out.println("没有找到对应的信息！");
		}
	}
	//页面输出效果
	private void printMenu() {
		System.out.println("************************");
		System.out.println("*        1 插入                       *");
		System.out.println("*        2 查找                       *");
		System.out.println("*        3 删除                       *");
		System.out.println("*        4 修改                       *");
		System.out.println("*        5 输出                       *");
		System.out.println("*        6 退出                       *");
		System.out.println("************************");
	}

	public void App() {
		while (true) {
			printMenu();
			int cmd = scanner.nextInt();
			switch (cmd) {
				case 1: insert(); break;
				case 2: search(); break;
				case 3: delete(); break;
				case 4: update(); break;
				case 5: print(); break;
				case 6: System.exit(0);
				default: System.out.println("输入错误！"); break;
			}
		}
	}
	
}
