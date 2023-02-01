package bo;


import dao.taikhoandao;

public class taikhoanbo {

	taikhoandao tk = new taikhoandao();
	public int getTaiKhoan(String tentk, String mk){
		return tk.getTaiKhoan(tentk, mk);
	}
	public String getmakh(String tdn){
		return tk.getmakh(tdn);
	}
	public String getMd5(String input) {
		return taikhoandao.getpass(input);
	}
	
}
