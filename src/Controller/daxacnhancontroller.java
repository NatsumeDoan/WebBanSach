package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.xacnhanbo;

/**
 * Servlet implementation class daxacnhancontroller
 */
@WebServlet("/daxacnhancontroller")
public class daxacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public daxacnhancontroller() {
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
		xacnhanbo xnbo= new xacnhanbo();
		request.setAttribute("dsdtt", xnbo.getdanhsachdathanhtoan());
		RequestDispatcher rd= request.getRequestDispatcher("dathanhtoan.jsp");
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
