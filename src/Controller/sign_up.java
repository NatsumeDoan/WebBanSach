package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.sign_upbo;



/**
 * Servlet implementation class sign_up
 */
@WebServlet("/sign_up")
public class sign_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_up() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		sign_upbo tk= new sign_upbo();
		
		
		String name = request.getParameter("name");
        String diachi = request.getParameter("address");
        String sodt = request.getParameter("phone");
        String email = request.getParameter("email");
        String tendn = request.getParameter("tendn");
        String pass = request.getParameter("pass");
        pass= tk.getpass(pass);

       if(tendn!=null && pass!=null && sodt!=null && email!=null && name!=null && diachi !=null) {
        HttpSession session = request.getSession();
        if(tk.checkKhachHang(tendn, pass)==0) {
        	
        	tk.addKhachHang(name, diachi, sodt, email, tendn, pass);
        	
        	session.setAttribute("DangNhap", tk.getTenKhachHang(tendn, pass));
        	response.sendRedirect("login.jsp");
        }
        else {
        RequestDispatcher rd = request.getRequestDispatcher("sign_up.jsp");
		rd.forward(request, response);}
		}
        else {
        	 RequestDispatcher rd = request.getRequestDispatcher("sign_up.jsp");
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
