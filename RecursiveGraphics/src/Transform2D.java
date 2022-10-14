/**
 * Name: Isayiah Lim
 * Mrs. Kankelborg
 * Period 1
 * Project 2 Recursive Art Project Part 1: Transform2D
 * Last Updated: 10/14
 * 
 * Class Description: This class is full of methods that transform a 2D shape by rotating, 
 * translating and scaling it. It also draws examples of each scenario. 
 */

public class Transform2D 
{	
	//calls every method uses Standard Draw
	public static void main(String[] args)
	{
		StdDraw.enableDoubleBuffering();
		//window set-up
		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.setXscale(-20, 20);
		StdDraw.setYscale(-20, 20);
		//draws axis'
		StdDraw.line(-20, 0, 20, 0);
		StdDraw.line(0, -20, 0, 20);
		StdDraw.show();
		//points for the polygon
		double[] originalX = {0, 5.5, 9, 3};
		double[] originalY = {0, 7, 4.2, 1};
		
		//original shape
		StdDraw.setPenRadius(0.003);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.polygon(originalX, originalY);
		StdDraw.pause(700);
		StdDraw.show();
		
		//scaled shape
		StdDraw.setPenColor(StdDraw.BLUE);
		double[] scaledX = copy(originalX);
		double[] scaledY = copy(originalY);
		scale(scaledX, scaledY, 2);
		StdDraw.polygon(scaledX, scaledY);
		StdDraw.pause(1000);
		StdDraw.show();
			
		//translated shape
		StdDraw.setPenColor(StdDraw.GREEN);
		double[] translatedX = copy(originalX);
		double[] translatedY = copy(originalY);
		translate(translatedX, translatedY, 4, -6);
		StdDraw.polygon(translatedX, translatedY);
		StdDraw.pause(1000);
		StdDraw.show();
		
		//rotated shape
		StdDraw.setPenColor(StdDraw.RED);
		double[] rotatedX = copy(originalX);
		double[] rotatedY = copy(originalY);
		rotate(rotatedX, rotatedY, 60);
		StdDraw.polygon(rotatedX, rotatedY);
		StdDraw.pause(1000);
		StdDraw.show();
		
		//all three
		StdDraw.setPenColor(StdDraw.ORANGE);
		double[] allX = copy(originalX);
		double[] allY = copy(originalY);
		translate(allX, allY, -3, 4);
		rotate(allX, allY, 60);
		scale(allX, allY, 1.5);
		StdDraw.polygon(allX, allY);
		StdDraw.pause(1000);
		StdDraw.show();
	}
	//copies a given array, returns double array
	public static double[] copy(double[] originalArray)
	{
		//new array that will be returned, sets every value in it to the original
		double[] copied = new double[originalArray.length];
		for(int i = 0; i < originalArray.length; i++)
		{
			copied[i] = originalArray[i];
		}
		return copied;
	}
		
	//increases size of a given shape by alpha
	public static void scale(double[] x, double[] y, double alpha)
	{
		//multiplies everything in x and y by alpha
		for(int i = 0; i < x.length; i++)
		{
			x[i] *= alpha;
			y[i] *= alpha;
		}
	}
	
	//moves x and y by dx and dy, respectively
	public static void translate(double[] x, double[] y, double dx, double dy)
	{
		//adds dx and dy to every value in x and y
		for(int i = 0; i < x.length; i++)
		{
			x[i] += dx;
			y[i] += dy;
		}
	}
	
	//rotates theta degrees around the origin
	public static void rotate(double[] x, double[] y, double theta)
	{
		theta = Math.toRadians(theta);
		//rotates the given degrees using trig
		for(int i = 0; i < x.length; i++)
		{
			x[i] = (x[i] * Math.cos(theta)) - (y[i] * Math.sin(theta));
		}
		for(int i = 0; i < y.length; i++)
		{
			y[i] = (y[i] * Math.cos(theta)) + (x[i] * Math.sin(theta));
		}
	}
}