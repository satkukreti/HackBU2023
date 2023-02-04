public class Point {
	public final double x;
	public final double y;
	public final double z;
	Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getAverage() {
		return (x+y+z)/3;
	}
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	} 
}
