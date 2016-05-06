package vn.edu.techkids.models;

/**
 * Created by ZYuTernity on 5/5/2016.
 */
public class BulletEnemy extends GameObject {

    public static final int DEFAUL_WIDTH = 13;
    public static final int DEFAUL_HEIGHT = 33;

    public BulletEnemy(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }
}
