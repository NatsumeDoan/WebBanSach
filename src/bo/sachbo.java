package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {

	sachdao sdao = new sachdao();

	public int getTotalBook() {
		return sdao.getTotalBooks();
	}

	public int countBooksByMaLoai(String ml) {
		return sdao.countBooksByMaLoai(ml);
	}

	public int countBooksBySearchValue(String giaTriTimKiem) {
		return sdao.countBooksBySearchValue(giaTriTimKiem);
	}

	public ArrayList<sachbean> pagingBooksByMaSach(int offset, String ml) {
		return sdao.pagingBooksByMaSach(offset, ml);
	}

	public ArrayList<sachbean> pagingBooksBySearchValue(int offset, String giaTriTimKiem) {
		return sdao.pagingBooksBySearchValue(offset, giaTriTimKiem);
	}

	public ArrayList<sachbean> pagingBooks(int offset) {
		return sdao.pagingBooks(offset);
	}
	public void addsach(String ms, String ts, long sl, long gia, String ml, String st, String anh, Date ngay,
			String tg) {
		sdao.addsach(ms, ts, sl, gia, ml, st, anh, ngay, tg);
	}
	public void deleteSach(String ms) {
		sdao.deleteSach(ms);
	}
	public String getAnh(String xoa) {
		String[] arr = sdao.getAnh(xoa).split("\\/");
		return arr[arr.length - 1];
	}
	public void suaSach(String msc,String ms, String ts, long sl, long gia, String ml, String st, String anh, Date ngay,
			String tg) {
		sdao.suasach(msc,ms, ts,sl, gia,ml,  st,anh, ngay, tg);
	}
	public int getkiemtra(String masach) {
		return sdao.getkiemtra(masach);
	}
	
}
