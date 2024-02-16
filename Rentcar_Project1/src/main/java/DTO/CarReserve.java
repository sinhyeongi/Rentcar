package DTO;

public class CarReserve {
	private int reserve_seq;
	private int no;//렌트카 고유 번호
	private String id;
	private int qty;//렌트한 수량
	private String dday;//대여시작일
	private int rday;//대여시간
	private int usein;//운전자 보험 여부
	private int usewifi;//인터넷 여부
	private int usenavi;//네비게이션 대여 여부
	private int useseat;//베이비시트 적용
	private int price;
	private String name;
	public CarReserve() {
		
	}
	
	@Override
	public String toString() {
		return "CarReserve [reserve_seq=" + reserve_seq + ", no=" + no + ", id=" + id + ", qty=" + qty + ", dday="
				+ dday + ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", usenavi=" + usenavi
				+ ", useseat=" + useseat + "]";
	}
	public CarReserve(int reserve_seq,int no, String id, int qty, String dday, int rday, int usein, int usewifi, int usenavi,
			int useseat,int price) {
		this.reserve_seq = reserve_seq;
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
		this.price = price;
	}
	public CarReserve(int no, String id, int qty, String dday, int rday, int usein, int usewifi, int usenavi,
			int useseat) {
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
	}
	public CarReserve(int no, String id, int qty, String dday, int rday, int usein, int usewifi, int usenavi,
			int useseat,int price) {
		this.no = no;
		this.id = id;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.useseat = useseat;
		this.price = price;
	}
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDday() {
		return dday;
	}
	public void setDday(String dday) {
		this.dday = dday;
	}
	public int getRday() {
		return rday;
	}
	public void setRday(int rday) {
		this.rday = rday;
	}
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}
	public int getUseseat() {
		return useseat;
	}
	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
}
