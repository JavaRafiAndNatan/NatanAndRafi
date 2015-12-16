package com.myorg.javacourse.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;
import com.myorg.javacourse.service.PortfolioManager;
/**
 * Portfolio Servlet including make a new Portfolio and print it
 */
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(portfolio.getHtmlString()+"<br>");
		resp.getWriter().println(portfolio.getHtmlDescription()+"<br>");
		
	}
}