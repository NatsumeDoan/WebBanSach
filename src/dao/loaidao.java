package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {

	public ArrayList<loaibean> getloai() {
		try {
			ArrayList<loaibean> dsloai = new ArrayList<loaibean>();
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select * from loai";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				String maloai = rs.getString("maloai");
				String tenloai = rs.getString("tenloai");
				dsloai.add(new loaibean(maloai, tenloai));
			}

			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
			return dsloai;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public int addloai(String maloai, String tenloai) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into loai values (?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int sualoai(String mloaicu,String maloai, String tenloai) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "update loai set maloai= ? , tenloai = ? where maloai= ? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			cmd.setString(3, mloaicu);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int xoaloai(String maloai) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "delete from loai where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int getmaloai(String maloai) {
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select count(*) from loai where maloai = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
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
