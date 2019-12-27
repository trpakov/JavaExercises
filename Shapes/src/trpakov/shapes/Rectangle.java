package trpakov.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Shape {
	double a;
	double b;
	
	Rectangle(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double getArea(){
		return a*b;
	}

	@Override
	public double getPerimeter() {
		return 2*a + 2*b;
	}

	@Override
	public void drawMe(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(300, 20, (int)a, (int)b);
		
	}
	
}
