import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;

public class UserInput {

    public static void main(String args[]){
        JFrame myJFrame = new JFrame();

        myJFrame.setVisible(true);
    

    myJFrame.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          int keyCode = e.getKeyCode();
          if (keyCode == KeyEvent.VK_W) {
            //System.out.println("Up Arrrow-Key is pressed!");
            Window.up();
          }
          else if (keyCode == KeyEvent.VK_S) {
            //System.out.println("Down Arrrow-Key is pressed!");
            Window.down();
          }
          else if (keyCode == KeyEvent.VK_A) {
            //System.out.println("Left Arrrow-Key is pressed!");
            Window.left();
          }
          else if (keyCode == KeyEvent.VK_D) {
           //System.out.println("Right Arrrow-Key is pressed!");
           Window.right();
          }
        }
      });

    }

}
