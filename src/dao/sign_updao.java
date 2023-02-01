package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sign_updao {

	public int checkKhachHang(String tdn, String mk) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from KhachHang where tendn = ? and pass = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tdn);
			cmd.setString(2, mk);
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

	public String getTenKhachHang(String tdn, String mk) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select hoten from KhachHang where tendn = ? and pass = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tdn);
			cmd.setString(2, mk);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				return rs.getString(1);
			}

			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addKhachHang(String ht, String dc, String sdt, String email, String tdn, String mk) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into KhachHang values (?, ?, ?, ?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ht);
			cmd.setString(2, dc);
			cmd.setString(3, sdt);
			cmd.setString(4, email);
			cmd.setString(5, tdn);
			cmd.setString(6, mk);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static String getpass(String pass) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "SELECT CONVERT(VARCHAR(32), HashBytes('MD5', ?), 2) ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, pass);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				return rs.getString(1);
			}

			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}