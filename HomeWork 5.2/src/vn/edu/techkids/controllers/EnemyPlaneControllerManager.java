package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int count = 0;
    private int temp = 0;

    private EnemyPlaneControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        temp++;

        if(GameConfig.getInst().durationInSeconds(count) > 4 && temp % 2 == 0) {
            count = 0;
            for (int x = 40; x < GameConfig.getInst().getScreenWidth() - 40; x += 100) {
                EnemyPlane enemyPlane= new EnemyPlane(x, 0, 32, 32);
                ImageDrawer imageDrawer =
                        new ImageDrawer("resources/plane1.png");
                EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                        enemyPlane,
                        imageDrawer
                );
                this.singleControllerVector.add(enemyPlaneController);
            }
        }

        if(GameConfig.getInst().durationInSeconds(count) > 4 && temp % 2 == 1) {
            count = 0;
            for (int x = 40; x < GameConfig.getInst().getScreenWidth() - 40; x += 100) {
                EnemyPlane enemyPlane= new EnemyPlane(x, 0, 32, 32);
                ImageDrawer imageDrawer =
                        new ImageDrawer("resources/enemy_plane_white_1.png");
                EnemyPlane2Controller enemyPlane2Controller = new EnemyPlane2Controller(
                        enemyPlane,
                        imageDrawer
                );
                this.singleControllerVector.add(enemyPlane2Controller);
            }
        }
    }

    private static EnemyPlaneControllerManager inst;
    public static EnemyPlaneControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager();
        }

        return inst;
    }
}
