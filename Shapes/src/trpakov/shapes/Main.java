package trpakov.shapes;
import static java.lang.System.out;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		Triangle tr1 = new Triangle(12, 14, 20);
		Triangle tr2 = new Triangle(6, 15, 12);
		Rectangle re1 = new Rectangle(20, 15);
		Rectangle re2 = new Rectangle(300, 80);
		Circle c = new Circle(new Point(2,3), 5);
		
		Shape[] shapes = {tr1, tr2, re1, re2, c};
		
		for (Shape shape : shapes) {
			out.println(shape.getArea());
		}
		out.println();
		
		Point myPoint1 = new Point(7, 2);
		Point myPoint2 = new Point(4, 3);
		out.println("p1: " + myPoint1);
		out.println("p2: " + myPoint2);
		out.println("distance from p1 to origin: " + myPoint1.distanceFromOrigin());
		out.println("distance from p1 to p2: " + myPoint1.distance(myPoint2));
		
		JFrame myFrame = new JFrame("Shapes");
		DrawPanel mPanel = new DrawPanel();
		mPanel.shapesToDraw.add(c);
		mPanel.shapesToDraw.add(tr1);
		mPanel.shapesToDraw.add(re2);
		//mPanel.setSize(500, 500);
		myFrame.setSize(700, 200);
		myFrame.add(mPanel);

		myFrame.setVisible(true);
		


	}

}
