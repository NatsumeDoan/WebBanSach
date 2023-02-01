package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.xacnhandao;

public class xacnhanbo {
	xacnhandao xndao = new xacnhandao();
	public ArrayList<xacnhanbean> getdanhsach() {
		return xndao.getdanhsach();
	}
	public int xacnhan(long MaHoaDon,long MaChiTietHoaDon) {
		return xndao.xacnhan(MaHoaDon, MaChiTietHoaDon);
	}
	public ArrayList<xacnhanbean> getdanhsachdathanhtoan() {
		return xndao.getdanhsachdathanhtoan();
	}
}
