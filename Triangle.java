public class Triangle {
    private Vertex a;
    private Vertex b;
    private Vertex c;

    Triangle(Vertex a, Vertex b, Vertex c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    Triangle() {};

    public Vertex getA() {return a;};
    public Vertex getB() {return b;};
    public Vertex getC() {return c;};

    public void setA(Vertex a) {this.a=a;};
    public void setB(Vertex b) {this.b=b;};
    public void setC(Vertex c) {this.c=c;};

    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}
