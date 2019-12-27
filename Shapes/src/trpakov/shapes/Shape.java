package trpakov.shapes;

import java.awt.Graphics;

// 3 programs - employee, point, shape?

public interface Shape {

	double getArea();
	double getPerimeter();
	void drawMe(Graphics g);
}
