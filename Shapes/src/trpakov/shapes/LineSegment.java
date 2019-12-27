package trpakov.shapes;

public class LineSegment {

	Point a;
	Point b;
	
	public LineSegment(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public double getSlope(){
		return (b.getY() - a.getY()) / (b.getX() - a.getX());
	}
	
	@Override
	public String toString() {
		return "Line Segment from: " + a + " to: " + b;
	}
}
