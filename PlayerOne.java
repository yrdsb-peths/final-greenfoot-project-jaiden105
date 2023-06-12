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
    
    //Timer for the animation, jumping and shooting
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer jumpTimer = new SimpleTimer();
    SimpleTimer fireTimer = new SimpleTimer();
    /**
     * Constructor for PlayerOne, sets velocity = 0,
     * PlayerOne is not moving
     */
    public PlayerOne() {
        this(100,100);
        //Sets jump timer
        jumpTimer.mark();
        
        //Sets shooting timer
        fireTimer.mark();
        
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
        //Only allows movement in the fight world
        if (this.getWorld().getClass() == Fight.class) {
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
            if(Greenfoot.isKeyDown("f") && fireTimer.millisElapsed() > 500) {
                fire();
                fireTimer.mark();
            }
        }
        //Increases score for player two
        gotHit();
    }    
    
    /**
     * Fires player's weapon
     */
    public void fire() {
        PlayerOneBullet bullet = new PlayerOneBullet();
        getWorld().addObject(bullet, getX(), getY());
        
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
            velocity = 3;
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
    /**
     * When player one gets hit by a bullet
     */
    public void gotHit() {
        if(isTouching(PlayerTwoBullet.class)) {
            removeTouching(PlayerTwoBullet.class);
            Fight world = (Fight) getWorld();
            world.increasePlayerTwoScore();
        }
    }
}
