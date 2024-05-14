package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public ArrayList<userDTO> getUser();
	public void insertUser(userDTO userDTO);
	public void deleteUser(String user_id);
	public void updateUser(@Param("name") String name,@Param("user_id") String user_id);
	public String[] getID();
	public String[] getPW();
	public int check(@Param("id")String id,@Param("pw")String pw);	
	public userDTO check1(@Param("user_id")String user_id,@Param("user_pw")String user_pw);	
}
