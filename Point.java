import java.text.DecimalFormat;

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
	public String toString(int places){
		String p = "###.";
		for(int i = 0; i < places; i++){
			p += "#";
		}
		DecimalFormat df = new DecimalFormat(p);
		return "(" + df.format(x) + "," + df.format(y) + "," + df.format(z) + ")";
	}
}
