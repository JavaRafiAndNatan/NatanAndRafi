
package com.myorg.javacourse;
import java.io.IOException;
//import java.Math;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Stock stockPih = new Stock();
		stockPih.setSymbol ("PIH");
		stockPih.setAsk(13.1);
		stockPih.setBid(12.4);
		stockPih.setDate(11/15/2014);
		
		
		resp.getWriter().println(stock.getHtmlDescription());
		
	}
}