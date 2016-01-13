package com.myorg.javacourse.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.myorg.javacourse.exception.BalanceException;
import com.myorg.javacourse.exception.PortfolioFullException;
import com.myorg.javacourse.exception.StockAlreadyExistsException;


public class Portfolio implements PortfolioInterface {
	/**
	 *  the class for the Portfolio typhus and method
	 */
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	private String title;
	private final static int MAX_PORTFOLIO_SIZE =5;
	private StockInterface[] stocks;
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
			this.stocks[i]=new Stock((Stock) copyPortfolio.stocks[i]);
	}	
	
	public Portfolio(Stock[] stockArray) {
		this();
		for (int i = 0; i<stockArray.length ; i++){
			this.stocks[i] = stockArray[i];	
		}
	}
	
	/**
	 *   method that update balance According amount 
	 *   and changes all  those affected from that update.
	 */	
	public void updateBalance(float amount) throws BalanceException{
		if (balance+amount >= 0)
			this.balance += amount;
		else
			throw new BalanceException("The balance should not become negative!");		
	}
	/*
	/**
	 * add stock to the Portfolio array.
	*/
	public void addStock (Stock stock) throws PortfolioFullException, StockAlreadyExistsException{
		if(stock.getAsk()==0)
			return;
		if (this.portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			for (int i = 0 ; i < this.getPortfolioSize(); i++)
			{
				if(stock.getSymbol().equals(this.stocks[i].getSymbol())){
					throw new StockAlreadyExistsException("Stock already exists");
				}
			}
			this.stocks[getPortfolioSize()] = stock;
			((Stock) this.stocks[getPortfolioSize()]).setStockQuantity(0);
			this.portfolioSize++;
		}
		else
			throw new PortfolioFullException("Can not add new stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks.");
	}
	
	/**
	 *   method that remove stock completely  from Portfolio
	 *    And changes all  those affected from that remove.
	 * @throws BalanceException 
	 */
	public void removeStock (String symbol) throws BalanceException{
		for (int i = 0; i <= this.getPortfolioSize(); i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
			{
				sellStock (symbol, -1);
				this.portfolioSize=this.portfolioSize-1;
				for (int j = i; (j <this.portfolioSize) ; j++) 
					this.stocks[j]=this.stocks[j+1];
				if (this.portfolioSize !=0)
					this.stocks[getPortfolioSize()] = null;
				else
					this.stocks[0] = null;		
				break;
			}
		}
	}
	
	/**
	 *   method that sell stock according amount
	 *    And changes all  those affected from that sell.
	 * @throws BalanceException 
	 */
	public void sellStock (String symbol, int quantity) throws BalanceException{
		
		if (quantity < -1 || quantity ==0)
		{
			throw new BalanceException("ERROR!");
		}
		for (int i = 0; i <= this.getPortfolioSize(); i++)
		{
			if (this.stocks[i].getSymbol().equals(symbol))
			{
				if (quantity ==-1)
				{					
					this.updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
					((Stock) this.stocks[i]).setStockQuantity (0);
					break;
				}
				else if (quantity > ((Stock) this.stocks[i]).getStockQuantity())
				{
					throw new BalanceException("Not enough stocks to sell");
				}
				else if (((Stock) this.stocks[i]).getStockQuantity() >= quantity)
				{
					this.updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
					((Stock) this.stocks[i]).setStockQuantity((int) (((Stock) this.stocks[i]).getStockQuantity() - quantity));
					break;
				}
			}
		}
		//System.out.println("You can't sell stock that you don't own.");
	}
	
	/**
	 *   method that buy stock According amount 
	 *   and changes all  those affected from that buy.
	 * @throws PortfolioFullException 
	 * @throws BalanceException 
	 * @throws StockAlreadyExistsException 
	 */
	public void buyStock (String symbol, int quantity) throws PortfolioFullException, BalanceException, StockAlreadyExistsException
	{
		Stock stock = (Stock) this.findStock(symbol);
		int i=0;
		boolean flag=true; 
		if (quantity > (this.balance/stock.getAsk()))
			throw new BalanceException("Not enough balance");
		
			for (i=0; i <=this.getPortfolioSize() && flag; i++)
		{
				if (this.stocks[i] != null && this.stocks[i].getSymbol().equals(symbol))
				{
					if (quantity ==-1)
						{
							flag=false;
							((Stock) this.stocks[i]).setStockQuantity ((int) (((Stock) this.stocks[i]).getStockQuantity()+(this.balance/stock.getAsk())));
							this.updateBalance(-(((this.balance/stock.getAsk()))*stock.getAsk()));
						}
				else
				{
					flag=false;
					((Stock) this.stocks[i]).setStockQuantity ((int) (((Stock) this.stocks[i]).getStockQuantity()+quantity));
					this.updateBalance(-(quantity*stocks[i].getAsk()));
					}
				}	
			}
		
		if (i==MAX_PORTFOLIO_SIZE && flag)
		{
			addStock (stock);
		}
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
		((Stock) Portfolio.stocks[indexToChange]).setBid(newBid);
	}
	
	public float getStocksValue() {
		float totalStocksValue = 0;
		for (int i = 0; i < portfolioSize-1; i++)
		{
			totalStocksValue=totalStocksValue+(((Stock) this.stocks[i]).getStockQuantity()*this.stocks[i].getBid());
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
		return (Stock[]) this.stocks;
	}
	public String getHtmlString(){
		String result = "<h1>"+ this.title+"</h1>";
		for (int i=0; i <portfolioSize; i++)
		{
			result= result+ "<br>" +((Stock) this.stocks[i]).getHtmlDescription();
		}
		return result;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStocks(Stock [] stocks) {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}

	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public StockInterface findStock(String symbol) {	
		for (int i = 0; i< this.getPortfolioSize(); i++){
			
			if (symbol.equals(this.stocks[i].getSymbol()))
			{
				return this.stocks[i];
			}
		}
		return null;
	}

}