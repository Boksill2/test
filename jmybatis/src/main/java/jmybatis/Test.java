package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();

		my.init();

		Scanner sc = new Scanner(System.in);

		System.out.print("���̵��Է�");
		String user_id = sc.next();
		System.out.print("����Է�");
		String user_pw = sc.next();
		System.out.println();

		int is = my.check1(user_id, user_pw);


	 
		while (is==2) {
			ArrayList<userDTO> list = my.getUser();
			System.out.println("1.�Է� 2.��ȸ 3.����� 4.���� 5.�˻� 6.����");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				System.out.print("���̵� �Է� : ");
				user_id = sc.nextLine();
				System.out.print("��й�ȣ �Է� : ");
				user_pw = sc.nextLine();
				System.out.print("�̸� �Է� : ");
				String name = sc.nextLine();
				System.out.print("��ȭ��ȣ �Է�(����:010-1111-2222) : ");
				String phone = sc.nextLine();
				System.out.print("��� �Է� : ");
				String grade = sc.nextLine();
				System.out.print("���� �Է� : ");
				int age = sc.nextInt();

				my.insertUser(user_id, user_pw, name, phone, grade, age);

//			dao.insertUser(dto);
				System.out.println("�Է� ����");

				break;
			case 2:

				System.out.println(list);
//			dao.selectUser();

				break;
			case 3:

				System.out.println(list);
				System.out.println("������̵�:");
				String id = sc.next();
				my.deleteUser(id);
				System.out.println("�����Ϸ�");

				break;
			case 4:

				System.out.println(list);
				System.out.print("�ٲ� �̸� :");
				String name1 = sc.next();
				System.out.print("�ٲ� ���̵�:");
				String id1 = sc.next();

				my.updateUser(name1, id1);
				System.out.println("�����Ϸ�");

				break;
//		case 5:
//			System.out.print("�˻��� �̸�:");
//			String s_name = sc.next(); 
//			ArrayList<userDTO> user = new ArrayList<userDTO>();
//			user = dao.searchUser(s_name);
//			for(userDTO i: user) {
//				System.out.println(i);
//			}
//			break;
			case 6: {

				System.out.println("����");
				System.exit(0);
			}
			}

		}
	}
}
