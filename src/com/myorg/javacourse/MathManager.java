package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;
public class MathManager{
static int radius, base, exp, hypotenuse, angleB;

public  MathManager (int radiusVal,int angleBVal, int hypotenuseVal, int baseVal, int expVal) {
		radius = radiusVal;
		base = baseVal;
		exp =expVal;
	    hypotenuse =hypotenuseVal;
		angleB =angleBVal;
}
	
		
		private static double calcCircleArea(){
			return Math.pow(radius,2)*Math.PI;
		}
	
		private static double lengthOfOpposite(){
			return Math.sinh(angleB)*hypotenuse;
			
		}
		private static double calcPower(){
		return (int) Math.pow(base,exp);
		}
		
		public static String getResults(){
		String line1 = new String("calculation 1: Area of circle with radius"+radius+ " is: "+MathManager.calcCircleArea());
	    String line2 = new String("calculation 2: Length of opposite where angle B is"+MathManager.lengthOfOpposite());
		String line3 = new String("calculation 3: Power of "+base+" with exp of" +exp+" is: "+MathManager.calcPower());
		
		String resultStr = line1 + "<br><br>" + line2 + "<br><br>" + line3;
		return resultStr;
		
		}

	}

