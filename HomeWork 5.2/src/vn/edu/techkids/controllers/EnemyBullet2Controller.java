package vn.edu.techkids.controllers;


import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBullet2Controller extends SingleController implements Colliable {

    public EnemyBullet2Controller(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        this.gameVector.dx = -2;
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlaneController) {
            Plane plane = (Plane) c.getGameObject();
            plane.decreaseHP(3);
            if (plane.getHp() <= 0) {
                plane.setAlive(false);
            }
        }
    }
}
