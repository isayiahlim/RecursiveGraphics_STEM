/**
 * <pre>
 * Name: Isayiah Lim
 * Mrs. Kankelborg
 * Period
 * Project 2 Recursive Art Project Part 3: Art
 * Revision History: 10/14 (Inital Commit)
 *
 * Class Description: This will draw a castle with increasing complexity (more bricks) and more towers 
 * using recursion and standard draw. 2(+) Required elements:
 * 
 * 1. Uses different parameters than Sierpinski (b) On top of n,x,y,length, there are also color 
 * variables to darken further back towers and in bricks, there are x2 and y2 variables that 
 * provide a range in which bricks may appear and a boolean so that the bricks alternate what
 * direction they face.
 * 
 * 2. Use different StdDraw methods than Sierpinski (c) Besides polygons and the standard setup
 * methods, I also use rectangles, squares, and circles.
 * 
 * 3. Multiple recursive methods (f) I have both a brick and a tower method. The brick method
 * draws n bricks in random spots at a random size, and the tower method draws an increasing 
 * number of towers. 
 * 
 * 4. Use recursive level for secondary purpose (i) Recursive level also dictates the color of the
 * tower and the bricks drawn on that tower are dictated by the color of their tower.
 *  
 * </pre>
 */

public class Art
{
   /**
	* All other functions other than draw must be private.
	* You must have at least 2 other methods besides draw.
	* You may not alter the header of this method.
	*/
	public static void draw(int n) 
	{
		//sky
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledSquare(0.5, 0.5, 0.5);
		//draws background towers (int n, double x, double y, double height, int r, int g, int b)
		towers(n, 0.913, 0.4, 0.55, 110, 110, 110);
		//draws the ground
		StdDraw.setPenColor(165,42,42);
		StdDraw.filledRectangle(0.5,0.065,0.5,0.065);
		//base wall
		StdDraw.setPenColor(138,138,138);
		StdDraw.filledRectangle(0.5, 0.25, 0.5, 0.15);
		//top rectangles
		StdDraw.filledRectangle(0.022, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(0.111, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(0.200, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(0.288, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(0.378, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(1-0.022, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(1-0.111, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(1-0.200, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(1-0.288, 0.425, 0.022, 0.025);
		StdDraw.filledRectangle(1-0.378, 0.425, 0.022, 0.025);
		StdDraw.setPenColor(160,160,160);
		StdDraw.filledRectangle(0.5, 0.245, 0.5, 0.145);
		//bricks for the wall (int n, double x1, double x2, double y1, double y2, boolean alt, 
		//double size, int r, int g, int b)
		bricks(n*5,0,1,0.1,0.4,true,((Math.random()*5) + 2)/100.0,128,128,128);
		//draws the main castle & top rectangles
		StdDraw.setPenColor(138,138,138);
		StdDraw.filledRectangle(0.5, 0.4, 0.2, 0.3);
		StdDraw.filledRectangle(0.322, 0.725, 0.022, 0.025);
		StdDraw.filledRectangle(0.411, 0.725, 0.022, 0.025);
		StdDraw.filledRectangle(0.500, 0.725, 0.022, 0.025);
		StdDraw.filledRectangle(0.588, 0.725, 0.022, 0.025);
		StdDraw.filledRectangle(0.678, 0.725, 0.022, 0.025);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.395, 0.19, 0.295);
		//draws main castle bricks 
		bricks(n*3, 0.3, 0.7, 0.1, 0.7, true, ((Math.random()*7) + 3)/100.0, 128,128,128);
		//conditional draws
		if(n >= 4)
			drawBanner();
		//door
		StdDraw.setPenColor(101,67,33);
		StdDraw.filledRectangle(0.5, 0.155, 0.05, 0.055);
		StdDraw.setPenColor(133,88,43);
		StdDraw.filledRectangle(0.5, 0.15, 0.04, 0.05);
		StdDraw.setPenColor(101,67,33);
		StdDraw.line(0.47,0.1,0.47,0.2);
		StdDraw.line(0.485,0.1,0.485,0.2);
		StdDraw.line(0.515,0.1,0.515,0.2);
		StdDraw.line(0.530,0.1,0.53,0.2);
		
	}
	//draws bricks between x and y, alternating between left and right, with a random size
	private static void bricks(int n, double x1, double x2, double y1, double y2, 
			boolean alt, double size, int r, int g, int b)
	{
		StdDraw.setPenColor(r,g,b);
		StdDraw.setPenRadius(0.005);
		if(n == 0)
			return;
		//alternates between a left brick and a right brick w/ random x, y, and size
		double tempx = (Math.random()*(x2-x1-0.07) + x1);
		double tempy = (Math.random()*(y2-y1-0.07) + y1);
		if(alt)
		{
			StdDraw.line(tempx, tempy, tempx+size, tempy);
			StdDraw.line(tempx, tempy, tempx, tempy+0.6*size);
			bricks(n-1, x1, x2, y1, y2,	false, ((Math.random()*5) + 2)/100.0, r, g, b);
		}
		else 
		{
			StdDraw.line(tempx, tempy, tempx+size, tempy);
			StdDraw.line(tempx+size, tempy, tempx+size, tempy+0.6*size);
			bricks(n-1, x1, x2, y1, y2,	true, ((Math.random()*5) + 2)/100.0, r, g, b);
		}
	}
	
	//draws towers that go further backwards & inwards. The further back, the closer together
	private static void towers(int n, double x, double y, double height, int r, int g, int b)
	{
		if(n == 0)
			return;
		//darkens each tower
		int colorMult = 15;
		if(r-35 <= 0)
			colorMult = 0;
		//calls itself 
		towers(n-1, x-(0.012*n), y, height*0.95, r-colorMult, g-colorMult, b-colorMult);
		//draws one on the left and one tower on the right
		drawTower(x,y,height,r,g,b);
		drawTower(1-x,y,height,r,g,b);
	}
	
	//draws a tower with given parameters
	private static void drawTower(double x, double y, double height, int r, int g, int b)
	{
		double width = 0.15*height;
		//tower outline
		StdDraw.setPenColor(r-20,g-20,b-20);
		StdDraw.filledRectangle(x, y, 0.16*height, 1.01*height);
		//top squares
		StdDraw.filledRectangle(x-(0.1*height), y+1.04*height, 0.06*height, 0.06*height);
		StdDraw.filledRectangle(x+(0.1*height), y+1.04*height, 0.06*height, 0.06*height);
		//tower
		StdDraw.setPenColor(r,g,b);
		StdDraw.filledRectangle(x, y, width, height);
		//bricks
		bricks(10,x-width,x+width,y-height*0.6,y+height,true,((Math.random()*5) + 2)/100.0, 
				r-15,g-15,b-15);
		//window
		StdDraw.setPenColor(r-25,g-25,b-25);
		StdDraw.filledCircle(x, y+height*0.67, 0.07*height);
		StdDraw.filledSquare(x, y+height*0.6, 0.07*height);
		StdDraw.setPenColor(r-20,g-20,b-20);
		StdDraw.filledCircle(x, y+height*0.67, 0.06*height);
		StdDraw.filledSquare(x, y+height*0.6, 0.06*height);
	}
	//draws a banner
	private static void drawBanner()
	{
		StdDraw.setPenColor(230,210,100);
		StdDraw.filledRectangle(0.5,0.62,0.15,0.07);
		StdDraw.setPenColor(240,230,100);
		StdDraw.filledRectangle(0.5,0.62,0.14,0.06);
		StdDraw.setPenColor(255,200,0);
		StdDraw.filledCircle(0.5, 0.62, 0.05);
		StdDraw.setPenColor(255,215,0);
		StdDraw.filledCircle(0.5, 0.62, 0.04);
		StdDraw.setPenColor(255,230,0);
		StdDraw.filledCircle(0.5, 0.62, 0.03);
		StdDraw.setPenColor(255,245,0);
		StdDraw.filledCircle(0.5, 0.62, 0.02);
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(214,118,63);
		StdDraw.line(0.4, 0.66, 0.4, 0.69);
		StdDraw.line(0.6, 0.66, 0.6, 0.69);
	}
}
