import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int score = 0;
    private int snakeSpeed = 2;

    public GameWorld() {
        super(600, 400, 1);
        addObject(new Mouse(), 50, 200);
        addObject(new Snake(snakeSpeed), 550, 200);
        addObject(new Coin(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        showText("Score: " + score, 50, 25);
    }

    public void act() {
        if (score >= 100) {
            Greenfoot.setWorld(new NextLevel(score, snakeSpeed + 1));
        }
    }

    public void increaseScore(int points) {
        score += points;
        showText("Score: " + score, 50, 25);
    }
}
