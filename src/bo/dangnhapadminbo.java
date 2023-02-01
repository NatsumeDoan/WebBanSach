package bo;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapadminbo {
	 dangnhapdao dndao=new dangnhapdao();
	  public dangnhapbean ktdn(String tendn, String pass) {
		  return dndao.ktdn(tendn, pass);
	  }
}
