package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();

		my.init();

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디입력");
		String user_id = sc.next();
		System.out.print("비번입력");
		String user_pw = sc.next();
		System.out.println();

		int is = my.check1(user_id, user_pw);


	 
		while (is==2) {
			ArrayList<userDTO> list = my.getUser();
			System.out.println("1.입력 2.조회 3.지우기 4.수정 5.검색 6.종료");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				System.out.print("아이디 입력 : ");
				user_id = sc.nextLine();
				System.out.print("비밀번호 입력 : ");
				user_pw = sc.nextLine();
				System.out.print("이름 입력 : ");
				String name = sc.nextLine();
				System.out.print("전화번호 입력(예시:010-1111-2222) : ");
				String phone = sc.nextLine();
				System.out.print("등급 입력 : ");
				String grade = sc.nextLine();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();

				my.insertUser(user_id, user_pw, name, phone, grade, age);

//			dao.insertUser(dto);
				System.out.println("입력 종료");

				break;
			case 2:

				System.out.println(list);
//			dao.selectUser();

				break;
			case 3:

				System.out.println(list);
				System.out.println("지울아이디:");
				String id = sc.next();
				my.deleteUser(id);
				System.out.println("삭제완료");

				break;
			case 4:

				System.out.println(list);
				System.out.print("바꿀 이름 :");
				String name1 = sc.next();
				System.out.print("바꿀 아이디:");
				String id1 = sc.next();

				my.updateUser(name1, id1);
				System.out.println("수정완료");

				break;
//		case 5:
//			System.out.print("검색할 이름:");
//			String s_name = sc.next(); 
//			ArrayList<userDTO> user = new ArrayList<userDTO>();
//			user = dao.searchUser(s_name);
//			for(userDTO i: user) {
//				System.out.println(i);
//			}
//			break;
			case 6: {

				System.out.println("종료");
				System.exit(0);
			}
			}

		}
	}
}
