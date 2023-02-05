import java.util.ArrayList;

public class Renderer {
    // Rasterizer class will take a list of transformed triangles, then draw to the pixel array, in z-order and preferably with shading

    Pixel[][] printArray;
    ArrayList<Triangle3D> triangle3Ds; //this will hold the array of triangles to render
    Camera camera;
    public Rasterizer rasterizer;
    public Renderer(Camera camera, Pixel[][] printArray, ArrayList<Triangle3D> triangle3Ds) {
        rasterizer = new Rasterizer(printArray);
        this.printArray = printArray;
        this.triangle3Ds = triangle3Ds;
        this.camera = camera;

    }
    public void text(int x, int y, String s) {
        for (int i = x; i < x+s.length(); i++) {
            printArray[y][i].shade = "" + s.charAt(i-x);
        }
    }


    //drawTriangle should take in UN-transformed triangles, transform them using the camera,
    //then finally rasterize them with appropriate color info
    public void draw() {

        for (Triangle3D triangle3D : triangle3Ds) {
            drawTriangle(triangle3D, TerminalTools.Color.BLUE, "0");
        }
    }

    public void drawTriangle(Triangle3D triangle3D, TerminalTools.Color color, String shade) {
        VecInt2 first   = new VecInt2(scaleToScreen(camera.convertPoints(triangle3D.a.x, triangle3D.a.y, triangle3D.a.z)));
        VecInt2 second  = new VecInt2(scaleToScreen(camera.convertPoints(triangle3D.b.x, triangle3D.b.y, triangle3D.b.z)));
        VecInt2 third   = new VecInt2(scaleToScreen(camera.convertPoints(triangle3D.c.x, triangle3D.c.y, triangle3D.c.z)));
        rasterizer.rasterTriangle(first, second, third);

    }

    public int[] scaleToScreen(double[] values) {
        int[] output =  new int[] { (int) (1.0*values[0]*printArray[0].length/camera.width), (int) (1.0*values[1]*printArray.length/camera.height)};
        //System.out.print("S: " + output[0] + ","+output[1]+";");
        return output;
    }
    public static double rad(double deg) {
        return deg/180 * Math.PI;
    }
}

