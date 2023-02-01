package bean;

public class lsuctbean {
	private String mahd;
	private String masach;
	private String tensach;
	private int soluong;
	private int gia;
	private String anh;
	private boolean damua;
	public lsuctbean(String mahd, String masach, String tensach, int soluong, int gia, String anh, boolean damua) {
		super();
		this.mahd = mahd;
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.damua = damua;
	}
	public lsuctbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	

}
