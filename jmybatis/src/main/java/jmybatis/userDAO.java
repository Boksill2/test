package jmybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDAO {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://127.0.0.1/test?serverTimezone=UTC";

	String dbId = "root";
	String dbPw = "1234";
	ArrayList<userDTO> users = new ArrayList<>();

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (rs != null) {
				pt.close();
			}
			if (rs != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(userDTO userDTO) {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String sql = "insert into user value(?,?,?,?,?,?)";
			pt = conn.prepareStatement(sql);
			pt.setString(1, userDTO.getuser_id());
			pt.setString(2, userDTO.getuser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());

			pt.executeUpdate();

			pt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void selectUser() {

		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String selectSql = "select * from user";
			pt = conn.prepareStatement(selectSql);
			rs = pt.executeQuery();

			while (rs.next()) {
				String ud = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String grade = rs.getString(5);
				int age = rs.getInt(6);

				userDTO dto = new userDTO(ud, pw, name, phone, grade, age);

				users.add(dto);
			}

			for (userDTO i : users) {
				System.out.println(i);
			}
			pt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String user_id) {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String deleteSql = "delete from user where user_id = ?";
			pt = conn.prepareStatement(deleteSql);
			pt.setString(1, user_id);
			pt.executeUpdate();

			pt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateUser(String name, String user_id) {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String updateSql = "update user set name=? where user_id = ?";
			pt = conn.prepareStatement(updateSql);
			pt.setString(1, name);
			pt.setString(2, user_id);
			pt.executeUpdate();

			pt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<userDTO> searchUser(String name) {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String searchSql = "select * from user where name like ?";
			pt = conn.prepareStatement(searchSql);
			pt.setString(1, "%" + name + "%");
			rs = pt.executeQuery();
			while (rs.next()) {
				String ud = rs.getString(1);
				String pw = rs.getString(2);
				String name1 = rs.getString(3);
				String phone = rs.getString(4);
				String grade = rs.getString(5);
				int age = rs.getInt(6);

				userDTO dto = new userDTO(ud, pw, name1, phone, grade, age);

				users.add(dto);
				
			}
			rs.close();
			pt.close();
			conn.close();

			return users;
//				for(userDTO i: users) {
//					System.out.println(i);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}
}
