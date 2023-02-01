package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class taikhoandao {

	public int getTaiKhoan(String tendn, String mk) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from KhachHang where tendn = ? and pass = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
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

	public String getmakh(String tdn) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select makh from KhachHang where tendn = ? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tdn);
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
