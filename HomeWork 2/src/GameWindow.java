import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class GameWindow extends Frame implements Runnable {
    Image backgroundImage;
    Plane plane1 ;
    Plane plane2 ;
    PlaneEnemy plane3 ;
    Thread thread;
    private int planeEnemyX;
    ArrayList<PlaneEnemy> planeEnemiesList = new ArrayList<PlaneEnemy>();
    Image backbufferImage;
    public GameWindow (){
        this.setVisible(true);
        this.setSize(400, 600);

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
            Image plane1Image = ImageIO.read(new File("resources/plane4.png"));
            Image plane2Image = (ImageIO.read(new File("resources/plane2.png")));
            Image plane3Image = ImageIO.read(new File("resources/plane1.png"));
            plane1 = new Plane(100,500,  plane1Image);
            plane2 = new Plane(200,500,  plane2Image);
            for (int i = 0; i < 5; i++){
                plane3 = new PlaneEnemy(planeEnemyX, 0, plane3Image);
                planeEnemiesList.add(plane3);
                planeEnemyX += 80;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.dy = -5;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 5;
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = -5;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = 5;
                        break;
                    case KeyEvent.VK_SPACE:
                        plane1.shot();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.dy = 0;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.dy = 0;
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.dx = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.dx = 0;
                        break;
                }
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                plane2.shot();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        if(backbufferImage == null){
            backbufferImage =  new BufferedImage(400, 600, 1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
        backbufferGraphics.drawImage(backgroundImage, 0, 0, null);
        plane1.paint(backbufferGraphics);
        plane2.paint(backbufferGraphics);
        for(int i = 0; i < planeEnemiesList.size(); i++){
            PlaneEnemy planeEnemy = planeEnemiesList.get(i);
            planeEnemy.paint(backbufferGraphics);
        }
        g.drawImage(backbufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        while(true){
            try {
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                mousePoint.x -= getLocationOnScreen().x;
                mousePoint.y -= getLocationOnScreen().y;

                if(mousePoint.x - 5 > plane2.x) {
                    plane2.dx = 5;
                } else if(mousePoint.x + 5 < plane2.x) {
                    plane2.dx = -5;
                } else {
                    plane2.dx = 0;
                }

                if(mousePoint.y - 5 > plane2.y) {
                    plane2.dy = 5;
                } else if(mousePoint.y + 5 < plane2.y) {
                    plane2.dy = -5;
                } else {
                    plane2.dy = 0;
                }
                plane1.run();
                plane2.run();
                for(int i = 0; i < planeEnemiesList.size(); i++){
                    PlaneEnemy planeEnemy = planeEnemiesList.get(i);
                    planeEnemy.run();
                }
                repaint();
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
