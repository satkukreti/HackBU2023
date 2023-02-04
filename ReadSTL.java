import java.util.*;
import java.io.*;

public class ReadSTL {
    public ArrayList<Triangle> main(String filename) {
        // makes ArrayList of vertices
        ArrayList<Triangle> arr = new ArrayList<>();


        Scanner f = new Scanner("");
        try {
            f = new Scanner(new File(filename));
        } catch (Exception e) {
            System.exit(0);
        }
        String line;
        while (f.hasNextLine()) {
            line = f.nextLine();
            if (line.contains("outer")) {
                Triangle t = new Triangle();
                String l;

                l = f.nextLine();
                String[] strArr1 = l.split("\\s+");
                t.setA(new Vertex(Double.parseDouble(strArr1[2]), Double.parseDouble(strArr1[3]), Double.parseDouble(strArr1[4])));

                l = f.nextLine();
                String[] strArr2 = l.split("\\s+");
                t.setB(new Vertex(Double.parseDouble(strArr2[2]), Double.parseDouble(strArr2[3]), Double.parseDouble(strArr2[4])));

                l = f.nextLine();
                String[] strArr3 = l.split("\\s+");
                t.setC(new Vertex(Double.parseDouble(strArr3[2]), Double.parseDouble(strArr3[3]), Double.parseDouble(strArr3[4])));

                t.setMidpoint();

                arr.add(t);
            }
        }

        f.close();
        

        // for (Triangle t: arr) {
        //     System.out.println(t);
        // }

        return arr;
    } 
}
