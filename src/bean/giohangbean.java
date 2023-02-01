package bean;

public class giohangbean {

	private String maSach;
	private String tenSach;
	private long soluong;
	private long gia;
	@SuppressWarnings("unused")
	private long thanhtien;
	private String anh;
	
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public giohangbean(String maSach, String tenSach, long soluong, long gia, String anh) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = soluong*gia;
		this.anh = anh;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public long getSoluong() {
		return soluong;
	}

	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getThanhtien() {
		return soluong*gia;
	}

	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
