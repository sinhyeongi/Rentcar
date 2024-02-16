package DAO;

import java.util.ArrayList;

import DB.Member_DB;
import DTO.MemberVO;

public class MemberDAO {
	private Member_DB db;
	private static MemberDAO instance;
	private MemberDAO() {
		if(db == null) {
			db = Member_DB.getInstance();
		}
	}
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	public ArrayList<MemberVO> getAllData(){
		return db.getAll();
	}
	public MemberVO getUser(String id) {
		return db.getUser(id);
	}
	public String LoginCheck(String id, String pw) {
		return db.LoginCheck(id, pw);
	}
	public int UpdateInfo(MemberVO vo) {
		return db.Update(vo);
	}
	public int InsertMember(MemberVO vo) {
		return db.InsertMember(vo);
	}
	public int DeleteMember(String id) {
		return db.DeleteMember(id);
	}
}
