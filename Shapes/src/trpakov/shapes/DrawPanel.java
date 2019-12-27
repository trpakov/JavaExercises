package trpakov.shapes;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	ArrayList<Shape> shapesToDraw = new ArrayList<Shape>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Shape shape : shapesToDraw) {
			shape.drawMe(g);
		}
	}
}
