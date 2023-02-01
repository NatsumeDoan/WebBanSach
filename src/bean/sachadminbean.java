package bean;

import java.sql.Date;

public class sachadminbean {
	
	private String masach;
	private String tensach;
	private String tacgia;
	private long soluong;
	private long gia;
	private String anh;
	private String maloai;
	private String sotap;
	private Date ngaynhap;
	public sachadminbean() {
	}
	
	public sachadminbean(String masach, String tensach, String tacgia, long soluong, long gia, String anh, String maloai,
			String sotap, Date ngaynhap) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.soluong = soluong;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
		this.sotap = sotap;
		this.ngaynhap = ngaynhap;
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
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getSotap() {
		return sotap;
	}

	public void setSotap(String sotap) {
		this.sotap = sotap;
	}

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
}
