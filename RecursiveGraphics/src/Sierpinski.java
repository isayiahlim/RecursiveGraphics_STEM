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
		sierpinski(1);
	}
	//draws the outline of a triangle, then n number of sierpinski's triangles inside
	public static void sierpinski(int n)
	{
		StdDraw.setPenRadius(0.001);
		double[] x = {0,1,0.5};
		double[] y = {0,0,1};
		StdDraw.polygon(x, y);
		sierpinski(n, 0.5, 0, 0.5);
	}
	
	//private recursive sierpinski method, drawing triangles in 3 quadrants
	//these triangles are each half the size of the last
	private static void sierpinski(int n, double x, double y, double length)
	{
		if(n == 0)
			return;
		filledTriangle(x,y,length);
		sierpinski(n-1, x/n, y, length/n);
		sierpinski(n-1, x*2, y, length/n);
		sierpinski(n-1, x, y + 2 * height(length), length/n);
	}
	
	//calculates the height of an equilateral triangle
	private static double height(double length)
	{
		return length * Math.sqrt(3)/2;
	}
	
	//draws a filled equilateral triangle with a vertex at at x,y
	private static void filledTriangle(double x, double y, double length)
	{
		double[] xArr = {x, x - (length/2), x+(length/2)};
		double[] yArr = {y, y + height(y), y+ height(y)};
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledPolygon(xArr, yArr);
	}
	
	
}
