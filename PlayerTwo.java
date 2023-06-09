import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains player twos's controls, animations and general functionality.
 * 
 * @author Jaiden Ing
 * @version June 13, 2023
 */
public class PlayerTwo extends Actor
{
    GreenfootImage[] walk = new GreenfootImage[3];
    //Private variables uses for falling
    private int velocity;
    
    //Timer for the animation and jumping
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer jumpTimer = new SimpleTimer();
    SimpleTimer fireTimer = new SimpleTimer();
    /**
     * Constructor for PlayerOne, sets velocity = 0,
     * PlayerOne is not moving
     */
    public PlayerTwo() {
        this(100,100); //sets size of PlayerOne to 100x100 pixels
        //Sets timer jump
        jumpTimer.mark();
        
        //Sets shooting timer
        fireTimer.mark();
        
        //Walking animation
        for(int i = 0; i < walk.length; i++) {
            walk[i] = new GreenfootImage("images/player two running/walk" + i +".png");
            walk[i].scale(100, 100);
        }
        
        setImage(walk[0]);
        
        //Walking animation timer
        animationTimer.mark();
        
        
        velocity = 3;
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
        //Only allows movement in the fight world
        if (this.getWorld().getClass() == Fight.class) {
            if(Greenfoot.isKeyDown("up") && isOnGround() && jumpTimer.millisElapsed() > 1000) {
                jump();
                jumpTimer.mark();
            }
            if(Greenfoot.isKeyDown("left")) {
                move(-3);
            }
            else if(Greenfoot.isKeyDown("right")) {
                move(3);
            }
            if(Greenfoot.isKeyDown("enter") && fireTimer.millisElapsed() > 500) {
                fire();
                fireTimer.mark();
            }
        }
        //Increases score for player one
        gotHit();
        
        //Animate the player
        animatePlayer();
    }    
    
    /**
     * Fires player's weapon
     */
    private void fire() {
        PlayerTwoBullet bullet = new PlayerTwoBullet();
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
     * Animate the player
     */
    int currentImage = 0;
    public void animatePlayer() {
        if(animationTimer.millisElapsed() < 300) {
            return;
        }
        animationTimer.mark();
        
        setImage(walk[currentImage]);
        currentImage = (currentImage + 1) % walk.length;
        
    }
    
    /**
     * When player jumps
     */
    public void jump() {
        velocity = -200;
    }
    
    /**
     * Checks if the player is standing on top of a platform
     */
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
     * When player two gets hit by a bullet
     */
    public void gotHit() {
        if(isTouching(PlayerOneBullet.class)) {
            removeTouching(PlayerOneBullet.class);
            Fight world = (Fight) getWorld();
            world.increasePlayerOneScore();       
        }
    }
}
