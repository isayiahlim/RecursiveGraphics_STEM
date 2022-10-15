/**
 * Name: Isayiah Lim 
 * Mrs. Kankelborg
 * Period 1
 * Project 2 Recursive Art Project Part 2: Sierpinski 
 * Last Updated: 10/14/2022
 * 
 * Class Description: This draws a Sierpinski triangle according to n. 1 draws 1, 2 draws 4,
 * 3 draws 13 triangles (3^n-1) + previous
 */

public class Sierpinski 
{
	public static void main(String[] args)
	{
		sierpinski(6);
	}
	//draws the outline of a triangle, then n number of sierpinski's triangles inside
	public static void sierpinski(int n)
	{
		StdDraw.setPenRadius(0.001);
		//outline triangle
		double[] x = {0,1,0.5};
		double[] y = {0,0,height(1)};
		StdDraw.polygon(x, y);
		//calls sierpinski
		sierpinski(n, 0.5, 0, 0.5);
	}
	
	//private recursive sierpinski method, drawing triangles in 3 quadrants
	//these triangles are each half the size of the last
	private static void sierpinski(int n, double x, double y, double length)
	{
		if(n == 0)
			return;
		filledTriangle(x,y,length);
		//right triangle
		sierpinski(n-1, x + length/2, y, length/2);
		//left triangle
		sierpinski(n-1, x - length/2, y, length/2);
		//top triangle
		sierpinski(n-1, x, y + height(length), length/2);
	}
	
	//calculates the height of an equilateral triangle
	private static double height(double length)
	{
		return length * Math.sqrt(3)/2;
	}
	
	//draws a filled equilateral triangle with a vertex at at x,y
	private static void filledTriangle(double x, double y, double length)
	{
		double[] xArr = new double[3];
		double[] yArr = new double[3];
		//three points on the triangle
		xArr[0] = x; 
		yArr[0] = y;       
		xArr[1] = x + length/2; 
		yArr[1] = y + height(length); 
        xArr[2] = x - length/2; 
        yArr[2] = y + height(length); 
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledPolygon(xArr, yArr);
	}
	
	
}
