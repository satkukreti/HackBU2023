public class Rasterizer {
    public Pixel[][] printArray;

    public Rasterizer(Pixel[][] printArray) {
        this.printArray = printArray;
    }


    public void rasterTriangle(VecInt2 a, VecInt2 b, VecInt2 c) {
        int leftXBound = Integer.max(0,Integer.min(Integer.min(a.x,b.x),c.x));
        int rightXBound = Integer.min(Integer.max(Integer.max(a.x,b.x),c.x),printArray[0].length);
        int topYBound = Integer.max(Integer.min(Integer.min(a.y,b.y),c.y),0);
        int bottomYBound = Integer.min(Integer.max(Integer.max(a.y,b.y),c.y),printArray.length);
        //System.out.print(leftXBound + " : " + rightXBound + ", ");
        //System.out.print(topYBound + " : " + bottomYBound + ". ");


        for (int i = leftXBound; i < rightXBound; i++) {
            for (int j = topYBound; j < bottomYBound;j++) {
                //need to check that it is within all three sides
                // i, j are the x, y coords of our pixel
                //System.out.print(" p " + ((a.x-b.x) * (j - b.y) - (a.y-b.y) * (i - b.x)));
                if (
                        (a.x-b.x) * ((j+.5) - b.y) - (a.y-b.y) * ((i+.5) - b.x) < 0 &&
                                (b.x-c.x) * ((j+.5) - c.y) - (b.y-c.y) * ((i+.5) - c.x) < 0 &&
                                (c.x-a.x) * ((j+.5) - a.y) - (c.y-a.y) * ((i+.5) - a.x) < 0
                ) {
                    printArray[j][i].shade = "\u2588";
                    //System.out.print("Matched");
                }
            }
        }
    }
}
