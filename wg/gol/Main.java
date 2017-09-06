
package wg.gol;

import javax.swing.JFrame;

/**
 * The main class.
 * @author Wesley Garey
 */
public class Main {
  public static void main(String[] args) {
    BasicGolFrame mainFrame = new BasicGolFrame();
    mainFrame.initialize();
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
  }
}
