package com.internousdev.espresso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.espresso.dto.DestinationInfoDTO;
import com.internousdev.espresso.util.DBConnector;

public class DestinationInfoDAO {
	public int insert(String user_id, String family_name, String first_name, String family_name_kana,
			String first_name_kana, String email, String tel_number, String user_address) {

		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		int count = 0;

		//宛先情報を取得するSQL文
		String sql = "INSERT INTO destination_info(user_id,family_name,first_name,family_name_kana,first_name_kana,email,tel_number,user_address,regist_date,update_date) VALUES(?,?,?,?,?,?,?,?,now(),now())";
		try {
			//SQL文を実行
			//取得した宛先情報をDTOに格納
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, family_name);
			ps.setString(3, first_name);
			ps.setString(4, family_name_kana);
			ps.setString(5, first_name_kana);
			ps.setString(6, email);
			ps.setString(7, tel_number);
			ps.setString(8, user_address);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			//例外を処理
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//DTOに格納
		return count;
	}

	//宛先情報をDBから取得するメソッドを作成
	public List<DestinationInfoDTO> getDestinationInfo(String userId) {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		//宛先情報リストの生成
		List<DestinationInfoDTO> destinationInfoList = new ArrayList<DestinationInfoDTO>();
		//値を取り出す
		String sql = "SELECT id,family_name,first_name,family_name_kana,first_name_kana,email,tel_number,user_address "
				+ "FROM destination_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			//DTOに値を格納する
			while (rs.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNumber(rs.getString("tel_number"));
				dto.setUserAddress(rs.getString("user_address"));
				destinationInfoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return destinationInfoList;
	}

	//jspで受け取った住所一覧を削除するメソッドを作成
	public int deleteDestinationInfo(String id) {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		//SQL文を記載
		String sql = "DELETE FROM destination_info WHERE id=?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}