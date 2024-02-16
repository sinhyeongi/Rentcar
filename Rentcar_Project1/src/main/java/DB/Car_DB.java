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
	public CarVO getData(int target) {
		CarVO vo = null;
		String sql = "select * from rentcar where no = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, target);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new CarVO(rs.getInt("no"), rs.getString("name"), rs.getString("category"), rs.getInt("price"), rs.getInt("usepeople"), rs.getInt("total_qty"), rs.getString("company"),rs.getString("img"),rs.getString("info"));
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	public ArrayList<CarVO> getAllData_Category(String Category) {
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		String sql = "select * from rentcar where category = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(Category));
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
	public int SubCarCount(int count,int no) {
		int cnt = -1;
		String sql = "update rentcar set total_qty = "
				+ "(select total_qty from (select (total_qty-"+count+") as total_qty from rentcar where no = ?)tmp) where no = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int Carreservecancel(int no,int qty) {
		int cnt = -1;
		String sql = "update rentcar set total_qty = (select total_qty from (select (total_qty+"+qty+") as total_qty from rentcar where no = ?)tmp) where no = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setInt(2, no);
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int InsertCar(CarVO vo) {
		int cnt = -1;
		String sql = "insert into rentcar (name,category,price,usepeople,total_qty,company,img,info) values(?,?,?,?,?,?,?,?)";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setInt(2, Integer.parseInt(vo.getCategory()));
			ps.setInt(3, vo.getPrice());
			ps.setInt(4, vo.getUsepeople());
			ps.setInt(5, vo.getTotal_qty());
			ps.setString(6, vo.getCompany());
			ps.setString(7, vo.getImg());
			ps.setString(8, vo.getInfo());
			cnt = ps.executeUpdate();
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int CheckName(String name) {
		int cnt = -1;
		String sql = "select * from rentcar where name = ?";
		try {
			Connection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				cnt=1;
			}
			DeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
