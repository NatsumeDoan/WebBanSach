package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import bo.xacnhanbo;

/**
 * Servlet implementation class xacnhancontroller
 */
@WebServlet("/xacnhancontroller")
public class xacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhancontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		dangnhapbean dn=(dangnhapbean)session.getAttribute("admin");
		if(dn==null)
			response.sendRedirect("dangnhapadminController");
		else {
		xacnhanbo xnbo= new xacnhanbo();
		request.setAttribute("dskh", xnbo.getdanhsach());
		RequestDispatcher rd= request.getRequestDispatcher("Admin.jsp");
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
