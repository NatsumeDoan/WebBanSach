package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {

	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String maSach, String tenSach, long soluong, long gia, String anh) {
		for(giohangbean g : ds) {
			if(g.getMaSach().equals(maSach)) {
				g.setSoluong(soluong+g.getSoluong());
				return;
			}
		}
		ds.add(new giohangbean(maSach, tenSach, soluong, gia, anh));
	}
	
	public long TongTien() {
		long tongtien=0;
		for(giohangbean g : ds) {
			tongtien += g.getThanhtien();
		}
		return tongtien;
	}
	
	public void SuaSoLuong(String maSach, long soluong) {
		for (int i = 0; i < ds.size(); i++) {
			if(ds.get(i).getMaSach().equals(maSach) && ds.get(i).getSoluong()!=soluong)
				ds.get(i).setSoluong(soluong);
			if(soluong<=0)
				TraLai(maSach);
		}
	}
	
	public void TraLai(String maSach) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaSach().equals(maSach)) {
				ds.remove(i);
				break;
			}
		}
	}
	
	public void TraLaiTatCa() {
		ds.removeAll(ds);
	}
}
