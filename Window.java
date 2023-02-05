public class Window {
    Pixel[][] printArray;

    public Window(int width, int height) {
        printArray = new Pixel[height][];
        for (int i = 0; i < printArray.length; i++) {
            printArray[i] = new Pixel[width];
            for (int j = 0; j < printArray[0].length; j++) {
                printArray[i][j] = new Pixel(false, ""," ");
            }
        }
    }
    public Pixel[][] getPrintArray() {
        return printArray;
    }
    public void draw() {
        TerminalTools.moveUp(printArray.length);
        for (int i = 0; i < printArray.length; i++) {
            for (int j = 0; j < printArray[0].length; j++) {
                System.out.print(printArray[i][j].shade);
            }
            // TerminalTools.moveDown(1);
            // TerminalTools.moveToColumn(0);
            System.out.println();
        }

    }

}
