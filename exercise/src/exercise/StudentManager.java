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
	//���빦��
	private void insert() {
		if (students.size() > 20) {
			System.out.println("�����Ա���20��ѧ����Ϣ��");
			return;
		}
		System.out.println("��������: ");
		String name = scanner.next();
		System.out.println("�����������(1999-01-01): ");
		String birthStr = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birth;
		try {
			birth = dateFormat.parse(birthStr);
		} catch (Exception e) {
			birth = new Date();
			e.printStackTrace();
		}
		System.out.println("�����Ա�(�� �� Ů): ");
		String sex = scanner.next();
		boolean gender = true;
		if (sex.equals("Ů")) {
			gender = false;
		}
		students.add(new Student(name, birth, gender));
		System.out.println("��ӳɹ���");
	}
	
	private void print() {
		for (Student stu : students) {
			System.out.println(stu);
		}
	}
	//���ҹ���
	private void search() {
		System.out.println("����������ʼ����: ");
		String name = scanner.next();
		boolean find = false;
		for (Student stu : students) {
			if (stu.getName().equals(name)) {
				System.out.println(stu);
				find = true;
			}
		}
		if (!find) {
			System.out.println("û���ҵ���Ӧ��ѧ����Ϣ��");
		}
	}
	//ɾ������
	private void delete() {
		System.out.println("����������ʼɾ��: ");
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
			System.out.println("û���ҵ���Ӧ��ѧ����Ϣ��");
		} else {
			System.out.println("ɾ���ɹ���");
		}
	}
	//�޸���Ϣ
	private void update() {
		System.out.println("����������ʼ�޸���Ϣ: ");
		String name = scanner.next();
		boolean find = false;
		for (Student stu : students) {
			if (stu.getName().equals(name)) {
				System.out.println("�ҵ���������ѧ������ʼ�޸�: ");
				System.out.println("ѡ���µĳ�������(1999-01-01): ");
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
				System.out.println("�޸ĳɹ���");
				find = true;
			}
		}
		if (!find) {
			System.out.println("û���ҵ���Ӧ����Ϣ��");
		}
	}
	//ҳ�����Ч��
	private void printMenu() {
		System.out.println("************************");
		System.out.println("*        1 ����                       *");
		System.out.println("*        2 ����                       *");
		System.out.println("*        3 ɾ��                       *");
		System.out.println("*        4 �޸�                       *");
		System.out.println("*        5 ���                       *");
		System.out.println("*        6 �˳�                       *");
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
				default: System.out.println("�������"); break;
			}
		}
	}
	
}
