import java.awt.*;


public class PlaneEnemy extends Plane {

    public PlaneEnemy(int x, int y, Image image) {
        super(x, y, image);
    }

    public void run(){
        y += 5;
    }
}
