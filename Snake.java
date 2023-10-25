import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;

    public Snake(int speed) {
        this.speed = speed;
        GreenfootImage snakeImage = new GreenfootImage("snake.png");
        setImage(snakeImage);
    }

    public void act() {
        moveTowardsMouse();
        checkCollision();
    }

    private void moveTowardsMouse() {
        Mouse mouse = (Mouse) getWorld().getObjects(Mouse.class).get(0);
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();
        int rotation = (int) Math.toDegrees(Math.atan2(mouseY - getY(), mouseX - getX()));
        setRotation(rotation);
        move(speed);
    }

    private void checkCollision() {
        Actor mouse = getOneIntersectingObject(Mouse.class);
        if (mouse != null) {
            Greenfoot.stop();
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
}
