package trpakov.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle implements Shape {

	double a, b, c;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public double getArea() {
		double halfP = (a+b+c)/2.0;
		return Math.sqrt(halfP*(halfP-a)*(halfP-b)*(halfP-c));
	}

	@Override
	public double getPerimeter() {
		return a + b + c;
	}

	@Override
	public void drawMe(Graphics g) {
		g.setColor(Color.RED);
		g.fillPolygon(new int[]{200, 150, 250}, new int[]{20, 100, 100}, 3);
		
	}

}
