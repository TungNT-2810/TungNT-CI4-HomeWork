package vn.edu.techkids.controllers;


import sun.plugin.dom.css.Rect;
import vn.edu.techkids.Main;
import vn.edu.techkids.models.*;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;
import java.util.*;

/**
 * Created by ZYuTernity on 5/5/2016.
 */
public class PlaneEnemyController extends SingleController {

    Timer timer = new Timer();
    private static final int SPEED = 1;
    private Vector<BulletEnemyController> bulletEnemyControllerVector;
    private Vector<PlaneEnemy> vectorPlaneEnemy;

//    private static int x = 0;

    public Vector<PlaneEnemy> getVectorPlaneEnemy() {
        return vectorPlaneEnemy;
    }

    public void setVectorPlaneEnemy(Vector<PlaneEnemy> vectorPlaneEnemy) {
        this.vectorPlaneEnemy = vectorPlaneEnemy;
    }

    public void addPlaneEnemy(PlaneEnemy planeEnemy){
        vectorPlaneEnemy.add(planeEnemy);
    }

    public PlaneEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        bulletEnemyControllerVector = new Vector<BulletEnemyController>();
        vectorPlaneEnemy = new Vector<PlaneEnemy>();
    }

    public void move(){
        gameVector.dy = SPEED;
    }


    public void shot(){
        BulletEnemy bulletEnemy = new BulletEnemy(gameObject.getX()/2 - BulletEnemy.DEFAUL_WIDTH/2, gameObject.getY(), BulletEnemy.DEFAUL_WIDTH, BulletEnemy.DEFAUL_HEIGHT, true);
        ImageDrawer imageDrawer = new ImageDrawer("resources/bullet.png");
        BulletEnemyController bulletEnemyController = new BulletEnemyController(bulletEnemy, imageDrawer);
        bulletEnemyControllerVector.add(bulletEnemyController);
    }



    private static PlaneEnemyController planeEnemyController1;
    public static PlaneEnemyController getPlaneEnemyController1() {

        if(planeEnemyController1 == null) {
            int x = 10;
            for (int i = 0; i < 5; i++){
                PlaneEnemy planeEnemy = new PlaneEnemy(x, 30, 70, 60, true);
                ImageDrawer planeDrawer = new ImageDrawer("resources/plane1.png");
                planeEnemyController1 = new PlaneEnemyController(planeEnemy, planeDrawer);
                planeEnemyController1.addPlaneEnemy(planeEnemy);
                x += 10;
            }
        }
        return planeEnemyController1;
    }


    @Override
    public void run() {
        super.run();
        for(BulletEnemyController bulletEnemyController : this.bulletEnemyControllerVector) {
            bulletEnemyController.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(BulletEnemyController bulletEnemyController : this.bulletEnemyControllerVector) {
            bulletEnemyController.paint(g);
        }
    }
}
