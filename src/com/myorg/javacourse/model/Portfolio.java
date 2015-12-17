package com.myorg.javacourse.model;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Portfolio {
	/**
	 *  the class for the Portfolio typhus and method-natan
	 */
	public enum ALGO_RECOMMENDATIN {BUY, SELL, REMOVE, HOLD};
	private String title;
	private final static int MAX_PORTFOLIO_SIZE =5;
	private Stock [] stocks;
	private int portfolioSize;
	private float balance;
	
	public Portfolio() {
		this.stocks= new Stock [MAX_PORTFOLIO_SIZE];
	}
	
	/**
	 *  copy cot'r for Portfolio
	 */
	public Portfolio(Portfolio copyPortfolio) {
		this.portfolioSize=copyPortfolio.getPortfolioSize();
		for(int i=0; i<this.getPortfolioSize();i++)
			this.stocks[i]=new Stock(copyPortfolio.stocks[i]);
	}	
	
	/**
	 *   method that update balance According amount 
	 *   and changes all  those affected from that update.
	 */	
	public void updateBalance(float amount){
		if (balance+amount >= 0)
			this.balance += amount;
		else
			System.out.println("The balance should not become negative!");		
	}
	
	/**
	 * add stock to the Portfolio array.
	 */
	public void addStock (Stock  stock, String stockSymbol){
		int i;
		boolean flag= true;
		for (i = 0; i <=this.getPortfolioSize() ; i++)
		{
			if (this.stocks[i]==null)
			{
				this.stocks[getPortfolioSize()] = stock;
				this.stocks[getPortfolioSize()].setStockQuantity(0);
				flag=false;
				this.portfolioSize++;
				break;
			}
			if (this.stocks[i].equals(stockSymbol))
			{
				flag=false;
				break;
			}
		}
		if (i==MAX_PORTFOLIO_SIZE && flag)
			System.out.println("Can’t add new stock, portfolio can have only "+ portfolioSize +" stocks");
	}
		
	/**
	 *   method that remove stock completely  from Portfolio
	 *    And changes all  those affected from that remove.
	 */
	public boolean removeStock (String symbol){
		boolean boolSellStock;
		for (int i = 0; i <= this.getPortfolioSize(); i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
			{
				boolSellStock=sellStock (symbol, -1);
				this.portfolioSize=this.portfolioSize-1;
				for (int j = i; j <this.portfolioSize; j++) 
					this.stocks[j]=this.stocks[j+1];
				return boolSellStock;
			}
		}
		return false;
	}
	
	/**
	 *   method that sell stock according amount
	 *    And changes all  those affected from that sell.
	 */
	public boolean sellStock (String symbol, int quantity){
		
		if (quantity < -1 || quantity ==0)
		{
			System.out.println("ERROR!");
			return false;
		}
		for (int i = 0; i <= this.getPortfolioSize(); i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
			{
				if (quantity ==-1)
				{					
					this.updateBalance(stocks[i].getStockQuantity() * stocks[i].getBid());
					this.stocks[i].setStockQuantity (0);
					return true;
				}
				else if (quantity > this.stocks[i].getStockQuantity())
				{
					System.out.println("Not enough stocks to sell");
					return false;
				}
				else if (this.stocks[i].getStockQuantity() >= quantity)
				{
					this.updateBalance(stocks[i].getStockQuantity() * stocks[i].getBid());
					this.stocks[i].setStockQuantity((int) (this.stocks[i].getStockQuantity() - quantity));
					return true;
				}
			}
		}
		System.out.println("You can't sell stock that you don't own.");
		return false;
	}
	
	/**
	 *   method that buy stock According amount 
	 *   and changes all  those affected from that buy.
	 */
	public boolean buyStock (Stock stock, int quantity)
	{
		int i;
		boolean flag=true;;
		if (quantity < -1 || quantity ==0)		
			return false;
		for ( i = 0; i <=this.getPortfolioSize() && flag; i++)
		{
			if (this.stocks[i] != null && this.stocks[i].getSymbol().equals(stock.getSymbol()))
			{
				if (quantity ==-1)
				{
					flag=false;
					this.stocks[i].setStockQuantity ((int) (this.stocks[i].getStockQuantity()+(this.balance/stock.getAsk())));
					this.updateBalance(-(((this.balance/stock.getAsk()))*stock.getAsk()));
					return true;
				}
				else
				{
					flag=false;
					this.stocks[i].setStockQuantity ((int) (this.stocks[i].getStockQuantity()+quantity));
					this.updateBalance(-(quantity*stock.getAsk()));
					return true;
				}
			}	
		}
		if (i==MAX_PORTFOLIO_SIZE && flag)
		{
			addStock (stock,stock.getSymbol());
			return true;
		}
		return false;
	}
		
	/**
	 * delete stock from Portfolio
	 *  and changes all  those affected from that delete.
	 */
	public void deleteStock(Portfolio Portfolio, int indexToDelete) {
		Portfolio.portfolioSize=(Portfolio.portfolioSize)-1;
		for (int i = indexToDelete; i <Portfolio.portfolioSize; i++) {
			Portfolio.stocks[i]=Portfolio.stocks[i+1];
		}
	}
	
	/**
	 * change bid in Portfolio.
	 */
	public void changeBid(Portfolio Portfolio, int indexToChange,float newBid) {
		Portfolio.stocks[indexToChange].setBid(newBid);
	}
	
	public float getStocksValue() {
		float totalStocksValue = 0;
		for (int i = 0; i < portfolioSize-1; i++)
		{
			totalStocksValue=totalStocksValue+(this.stocks[i].getStockQuantity()*this.stocks[i].getBid());
		}		
		return totalStocksValue;
	}
	public float getBalance() {
		return balance;
	}
	public float setBalance(float balance) {
		return this.balance=balance;
	}
	public float getTotalValue() {
		return getBalance()+getStocksValue() ;
	}
	public String getHtmlDescription(){
		String result = this.title +"<br>"+ "<b>Total Portfolio Value:</b> "+ getStocksValue() + "$"+ "<b>, Total Stocks value:</b> "+ getTotalValue() + "$"+ "<b>, Balance:</b> "+ getBalance() + "$";
		return result;
	}
	public String getTitle() {
		return title;
	}
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	public int getPortfolioSize() {
		return portfolioSize;
	}
	public Stock [] getStocks() {
		return this.stocks;
	}
	public String getHtmlString(){
		String result = "<h1>"+ this.title+"</h1>";
		for (int i=0; i <portfolioSize; i++)
		{
			result= result+ "<br>" + this.stocks[i].getHtmlDescription();
		}
		return result;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStocks(Stock [] stocks) {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
}