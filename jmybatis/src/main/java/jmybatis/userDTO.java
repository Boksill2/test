package jmybatis;

public class userDTO {
	String user_id;
	String user_pw;
	String name;
	String phone;
	String grade;
	int age;

	public userDTO(String user_id, String user_pw, String name, String phone, String grade, int age) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.name = name;
		this.phone = phone;
		this.grade = grade;
		this.age = age;
	}

	public String getuser_id() {
		return user_id;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getuser_pw() {
		return user_pw;
	}

	public void setUser_(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {

		return user_id + "\t" + user_pw + "\t" + name + "\t" + phone + "\t" + grade + "\t" + age+"\n";
	}

}
