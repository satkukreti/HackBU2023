public class VecDouble3 {
    public double x, y, z;
    public VecDouble3(double x, double y, double z) {
        this.x = x;
        this.y=y;
        this.z=z;
    }
    public VecDouble3(double[] values) {
        this.x=values[0];
        this.y=values[1];
        this.z=values[2];
    }
}
