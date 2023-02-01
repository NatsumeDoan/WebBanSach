package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lsubean;

public class lsudao {
String sql;
	public ArrayList<lsubean> getlistlsu(String makh){
		ArrayList<lsubean> list = new ArrayList<lsubean>();
		try {
			CoSodao cs= new CoSodao();
			cs.KetNoi();
			sql = "select * from hoadon where hoadon.makh =? ";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				list.add(new lsubean(rs.getString(1),rs.getString(2),rs.getTimestamp(3),rs.getBoolean(4)));
			}
			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int themchitiet(String ms, int sl , int i){
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into ChiTietHoaDon values (?, ?, ?,'false')";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, ms);
			cmd.setInt(2, sl);
			cmd.setInt(3, i);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int themhd(String makh, Date ngaymua){
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "insert into hoadon values (?, ?, ?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			cmd.setDate(2, ngaymua);
			cmd.setBoolean(3, false);
			int kq = cmd.executeUpdate();
			cs.cn.close();
			return kq;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public  ArrayList<Integer> getmahoadon(String makh) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			// B1: kết nối csdl
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			String sql = "select MaHoaDon from hoadon where makh = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, makh);
			ResultSet rs = cmd.executeQuery();
			// B3: Duyệt qua tập dữ liệu lấy về
			while (rs.next()) {
				list.add(rs.getInt(1)) ;
			}
			// B4: Đóng rs và cn
			rs.close();
			cs.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
