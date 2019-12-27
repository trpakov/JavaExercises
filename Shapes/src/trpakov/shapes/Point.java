package trpakov.shapes;

public class Point {
	private int x;
	private int y;
	
	Point(int x, int y){
		if(x < 0 || y < 0 ) throw new IllegalArgumentException();
		
		this.setX(x);
		this.setY(y);
	}
	
	public Point() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void translate(int dx, int dy){
		if(x + dx < 0 || y + dy < 0 ) throw new IllegalArgumentException();
		x += dx;
		y += dy;
	}
	
	public double distance(Point p){
		return Math.sqrt(Math.pow((p.x - x),2)+Math.pow((p.y - y), 2));
	}
	
	public double distanceFromOrigin(){
		return distance(new Point());
	}
	
	public void setLocation(int x, int y){
		if(x < 0 || y < 0 ) throw new IllegalArgumentException();
		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point other = (Point)obj;
			return this.x == other.x && this.y == other.y;
			
		} else 
			return false;
	}
}
