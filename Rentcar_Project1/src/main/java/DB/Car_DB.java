package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CarVO;

public class Car_DB {
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	private String dbname;
	private String dbuser;
	private String dbpassword;
	private static Car_DB instance;
	private Car_DB(){
		dbname = "rentcarDB01";
		dbuser = "root";
		dbpassword = "system";
	}
	public static Car_DB getInstance() {
		if(instance == null) {
			instance = new Car_DB();
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
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void DeConnection() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<CarVO> getAllData() {
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		String sql = "select * from rentcar";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CarVO(rs.getInt("no"), rs.getString("name"), rs.getString("category"), rs.getInt("price"), rs.getInt("usepeople"), rs.getInt("total_qty"), rs.getString("company"),rs.getString("img"),rs.getString("info")));
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
