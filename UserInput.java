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
            Window.wpress();
          }
          else if (keyCode == KeyEvent.VK_S) {
            Window.spress();
          }
          else if (keyCode == KeyEvent.VK_A) {
            Window.apress();
          }
          else if (keyCode == KeyEvent.VK_D) {
           Window.dpress();
          }
          else if (keyCode == KeyEvent.VK_Q) {
            Window.qpress();
           }
           else if (keyCode == KeyEvent.VK_R) {
            Window.rpress();
           }
           else if (keyCode == KeyEvent.VK_E) {
            Window.epress();
           }
           else if (keyCode == KeyEvent.VK_F) {
            Window.fpress();
           }
           else if (keyCode == KeyEvent.VK_UP) {
            Window.uppress();
           }
           else if (keyCode == KeyEvent.VK_DOWN) {
            Window.downpress();
           }
           else if (keyCode == KeyEvent.VK_LEFT) {
            Window.leftpress();
           }
           else if (keyCode == KeyEvent.VK_RIGHT) {
            Window.rightpress();
           }
        }
      });

    }

}
