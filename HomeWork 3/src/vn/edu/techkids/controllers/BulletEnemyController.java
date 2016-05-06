package vn.edu.techkids.controllers;


import vn.edu.techkids.models.BulletEnemy;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by ZYuTernity on 5/5/2016.
 */
public class BulletEnemyController extends SingleController {

    public static final int SPEED = 15;

    public BulletEnemyController(BulletEnemy gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = SPEED;
    }
}
