package vn.edu.techkids.models;

public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 33;

    public Bullet(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }
}
