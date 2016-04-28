import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;
    private Image image;

    public final int WIDTH = 70;
    public final int HEIGHT = 60;

    Bullet bullet;

    public void paint(Graphics g){
        g.drawImage(image,x,y, WIDTH, HEIGHT, null);
        if(bullet != null) {
            bullet.paint(g);
        }
    }
    public void run(){
        x+=dx;
        y+=dy;
        if(bullet != null) {
            bullet.run();
        }
    }

    public void shot() {
        try {
            this.bullet = new Bullet(this.x + WIDTH/2 - Bullet.WIDTH/2, this.y, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Plane(int x, int y, Image image){
        this.image=image;
        this.x = x;
        this.y = y;

    }

}
