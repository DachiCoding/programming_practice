/*
 * CSC402 Data Structure I HW2
 * Dachi Xu, ID#1451968, dachi.xu@gmail.com
 */

import static java.lang.System.out;
import java.util.Scanner;
import java.lang.Object;
import java.awt.Color;

public class Point2DApp {

 public static void Main(){
		/*
		 * This function will read the input from a file and print the numbers of integers read, the 
		 * count and sum of the even/odd/all integers.
		 * @param 
		 * @return print out random points and draw a line between the two points having the greatest
		 * distance.
		 * @exception
		 */
	 
	 	 //Print what the program does.
	 	 String msg = "This program will draw N random points in a square\n" +
	 			 	  "and then draw a line bewteen two points that are farthest apart\n";
	 	 out.println(msg);
	 	 
	 	 //Prompt for the number of points, N
	 	 out.print("Enter N: ");
	 	 int numOfPoint;
	 	 Scanner stdin = new Scanner(System.in);
	 	 numOfPoint = stdin.nextInt();
	 	 
	 	 //Create a Point2D array of size N
	 	 Point2D points[] = new Point2D[numOfPoint];
	 	 
	 	 /*
	 	  * Create N random Point2D points,store in the array;
	 	  * Draw the points (in read with Pen with radius size 0.008)
	 	  */
	 	 
	 	 for(int i = 0; i < numOfPoint; i++){
	 		 points[i] = new Point2D(Math.random(),Math.random());
	 		 StdDraw.setPenColor(Color.red);
	 		 StdDraw.setPenRadius(0.008);
	 		 StdDraw.point(points[i].x(),points[i].y());
	 	 }
	 	 
	 	 //Determine two points that have maximum distance apart
	 	 double maxDist=0,curDist;
	 	 double x0=0,y0=0,x1=0,y1=0;
	 	 for(int i=0;i<numOfPoint-1;i++){
	 		for(int j=i+1; j<numOfPoint;j++){
	 			curDist = points[i].distanceTo(points[j]);
	 			if ( maxDist < curDist){
	 				maxDist = curDist;
	 				x0=points[i].x();
	 				y0=points[i].y();
	 				x1=points[j].x();
	 				y1=points[j].y();
	 			}
	 		}
	 	 }
	 	 
	 	 //Draw a line between those two points(in black with Pen radius 0.002)
 		 StdDraw.setPenColor(Color.black);
 		 StdDraw.setPenRadius(0.002);
 		 StdDraw.line(x0, y0, x1, y1);
 		 
 }
 
}
