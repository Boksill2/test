package jmybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	SqlSessionFactory sqlSessionFactory;

	public void init() {

		try {
			String resource = "jmybatis/mybatis-config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			System.out.println("MyBatis 설정 파일 가져오기 실패");
			e.printStackTrace();
		}

	}
	//select
	public ArrayList<userDTO> getUser() {
		//SQL문 처리
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		ArrayList<userDTO> userlist = mapper.getUser();
		
		return userlist;

	}
	
	  public void insertUser(String user_id, String user_pw, String name, String phone, String grade, int age) { 
	   SqlSession session = sqlSessionFactory.openSession(); 
	   UserMapper mapper  =session.getMapper(UserMapper.class);
	   userDTO userDTO = new userDTO(user_id, user_pw, name, phone, grade,  age); 
	   mapper.insertUser(userDTO);
	   session.commit();// insert,update,delete 에만 해당
	  }
	 public void deleteUser(String user_id) {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 mapper.deleteUser(user_id);
		 session.commit();
	 }
	 public void updateUser(String name, String user_id) {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 mapper.updateUser(name,user_id);
		 session.commit();
	 }
	 public String[] getID() {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 String[] user_id = mapper.getID();
		 return user_id;
	 }
	 public String[] getPW() {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 String[] user_pw = mapper.getPW();
		 return user_pw;
	 }
	 
	 public int check(String id,String pw) {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 String[] user_id = mapper.getID();
		 String[] user_pw = mapper.getPW();		 
		
		 int a= 0;			
			for(int i= 0; i<user_id.length;i++) {				
				if(id.equals(user_id[i])){						
					a=1;					
					if(pw.equals(user_pw[i])){					
					a=2;
					System.out.println("로그인성공");
					}
				}
			}if(a==1) {
				System.out.println("비번틀림");
			} if(a==0) {
				System.out.println("아이디틀림");
			}		 
		 return a;
	 }public int check1(String user_id,String user_pw) {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 userDTO get = mapper.check1(user_id, user_pw);
		 
		
		 		int a =0;	
			if(get==null) {
				System.out.println("아이디틀림");
			}else {
				if(user_id.equals(get.user_id)){						
					a=1;					
					if(get.user_pw.equals(user_pw)){					
					a=2;
					System.out.println("로그인성공");
					}
				}
			}
			if(a==1) {
				System.out.println("비번틀림");
			}	 
		 return a;
	 }public int check2(String user_id,String user_pw) {
		 SqlSession session = sqlSessionFactory.openSession(); 
		 UserMapper mapper  =session.getMapper(UserMapper.class);
		 userDTO get = mapper.check1(user_id, user_pw);		 
		
		 		int a =0;	
			if(get==null) {
				System.out.println("아이디틀림");
			}else {
				if(user_id.equals(get.user_id)){						
					a=1;					
					if(get.user_pw.equals(user_pw)){					
					a=2;
					System.out.println("로그인성공");
					}
				}
			}
			if(a==1) {
				System.out.println("비번틀림");
			}	 
		 return a;
	 }
}
