package bean;

import java.sql.Timestamp;

public class lsubean {
	private String mahd;
	private String makh;
	private Timestamp ngaymua;
	private boolean damua;
	
	
	public lsubean() {
		super();
	}
	public lsubean(String mahd, String makh, Timestamp ngaymua, boolean damua) {
		super();
		this.mahd = mahd;
		this.makh = makh;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public Timestamp getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Timestamp ngaymua) {
		this.ngaymua = ngaymua;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
}
