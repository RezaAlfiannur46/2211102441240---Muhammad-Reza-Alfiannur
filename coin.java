import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Coin() {
        GreenfootImage coinImage = new GreenfootImage("coin.png");
        setImage(coinImage);
    }

    public void act() {
        checkCollision();
    }

    private void checkCollision() {
        Actor mouse = getOneIntersectingObject(Mouse.class);
        if (mouse != null) {
            getWorld().removeObject(this);
            if (getWorld() instanceof GameWorld) {
                ((GameWorld) getWorld()).increaseScore(10);
            }
        }
    }
}
