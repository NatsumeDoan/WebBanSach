package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangnhapdao {

	public dangnhapbean ktdn(String tendn, String pass) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from DangNhap where TenDangNhap=? and MatKhau=?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
			ResultSet rs = cmd.executeQuery();
			dangnhapbean dn = null;
			if (rs.next()) {// Dang nhap thanh cong
				String TenDangNhap = rs.getString("TenDangNhap");
				String MatKhau = rs.getString("MatKhau");
				boolean Quyen = rs.getBoolean("Quyen");
				dn = new dangnhapbean(TenDangNhap, MatKhau, Quyen);
			}
			rs.close();
			cs.cn.close();
			return dn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getTaiKhoan(String tendn, String pass) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from KHACHHANG where TenDN = ? and Pass = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, tendn);
			cmd.setString(2, pass);
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
			String sql = "select MaKH from KHACHHANG where TenDN = ? ";
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
}
