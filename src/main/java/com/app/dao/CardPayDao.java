package com.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.gen.IdGenerator;
import com.app.model.CardInfo;
import com.app.util.DBConnUtil;

public class CardPayDao {

	public static String createTx(CardInfo info) {
		String uid=null;
		if(info.getAmt()!=0.0) {
			String sql ="insert into cardtab values(?,?,?,?,?,?)";
			uid=IdGenerator.getTxId();
			try {
				PreparedStatement ptstmt=DBConnUtil.getConn().prepareStatement(sql);
				ptstmt.setString(1, uid);
				ptstmt.setString(2, info.getCname());
				ptstmt.setString(3, info.getCnum());
				ptstmt.setInt(4, info.getCvv());
				ptstmt.setString(5, info.getExpDate());
				ptstmt.setDouble(6, info.getAmt());
				ptstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return uid;
	}
	
	
	public static List<CardInfo> viewAllTx(){
		List<CardInfo> list=null;
		try {
			String sql="select * from cardtab";
			PreparedStatement ptstmt=DBConnUtil.getConn().prepareStatement(sql);
			ResultSet rst=ptstmt.executeQuery();
			list=new ArrayList<>();
			while(rst.next()) {
				list.add(new CardInfo(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getDouble(6)));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static CardInfo getOneTx(String txId){
		CardInfo cinfo=null;
		try {
			String sql="select * from cardtab where txId=?";
			PreparedStatement ptstmt=DBConnUtil.getConn().prepareStatement(sql);
			ptstmt.setString(1, txId);
			ResultSet rst=ptstmt.executeQuery();
			while(rst.next()) {
				cinfo =new CardInfo(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getDouble(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cinfo;
	}
	
}
