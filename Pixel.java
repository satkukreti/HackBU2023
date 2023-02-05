public class Pixel {
    public boolean notBackground;
    public String color;
    public String shade;
    Pixel(boolean notBackground, String color, String shade) {
        this.notBackground = notBackground;
        this.color = color;
        this.shade = shade;
    }
    public void updateColor(String color) {
        this.color = color;
    }
    public void updateShade(String shade) {
        this.shade = shade;
    }
    public void updateNotBackground(boolean notBackground) {
        this.notBackground = notBackground;
    }

}