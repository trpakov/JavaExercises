package trpakov.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape {
	
	Point c;
	double r;
	
	public Circle(Point c, double r) {
		this.c = c;
		this.r = r;
	}
	
	public Circle() {
		this(new Point(), 1);
	}
	
	boolean isPointInside(Point p){
		
		return p.distance(c) <= r;
	}

	@Override
	public double getArea() {
		return Math.pow(r, 2) * Math.PI;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * r;
	}
	
	@Override
	public String toString() {
		return "Circle with center: " + c + " and radius: " + r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle otherCircle = (Circle)obj;
			return r == otherCircle.r && c == otherCircle.c;
		} else return false;
	}

	@Override
	public void drawMe(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(30, 20, 80, 80);
	}
	
	
}
