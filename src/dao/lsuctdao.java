package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lsuctbean;

public class lsuctdao {
	String sql;
	public ArrayList<lsuctbean> getlsuct(String mahd)
	{	
		ArrayList<lsuctbean> list = new ArrayList<lsuctbean>();
		try {
			CoSodao cs= new CoSodao();
			cs.KetNoi();
			sql = "select MaHoaDon,ChiTietHoaDon.MaSach,tensach,SoLuongMua,gia,anh,damua from ChiTietHoaDon inner join sach on sach.masach= ChiTietHoaDon.MaSach where MaHoaDon = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1, mahd);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				list.add(new lsuctbean(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getBoolean(7)));
			}
			rs.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
}
