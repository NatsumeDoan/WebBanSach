package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {

	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai() {
		ds = ldao.getloai();
		return ds;
	}
	public void addloai(String maloai, String tenloai) {
		ldao.addloai(maloai, tenloai);
	}
	public int getmaloai(String maloai) {
		return ldao.getmaloai(maloai);
	}
	public void xoaloai(String maloai) {
		ldao.xoaloai(maloai);
	}
	public void sualoai(String mloaicu,String maloai, String tenloai) {
		ldao.sualoai(mloaicu,maloai, tenloai);
	}
}
