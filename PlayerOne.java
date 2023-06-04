import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    //Private variables uses for falling
    private int velocity;
    
    //Timer for the animation and jumping
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer jumpTimer = new SimpleTimer();
    /**
     * Constructor for PlayerOne, sets velocity = 0,
     * PlayerOne is not moving
     */
    public PlayerOne() {
        this(100,100);
        //Sets timer jump
        jumpTimer.mark();
        
        //Walking animation
        
        animationTimer.mark();
        
        
        
        velocity = 3;
    }
    /**
     * Constructor to set the PlayerOne's size
     */
    public PlayerOne(int width, int height) {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fall();
        if(Greenfoot.isKeyDown("w") && isOnGround() && jumpTimer.millisElapsed() > 1000) {
            jump();
            jumpTimer.mark();
        }
        if(Greenfoot.isKeyDown("a")) {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("d")) {
            move(3);
        }
    }    

    /**
     * When the player is falling
     */
    public void fall() {
        setLocation(getX(), getY() + velocity);
        if(isOnGround()) {
            velocity = 0;
        }
        else {
            velocity = 2;
        }
    }
    /**
     * When player jumps
     */
    public void jump() {
        velocity = -200;
    }
    
    public boolean isOnGround() {
        boolean isTouchingPlatform = false;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Platform.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Platform.class) != null) {
            isTouchingPlatform = true;
        }
        
        return isTouchingPlatform;
    }
}
