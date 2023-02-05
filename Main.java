import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        // System.out.println("Start");
        // TerminalTools.moveUp(20);
        // System.out.println("Moved Up");
        // System.exit(0);
        TerminalTools.hideCursor();


        ArrayList<Triangle3D> triangle3Ds = ReadSTL.read("C:\\Users\\animq\\IdeaProjects\\HackBU2023\\sample_human.stl");

        //for (Triangle t : renderer.triangles) System.out.println(t);
        //int[] terminalSize = getTerminalSize();
        Window window = new Window(100,30);

        Renderer renderer = new Renderer(new Camera(), window.getPrintArray(), triangle3Ds);
        renderer.printArray = window.getPrintArray();
        renderer.camera = new Camera();
        renderer.camera.width = renderer.printArray[0].length;
        renderer.camera.height = renderer.printArray.length;

        double maxX = 0;
        for (Triangle3D triangle: triangle3Ds
             ) {
            maxX = Math.max(Math.max(Math.max(triangle.a.x,triangle.b.x),triangle.c.x),maxX);
        }
        double minX = 0;
        for (Triangle3D triangle: triangle3Ds
             ) {
            minX = Math.min(Math.min(Math.min(triangle.a.x,triangle.b.x),triangle.c.x),minX);
        }

        double maxY = 0;
        for (Triangle3D triangle: triangle3Ds
             ) {
            maxY = Math.max(Math.max(Math.max(triangle.a.y,triangle.b.y),triangle.c.y),maxY);
        }
        double minY = 0;
        for (Triangle3D triangle: triangle3Ds
             ) {
            minY = Math.min(Math.min(Math.min(triangle.a.y,triangle.b.y),triangle.c.y),minY);
        }

        //System.out.println(maxX + ", " + maxY);



        //double[] b = renderer.camera.convertPoints(0,10,0);
        //System.out.println("B: " + b[0] + ", " + b[1]);
        //System.exit(0);

        while(true) {
            TerminalTools.hideCursor();
            //renderer.rasterizer.rasterTriangle(new VecInt2(5,-10), new VecInt2(10,10),new VecInt2(5,10));
            //renderer.rasterizer.rasterTriangle(new VecInt2(10,10), new VecInt2(30,10),new VecInt2(15,25));

            // renderer.draw();

            /*
            for (Triangle3D t : triangle3Ds) {
                renderer.rasterizer.rasterTriangle(
                        new VecInt2((int)(t.a.y / (maxX-minX) /2 * renderer.printArray[0].length),(int)(t.a.z / (maxY-minY) * renderer.printArray.length - 10)),
                        new VecInt2((int)(t.b.y / (maxX-minX) /2 * renderer.printArray[0].length),(int)(t.b.z / (maxY-minY) * renderer.printArray.length - 10)),
                        new VecInt2((int)(t.c.y / (maxX-minX) /2 * renderer.printArray[0].length),(int)(t.c.z / (maxY-minY) * renderer.printArray.length - 10))
                );
            }
            */
            final int offsetX = 10, offsetY = 10;

            renderer.rasterizer.rasterTriangle(new VecInt2( 5+offsetX,0+offsetY), new VecInt2(5+offsetX,5+offsetY),new VecInt2(0+offsetX,5+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(5+offsetX,0+offsetY),new VecInt2(10+offsetX,5+offsetY),new VecInt2(5+offsetX,5+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(15+offsetX,0+offsetY), new VecInt2(15+offsetX,5+offsetY),new VecInt2(10+offsetX,5+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(15+offsetX,0+offsetY), new VecInt2(20+offsetX,5+offsetY),new VecInt2(15+offsetX,5+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(0+offsetX,5+offsetY), new VecInt2(20+offsetX,5+offsetY),new VecInt2(20+offsetX,10+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(0+offsetX,5+offsetY), new VecInt2(20+offsetX,10+offsetY),new VecInt2(0+offsetX,10+offsetY));


            renderer.rasterizer.rasterTriangle(new VecInt2(0+offsetX,10+offsetY), new VecInt2(10+offsetX,10+offsetY), new VecInt2(10+offsetX,20+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(20+offsetX,10+offsetY), new VecInt2(10+offsetX,20+offsetY), new VecInt2(10+offsetX,10+offsetY));

            renderer.rasterizer.rasterTriangle(new VecInt2(0,10),  new VecInt2(5,15), new VecInt2(10,20));



            renderer.text(10 , 29, "Happy Valentines!!!");


            TerminalTools.setColor(TerminalTools.Color.MAGENTA);
            window.draw();
            //window.wait(500);
            TerminalTools.setColor(TerminalTools.Color.RED);
            window.draw();


            //renderer.camera.yaw+=.1;
            //renderer.camera.x+=10;
            //renderer.camera.pitch+=.3;
            //renderer.camera.x--;

            //System.out.print(renderer.camera.yaw);
            //renderer.drawTriangle(new Triangle3D(new VecDouble3(0,0,10),new VecDouble3(20,10,10),new VecDouble3(0,10,10)), TerminalTools.Color.BLUE, "0");
            //TerminalTools.reset();


            TerminalTools.setColor(TerminalTools.Color.WHITE);
        }
    }
    private static int[] getTerminalSize() throws IOException {
        System.out.println("Please press ENTER");
        System.out.println("\033[999;999H\033[6n");
        StringBuilder sb = new StringBuilder();
        while (System.in.available() != -1) {
            char ch = (char) System.in.read();
            System.out.println(ch);
            if (ch == 'R')
                break;
            if (Character.isDigit(ch) || ch == ';')
                sb.append(ch);
        }
        String[] rowColumn = sb.toString().split(";");
        int[] result = new int[2];
        result[0] = Integer.parseInt(rowColumn[0]) - 2;
        result[1] = Integer.parseInt(rowColumn[1]);
        return result;
    }
}