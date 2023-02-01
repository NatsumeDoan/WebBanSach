package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class suasach
 */
@WebServlet("/suasach")
public class suasach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suasach() {
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
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String nameimg = null;
		String masach= null;
		String masachcu= null;
		String tensach= null;
		String sotap= null;
		String tacgia= null;
		String soluong = null;
		Date ngaynhap= null;
		String gia =null;
		String maloai= null;
		sachbo sbo = new sachbo();
		String anhcu = null;
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				String tentk = fileItem.getFieldName();
				if (tentk.equals("txtfilecu"))
					anhcu = (fileItem.getString());
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
					if(!anhcu.equals("image_sach")) {
						String fileanhcu = dirUrl + File.separator + anhcu;
						try {
							Files.delete(Paths.get(fileanhcu));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					if (tentk.equals("txtms"))
						masach = (fileItem.getString());
					if (tentk.equals("txtmsc"))
						masachcu = (fileItem.getString());
					if (tentk.equals("txtts"))
						tensach = (fileItem.getString());
					if (tentk.equals("txtst"))
						sotap =(fileItem.getString()) ;
					if (tentk.equals("txttg"))
						tacgia = (fileItem.getString());
					if (tentk.equals("txtsl"))
						soluong = ((fileItem.getString()));
					if (tentk.equals("txtngay"))
						ngaynhap =Date.valueOf((fileItem.getString())) ;
					if (tentk.equals("txtdg"))
						gia = ((fileItem.getString()));
					if (tentk.equals("txtml"))
						maloai = (fileItem.getString());
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		if(masachcu==masach) {
			sbo.suaSach(masachcu, masach, tensach,Long.parseLong(soluong), Long.parseLong(gia), maloai, sotap,nameimg, ngaynhap, tacgia);
		}
		else if(sbo.getkiemtra(masach)==0)
			sbo.suaSach(masachcu, masach, tensach,Long.parseLong(soluong), Long.parseLong(gia), maloai, sotap,nameimg, ngaynhap, tacgia);
		RequestDispatcher rd= request.getRequestDispatcher("adminsachcontroller");
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
