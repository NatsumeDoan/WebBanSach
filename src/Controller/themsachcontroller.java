package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.sachbo;

/**
 * Servlet implementation class themsachcontroller
 */
@WebServlet("/themsachcontroller")
public class themsachcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themsachcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("dangnhapadminController");
			rd.forward(request, response);
		} else {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			if (request.getContentLength() <= 0) {
				RequestDispatcher rd = request.getRequestDispatcher("themsach.jsp");
				rd.forward(request, response);
			} else {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "image_sach";
				response.getWriter().println(dirUrl1);
				String nameimg = null;
				String masach = null;
				String tensach = null;
				String sotap = null;
				String tacgia = null;
				long soluong = 0;
				Date ngaynhap = null;
				long dongia = 0;
				String maloai = null;
				try {
					List<FileItem> fileItems = upload.parseRequest(request);// L???y v??? c??c ?????i t?????ng g???i l??n
					// duy???t qua c??c ?????i t?????ng g???i l??n t??? client g???m file v?? c??c control
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {// N???u ko ph???i c??c control=>upfile l??n
							// x??? l?? file
							nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
								// L???y ???????ng d???n hi???n t???i, ch??? ?? x??? l?? tr??n dirUrl ????? c?? ???????ng d???n ????ng
								String dirUrl = request.getServletContext().getRealPath("") + File.separator
										+ "image_sach";
								File dir = new File(dirUrl);
								if (!dir.exists()) {// n???u ko c?? th?? m???c th?? t???o ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);// t???o file
								try {
									fileItem.write(file);// l??u file
									System.out.println("UPLOAD TH??NH C??NG...!");
									System.out.println("???????ng d???n l??u file l??: " + dirUrl);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else// Neu la control
						{
							String tentk = fileItem.getFieldName();
							if (tentk.equals("txtms"))
								masach = (fileItem.getString());
							if (tentk.equals("txtts"))
								tensach = (fileItem.getString());
							if (tentk.equals("txtst"))
								sotap = (fileItem.getString());
							if (tentk.equals("txttg"))
								tacgia = (fileItem.getString());
							if (tentk.equals("txtsl"))
								soluong = Long.parseLong((fileItem.getString()));
							if (tentk.equals("txtngay"))
								ngaynhap = Date.valueOf((fileItem.getString()));
							if (tentk.equals("txtdg"))
								dongia = Long.parseLong((fileItem.getString()));
							if (tentk.equals("txtml"))
								maloai = (fileItem.getString());
						}
					}

				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				sachbo sbo = new sachbo();
				sbo.addsach(masach, tensach, soluong, dongia, maloai, sotap, nameimg, ngaynhap, tacgia);
				RequestDispatcher rd = request.getRequestDispatcher("adminsachcontroller");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
