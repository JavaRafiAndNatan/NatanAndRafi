package com.myorg.javacourse.service;
import java.util.Date;

import org.algo.dto.PortfolioTotalStatus;
import org.algo.exception.PortfolioException;
import org.algo.model.PortfolioInterface;
import org.algo.service.PortfolioManagerInterface;

import com.google.appengine.api.datastore.DatastoreService;
import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

public class PortfolioManager implements PortfolioManagerInterface {
	/**
	 * add data to the Stock
	 */
	Date date = new Date("12/15/2014");
	private DatastoreService datastoreService;
	
	Stock stockPih = new Stock ("PIH",10.0f, 8.5f, date);
	Stock stockAal = new Stock ("AAL",30.0f, 25.5f, date);
	Stock stockCaas = new Stock ("CAAS",20.0f, 15.5f, date);

	/*public Portfolio getPortfolio (){
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.setBalance(10000);
		myPortfolio.addStock(stockPih, "PIH");
		myPortfolio.addStock(stockAal, "AAL");
		myPortfolio.addStock(stockCaas, "CAAS");
		myPortfolio.buyStock(stockPih, 20);
		myPortfolio.buyStock(stockAal,30);		
		myPortfolio.buyStock(stockCaas,40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		return myPortfolio;	
		
	}*/

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PortfolioInterface getPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBalance(float value) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PortfolioTotalStatus[] getPortfolioTotalStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStock(String symbol) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyStock(String symbol, int quantity) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellStock(String symbol, int quantity) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStock(String symbol) throws PortfolioException {
		// TODO Auto-generated method stub
		
	}
}


