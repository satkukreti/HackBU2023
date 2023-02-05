
public class TerminalTools {
    public enum Color {
        BLACK,
        RED,
        GREEN,
        YELLOW,
        BLUE,
        MAGENTA,
        CYAN,
        WHITE

    }
    public static final String ESCAPE = "\u001b";
    public static void moveUp(int spaces) {
        System.out.print(ESCAPE);
        System.out.print("[");
        System.out.print(spaces);
        System.out.print("A");
    }
    public static void moveDown(int spaces) {
        System.out.print(ESCAPE);
        System.out.print("[");
        System.out.print(spaces);
        System.out.print("B");
    }
    public static void moveLeft(int spaces) {
        System.out.print(ESCAPE);
        System.out.print("[");
        System.out.print(spaces);
        System.out.print("C");
    }
    public static void moveRight(int spaces) {
        System.out.print(ESCAPE);
        System.out.print("[");
        System.out.print(spaces);
        System.out.print("D");
    }
    public static void moveToColumn(int column) {
        System.out.print(ESCAPE);
        System.out.print("[");
        System.out.print(column);
        System.out.print("G");
    }
    public static void hideCursor() {
        System.out.print(ESCAPE);
        System.out.print("[?25l");
    }
    public static void reset() {
        System.out.print(ESCAPE);
        System.out.print("[?25h");
        System.out.print(ESCAPE);
        System.out.print("[0m");
    }
    public static void setColor(Color c) {
        System.out.print(ESCAPE);
        System.out.print("[");
        switch (c) {
            case BLACK: System.out.print("30");
                break;
            case RED: System.out.print("31");
                break;
            case GREEN: System.out.print("32");
                break;
            case YELLOW: System.out.print("33");
                break;
            case BLUE: System.out.print("34");
                break;
            case MAGENTA: System.out.print("35");
                break;
            case CYAN: System.out.print("36");
                break;
            case WHITE: System.out.print("37");
                break;
        }
        System.out.print("m");
    }

}
