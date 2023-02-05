public class Triangle3D {
    public VecDouble3 a, b, c;
    public Triangle3D(VecDouble3 a, VecDouble3 b, VecDouble3 c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Triangle3D() {}

    public VecDouble3 midpoint() {
        return new VecDouble3((a.x+b.x+c.x)/3,(a.y+b.y+c.y)/3, (a.z+b.z+c.z)/3);
    }


}
