package bo;

import dao.sign_updao;

public class sign_upbo {
	sign_updao khdao = new sign_updao();
	public String getTenKhachHang(String tk, String mk) {
		return khdao.getTenKhachHang(tk, mk);
	}
	public int checkKhachHang(String tk, String mk) {
		return khdao.checkKhachHang(tk, mk);
	}
	public void addKhachHang(String hoTen, String diaChi, String sdt, String email, String tk, String mk) {
		khdao.addKhachHang(hoTen, diaChi, sdt, email, tk, mk);
	}
	public String getpass(String pass) {
		return sign_updao.getpass(pass);
	}
}