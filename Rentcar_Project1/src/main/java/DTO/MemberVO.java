package DTO;

import javax.servlet.http.HttpServletRequest;

public class MemberVO {
	private int no;
	private String id;
	private String pw;
	private String email;
	private String tel;
	private String hobby;//취미
	private String job;//하는일
	private String age;
	private String info;
	public MemberVO(){}
	public MemberVO(int no, String id, String pw, String email, String tel, String hobby, String job, String age,
			String info) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
	}
	public MemberVO(String id, String pw, String email, String tel, String hobby, String job, String age, String info) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.tel = tel;
		this.hobby = hobby;
		this.job = job;
		this.age = age;
		this.info = info;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setUpData(HttpServletRequest request) {
		this.id = (String)request.getSession().getAttribute("log");
		this.email = request.getParameter("email");
		this.tel = request.getParameter("tel");
		this.hobby = request.getParameter("hobby");
		this.job = request.getParameter("job");
		this.age = request.getParameter("age");
		this.info = request.getParameter("info");
	}
}
