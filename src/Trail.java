import java.awt.*;

public class Trail extends Point {
    int lifetime;
    boolean toggle = false;

    public Trail(int i){
        lifetime = i;
    }

    public void renew(Point p){
        setLocation(p);
        toggle = true;
        //lifetime = 100;
    }

    public void paint(Graphics g){
        if(toggle == true){
            g.setColor(new Color(153,153,153,180));
            g.fillOval(x, y, 10, 10);
            // if(lifetime > 0){
            //     g.fillOval(x, y, 10, 10);
            //     lifetime -=1;
            //  }
            //  else{
            //      //setLocation(getLocation());
            //      toggle = false;
            //  }
        }
        
        //g.drawOval(x,y, 10, 10);
        
    }
}
