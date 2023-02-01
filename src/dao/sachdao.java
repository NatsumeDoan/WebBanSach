package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;

public class sachdao {

	//get all sach
	public ArrayList<sachbean> getsach() {
		try {
			ArrayList<sachbean> dssach = new ArrayList<sachbean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				Date ngaynhap = rs.getDate("NgayNhap");
				dssach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai, sotap, ngaynhap));
			}
			return dssach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Cout all sach
	public int getTotalBooks() {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//count sach by maloai
	public int countBooksByMaLoai(String ml) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//count sach by search value
	public int countBooksBySearchValue(String giaTriTimKiem) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select count(*) from sach where tensach like CONCAT('%', ? , '%')";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, giaTriTimKiem);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String getAnh(String masach) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "Select anh from sach where masach =?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//get sach using pagination by masach
	public ArrayList<sachbean> pagingBooksByMaSach(int offset, String ml) {
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " where maloai = ? "
					+ " order by masach offset ? rows fetch next 18 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ml);
			cmd.setInt(2, (offset - 1) * 18);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				Date ngaynhap = rs.getDate("NgayNhap");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai, sotap, ngaynhap));
			}
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get sach using pagination with search value
	public ArrayList<sachbean> pagingBooksBySearchValue(int offset, String giaTriTimKiem){
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " where tensach like CONCAT('%', ? , '%') "
					+ " order by masach offset ? rows fetch next 18 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, giaTriTimKiem);
			cmd.setInt(2, (offset - 1) * 18);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				Date ngaynhap = rs.getDate("NgayNhap");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai, sotap, ngaynhap));
			}
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//get all sach using pagination
	public ArrayList<sachbean> pagingBooks(int offset){
		ArrayList<sachbean> dsSach = new ArrayList<sachbean>();
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from sach"
					+ " order by masach offset ? rows fetch next 18 rows only";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setInt(1, (offset - 1) * 18);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String masach = rs.getString("masach");
				String tensach = rs.getString("tensach");
				String tacgia = rs.getString("tacgia");
				long soluong = rs.getLong("soluong");
				long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				String sotap = rs.getString("sotap");
				Date ngaynhap = rs.getDate("NgayNhap");
				dsSach.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai, sotap, ngaynhap));
			}
			return dsSach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int addsach(String ms, String ts, long sl, long gia, String ml, String st, String anh, Date ngay, String tg) {
		try {
			
			String nameimg= "image_sach/"+anh;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into sach values (?, ?, ?, ?, ?, ?,?,?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setString(2, ts);
			cmd.setLong(3, sl);
			cmd.setLong(4, gia);
			cmd.setString(5, ml);
			cmd.setString(6, st);
			cmd.setString(7, nameimg);
			cmd.setDate(8, ngay);
			cmd.setString(9, tg);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int suasach(String msc,String ms, String ts, long sl, long gia, String ml, String st, String anh, Date ngay,
			String tg) {
		try {
			
			String nameimg= "image_sach/"+anh;
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update sach\r\n"
					+ "set masach=?,tensach=?,soluong=?,gia=?,maloai=?,sotap=?,anh=?,NgayNhap=?,tacgia=?\r\n"
					+ "Where masach=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setString(2, ts);
			cmd.setLong(3, sl);
			cmd.setLong(4, gia);
			cmd.setString(5, ml);
			cmd.setString(6, st);
			cmd.setString(7, nameimg);
			cmd.setDate(8, ngay);
			cmd.setString(9, tg);
			cmd.setString(10, msc);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int deleteSach(String masach) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from sach where masach = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int getkiemtra(String masach) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from sach where masach = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, masach);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				return rs.getInt(1);
			}
			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
