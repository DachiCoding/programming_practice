//CSC402 Data Structure I HW1 GreatCircle.java
//Dachi Xu , ID#1451968, dachi.xu@gmail.com

import java.util.Scanner;
import java.text.*;

public class GreatCircle {
	public static double distance(double x0,double y0,double x1,double y1){
		/**
		 * Calculates the great circle distance in middle between two
		 * points on earth,given the latitude and longitude of 
		 * each point in degrees.
		 * 
		 * @param x0 latitude of the first point
		 * @param y0 longitude of the first point
		 * @param x1 latitude of the second point
		 * @param y1 longitude of the second point
		 * @return distance in miles along a great circle between the two points.
		 * @exception NA
		 */
		double distance;
		double r;
		r=3950.02;
		x0 = Math.toRadians(x0);
		y0 = Math.toRadians(y0);
		x1 = Math.toRadians(x1);
		y1 = Math.toRadians(y1);

		distance = r * Math.acos(Math.sin(x0)*Math.sin(x1)+Math.cos(x0)*Math.cos(x1)*Math.cos(y0-y1));
		return distance;
	}
	
	public static void main(String[] args){
		System.out.println("Enter latitude and longitude of two points:");
		Scanner in = new Scanner(System.in);
		double x0,y0,x1,y1,d;
		x0=in.nextDouble();
		y0=in.nextDouble();
		x1=in.nextDouble();
		y1=in.nextDouble();
		d=GreatCircle.distance(x0, y0, x1, y1) ;
		System.out.println("");
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.print("Distance is "+df.format(d)+" miles.");
	}
}
