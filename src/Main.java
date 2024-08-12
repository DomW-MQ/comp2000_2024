import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  public static void main(String[] args) throws Exception {
    Main window = new Main();
    window.run();
  }

  class Canvas extends JPanel {
    Grid grid = new Grid();
    Point prevp;
    Trail[] trail = new Trail[100];
    boolean moving = false;

    public Canvas() {
      setPreferredSize(new Dimension(720, 720));
      for(int i = 0; i<100 ; i++){
        trail[i] = new Trail(i);

      }
    }
    @Override
    public void paint(Graphics g) {
      moving = false;
      Point p = getMousePosition();
      grid.paint(g, getMousePosition());
      if (p == null) {
        if (prevp != null) {
          System.out.println("Pointer Back Out");
          prevp = null;
        }
      } else {
        if (prevp == null) {
          System.out.println("Pointer Back In");
          System.out.println(p);
          prevp = p;
          moving = true;
        } else if (!prevp.equals(p)) {
          System.out.println(p);
          prevp = p;
          moving = true;
        }
      }
      boolean trailbool = true;
      for(int i = 0; i<100 ; i++){
        trail[i].paint(g);
        if(trailbool && (trail[i].toggle == false)&& moving){
          trail[i].renew(p);
          trailbool = false;
        }
      }
    }
  }

  private Main() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Canvas canvas = new Canvas();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
  }

  public void run() {
    while (true) {
      repaint();
    }
  }
}
