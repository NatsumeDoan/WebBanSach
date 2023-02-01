package bean;

import java.util.Date;

public class xacnhanbean {
	private long MaChiTietHD;
	private long MaHoaDon;
	private long makh;
	private String hoten;
	private String tensach;
	private long SoLuongMua;
	private long gia;
	private long ThanhTien;
	private Date NgayMua;
	private boolean damua;
	public xacnhanbean(long maChiTietHD, long maHoaDon, long makh, String hoten, String tensach, long soLuongMua,
			long gia, long thanhTien, Date ngayMua, boolean damua) {
		super();
		MaChiTietHD = maChiTietHD;
		MaHoaDon = maHoaDon;
		this.makh = makh;
		this.hoten = hoten;
		this.tensach = tensach;
		SoLuongMua = soLuongMua;
		this.gia = gia;
		ThanhTien = thanhTien;
		NgayMua = ngayMua;
		this.damua = damua;
	}
	public xacnhanbean() {
		super();
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}


}
