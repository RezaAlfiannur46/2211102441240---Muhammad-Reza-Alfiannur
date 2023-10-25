import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel extends World
{

    /**
     * Constructor for objects of class NextLevel.
     * 
     */
    private int snakeSpeed;

    public NextLevel(int score, int snakeSpeed) {
        super(600, 400, 1);
        addObject(new Mouse(), 50, 200);
        addObject(new Snake(snakeSpeed), 550, 200);
        addObject(new Coin(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        showText("Score: " + score, 50, 25);
        this.snakeSpeed = snakeSpeed;
    }
}
