import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Actor
{
    //Private variables uses for falling
    private int velocity;
    
    /**
     * Constructor for PlayerOne, sets velocity = 0,
     * PlayerOne is not moving
     */
    public PlayerTwo() {
        this(100,100);
        velocity = 2;
    }
    /**
     * Constructor to set the PlayerOne's size
     */
    public PlayerTwo(int width, int height) {
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
        if(Greenfoot.isKeyDown("up") && isOnGround()) {
            jump();
        }
        if(Greenfoot.isKeyDown("left")) {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("right")) {
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
