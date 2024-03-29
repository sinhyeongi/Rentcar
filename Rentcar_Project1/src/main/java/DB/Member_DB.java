package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.MemberVO;

public class Member_DB {
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	private String dbname;
	private String dbuser;
	private String dbpassword;
	private static Member_DB instance;
	private Member_DB() {
		ps = null;
		con = null;
		rs = null;
		dbname = "rentcarDB01";
		dbuser = "root";
		dbpassword = "system";
	}
	public static Member_DB getInstance() {
		if(instance == null) {
			instance = new Member_DB();
		}
		return instance;
	}
	private void Connection() {
		String url = "jdbc:mysql://localhost:3306/"+dbname+"?useSSL=false&charaterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,dbuser,dbpassword);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void DeConnection() {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null ) {ps.close();}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MemberVO> getAll(){
		ArrayList<MemberVO>list = new ArrayList<MemberVO>();
		String sql = "select * from member";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getInt("no"),rs.getString("id"), rs.getString("pw"), rs.getString("email"), rs.getString("tel"), rs.getString("hobby"), rs.getString("job"), rs.getString("age"),rs.getString("info")));
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public MemberVO getUser(String id) {
		MemberVO vo = null;
		String sql = "select * from member where id = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getInt("no"), rs.getString("id"), rs.getString("pw"), rs.getString("email"), rs.getString("tel"), rs.getString("hobby"), rs.getString("job"), rs.getString("age"),rs.getString("info"));
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public String LoginCheck(String id,String pw) {
		String cnt = null;
		String sql = "select * from member where id = ? and pw = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next())
				cnt = rs.getString("id");
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}
}
