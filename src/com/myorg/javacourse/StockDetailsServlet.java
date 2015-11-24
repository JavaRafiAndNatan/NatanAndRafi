
package com.myorg.javacourse;
import java.io.IOException;
import java.util.Date;

//import java.Math;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Date date = new Date("11/15/2014");

		Stock stockPih = new Stock ("PIH",13.1f, 12.4f, date);
		Stock stockAal = new Stock ("AAL",5.78f, 5.5f, date);
		Stock stockCaas = new Stock ("CAAS",32.2f, 31.5f, date);
		
		resp.getWriter().println(stockPih.getHtmlDescription());
		resp.getWriter().println(stockAal.getHtmlDescription());
		resp.getWriter().println(stockCaas.getHtmlDescription());

		
	}
}