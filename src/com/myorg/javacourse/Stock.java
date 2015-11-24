package com.myorg.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {
	private String symbol;
	private float ask,bid;
	private Date date;

	private SimpleDateFormat dataFormat =new SimpleDateFormat("MM/dd/YYYY");
	
	public Stock(String symbol, float ask, float bid, Date date) {
		setSymbol  (symbol);
		setAsk  (ask);
		setBid  (bid);
		setDate  (date);
	}
	
	public SimpleDateFormat getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(SimpleDateFormat dataFormat) {
		this.dataFormat = dataFormat;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHtmlDescription(){
		String result = "<b>Symbol:</b> "+ this.symbol + ", <b>Ask:</b> "+ this.ask + ", <b>Bid:</b> "+ this.bid + ", <b>Date:</b> "+ dataFormat.format(this.date)+ "<br>" ;
		return result;
	}
	
	


}
