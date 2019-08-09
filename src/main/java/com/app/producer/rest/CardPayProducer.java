package com.app.producer.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.app.dao.CardPayDao;
import com.app.model.CardInfo;
@Path("/payment")
public class CardPayProducer {

	@POST
	@Path("/dopayment")
	@Consumes("application/json")
	public String createTx(CardInfo ci) {		
		String txId=CardPayDao.createTx(ci);		
		return "Card Payment done TxId : "+txId;
	} 
	
	@GET
	@Path("/getall")
	@Produces("application/json")
	public List<CardInfo> viewAllTx() {		
		List<CardInfo> list=CardPayDao.viewAllTx();		
		return list;
	} 
	
	@GET
	@Path("/getone")
	@Produces("application/json")
	public CardInfo getOneTx(@QueryParam("txid") String id) {		
		CardInfo cinfo=CardPayDao.getOneTx(id);		
		return cinfo;
	} 
}
