package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CarReserve;

public class CarReserve_DB {
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	private String dbuser;
	private String dbpassword;
	private String dbname;
	private static CarReserve_DB instance;
	private CarReserve_DB() {
		dbname = "rentcarDB01";
		dbuser = "root";
		dbpassword = "system";
	}
	public static CarReserve_DB getInstance() {
		if(instance == null) {
			instance = new CarReserve_DB();
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
			if(con != null ) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public int InsertData(CarReserve vo) {
		int cnt = -1;
		String sql = "insert into carreserve(no,id,qty,dday,rday,usein,usewifi,usenavi,useseat,price) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getQty());
			ps.setString(4, vo.getDday());
			ps.setInt(5, vo.getRday());
			ps.setInt(6, vo.getUsein());
			ps.setInt(7, vo.getUsewifi());
			ps.setInt(8, vo.getUsenavi());
			ps.setInt(9, vo.getUseseat());
			ps.setInt(10, vo.getPrice());
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public ArrayList<CarReserve> getData(String id){
		ArrayList<CarReserve> list = new ArrayList<CarReserve>();
		String sql = "select * from carreserve where id =?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				String data[] = rs.getString("dday").split("/");
				String m[] = data[0].split("-");
				String data2 = m[0]+"년 "+m[1]+"월 "+m[2]+"일<br/>"+data[1]+"시";
				list.add(new CarReserve(rs.getInt("reserve_seq"),rs.getInt("no"),rs.getString("id"),rs.getInt("qty"),data2,rs.getInt("rday"),rs.getInt("usein"),rs.getInt("usewifi"),rs.getInt("usenavi"),rs.getInt("useseat"),rs.getInt("price")));
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int Carreservecancel(int seq,String id) {
		int cnt = -1;
		String sql = "delete from carreserve where id =? and reserve_seq = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, seq);
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public ArrayList<String> getCarreservecancel_Oneuser(String id){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select * from carreserve where id = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				String str = String.valueOf(rs.getInt("no"))+"/"+String.valueOf(rs.getInt("qty"));
				list.add(str);
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int Carreservecancel_Oneuser(String id) {
		int cnt = 0;
		String sql = "delete from carreserve where id = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int Carreservecancel_Admin(int no) {
		int cnt = 0;
		String sql = "delete from carreserve where no = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
