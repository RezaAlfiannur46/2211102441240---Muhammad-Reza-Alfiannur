import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score = 0;
    private boolean isMoving = false;

    public Mouse() {
        GreenfootImage mouseImage = new GreenfootImage("mouse.png");
        setImage(mouseImage);
    }

    public void act() {
        checkCollision();
        checkWin();
        checkKeyPress();

        if (isMoving) {
            move(5); // Kecepatan pergerakan
        }
    }

    private void checkCollision() {
        Actor snake = getOneIntersectingObject(Snake.class);
        Actor coin = getOneIntersectingObject(Coin.class);

        if (snake != null) {
            Greenfoot.stop();
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }

        if (coin != null) {
            getWorld().removeObject(coin);
            increaseScore(10);
        }
    }

    private void increaseScore(int points) {
        score += points;
        getWorld().showText("Score: " + score, 50, 25);
    }

    private void checkWin() {
        if (score >= 100) {
            Greenfoot.setWorld(new NextLevel(score, 2));
        }
    }

    private void checkKeyPress() {
        int moveSpeed = 5;

        if (Greenfoot.isKeyDown("up")) {
            this.setLocation(this.getX(), this.getY() - moveSpeed);
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("down")) {
            this.setLocation(this.getX(), this.getY() + moveSpeed);
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(this.getX() - moveSpeed, this.getY());
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(getX() + moveSpeed, this.getY());
            isMoving = true;
        }

        if (!Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down") && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
            isMoving = false;
        }
    }
}
