package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JavaNatanServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//MathManager mathManager = new MathManager();
		//String resultStr = mathManager.getResults();

		int angle = 0,base = 0,exp = 0, radius = 50,hypotenuse=50,angleB=30, powRes;
		double  radiusRes,oppositeRes;
	
		{
		radiusRes= Math.pow(radius,2)*Math.PI;
		resp.getWriter().println("Area of circle with radius ​" +radius+ " is: "+radiusRes+" square­cm");
		}
		
		{
		oppositeRes=Math.sin(angleB)*hypotenuse;
		resp.getWriter().println("Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: ​"+oppositeRes+" cm");
		}
		
		{
		powRes=(int) Math.pow(20,13);
		resp.getWriter().println("Power of 20 with exp of 13 is "+powRes );
		}
		
		String line1 = new String("calculation 1: Area of circle with radius"+radius+ " is "+radiusRes);
	    String line2 = new String("calculation 2: Length of opposite where angle B is"+angle);
		String line3 = new String("calculation 3: Power of "+base+" with exp of" +exp+" is ...");
		resp.getWriter().println(line1);
		
		resp.setContentType("text/plain");
		//String ​resultStr​= ​line1 + "<br>" + line2 + "<br>" +line3;
		resp.getWriter().println("Hello, virusworld");
	}
}
