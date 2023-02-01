package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;

/**
 * Servlet implementation class sualoaicontroller
 */
@WebServlet("/sualoaicontroller")
public class sualoaicontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sualoaicontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadminController");
			rd.forward(request, response);
		}
		else {
		String maloai= request.getParameter("ml");
		String tenloai= request.getParameter("tl");
		String maloaisua= request.getParameter("txtml");
		String maloaicu= request.getParameter("txtmlc");
		String tenloaisua= request.getParameter("txttl");
		if(maloai!=null && tenloai !=null) {
			request.setAttribute("tenloai", tenloai);
			request.setAttribute("maloai", maloai);
			RequestDispatcher rd= request.getRequestDispatcher("sualoai.jsp");
	 	    rd.forward(request, response);
		}
		if(maloaisua!=null && tenloaisua !=null && maloaicu!=null) {
			loaibo lbo = new loaibo();
			if(maloaicu==maloaisua) {
				lbo.sualoai(maloaicu, maloaisua, tenloaisua);
			}
			else if(lbo.getmaloai(maloaisua)==0)
				lbo.sualoai(maloaicu, maloaisua, tenloaisua);
			else {
				request.setAttribute("tl", "ko co");
			}
			RequestDispatcher rd= request.getRequestDispatcher("loaicontroller");
	 	    rd.forward(request, response);
		}
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
