package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATIN;


public class Stock {
	/**
	 *  the class for the Stock typhus and method
	 */
	
	private float ask,bid;
	private Date date;
	private String symbol;
	private int stockQuantity;
	private ALGO_RECOMMENDATIN recommendation;

	/**
	 * set data into format
	 */
	private SimpleDateFormat dataFormat =new SimpleDateFormat("MM/dd/YYYY");
	
	/**
	 * set data to the stock
	 */
	public Stock(String symbol, float ask, float bid, Date date) {
		setSymbol  (symbol);
		setAsk  (ask);
		setBid  (bid);
		setDate  (date);
	}
	/**
	 * copy cot'r for Stock
	 */
	public Stock(Stock copyStock) {
		 this (copyStock.getSymbol(),copyStock.getAsk(),copyStock.getBid(),copyStock.getDate());
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
	public float getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public ALGO_RECOMMENDATIN getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATIN recommendation) {
		this.recommendation = recommendation;
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