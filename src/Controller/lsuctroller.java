package Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.giohangbo;
import bo.taikhoanbo;
import dao.lsudao;



/**
 * Servlet implementation class lsuctroller
 */
@WebServlet("/lsuctroller")
public class lsuctroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lsuctroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long millis = System.currentTimeMillis();
		Date ngaymua = new Date(millis);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		taikhoanbo t = new taikhoanbo();
		lsudao ls= new lsudao();
		HttpSession session = request.getSession();
		giohangbo gh;
		String tendn = request.getParameter("tendn");
		String act = request.getParameter("act");
		if(act!=null) {
			if(act.equals("add")) {
				gh= (giohangbo) session.getAttribute("gio");
				ls.themhd(t.getmakh(tendn),ngaymua);
				for(giohangbean g : gh.ds) {
					String ms=g.getMaSach();
					int sl=(int)g.getSoluong();
					for(int i : ls.getmahoadon(t.getmakh(tendn))) {
						ls.themchitiet(ms,sl,i);
					}
				}
				gh.TraLaiTatCa();
			}
		}
		
		if(tendn==null||tendn.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("lsu", ls.getlistlsu(t.getmakh(tendn)));
			 RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
				rd.forward(request, response);
			 
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
