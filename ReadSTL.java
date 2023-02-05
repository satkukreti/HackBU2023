import java.util.*;
import java.io.*;

public class ReadSTL {
    public static ArrayList<Triangle3D> read(String filename) throws FileNotFoundException {
        // makes ArrayList of vertices
        ArrayList<Triangle3D> arr = new ArrayList<>();


        Scanner f =  new Scanner(new File(filename));

        String line;
        while (f.hasNextLine()) {
            line = f.nextLine();
            if (line.contains("outer")) {
                Triangle3D t = new Triangle3D();
                String l;

                l = f.nextLine();
                String[] strArr1 = l.split("\\s+");
                t.a = (new VecDouble3(Double.parseDouble(strArr1[2]), Double.parseDouble(strArr1[3]), Double.parseDouble(strArr1[4])));

                l = f.nextLine();
                String[] strArr2 = l.split("\\s+");
                t.b = (new VecDouble3(Double.parseDouble(strArr2[2]), Double.parseDouble(strArr2[3]), Double.parseDouble(strArr2[4])));

                l = f.nextLine();
                String[] strArr3 = l.split("\\s+");
                t.c = (new VecDouble3(Double.parseDouble(strArr3[2]), Double.parseDouble(strArr3[3]), Double.parseDouble(strArr3[4])));

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
