import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains player one's controls, animations and general functionality.
 * 
 * @author Jaiden Ing
 * @version June 13, 2023
 */
public class PlayerOne extends Actor
{
    GreenfootImage[] walk = new GreenfootImage[6]; //walk animation images
    
    //Private variable used for falling
    private int velocity;
    
    //Timers for the animation, jumping and shooting
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer jumpTimer = new SimpleTimer();
    SimpleTimer fireTimer = new SimpleTimer();
    
    /**
     * Constructor for PlayerOne, sets velocity = 0,
     * PlayerOne is not moving
     */
    public PlayerOne() {
        this(100,100); //sets size of PlayerOne to 100x100 pixels
        //Sets jump timer
        jumpTimer.mark();
        
        //Sets shooting timer
        fireTimer.mark();
        
        //Walking animation
        for(int i = 0; i < walk.length; i++) {
            walk[i] = new GreenfootImage("images/player one running/walk" + i +".png");
            walk[i].scale(100, 100);
        }
        setImage(walk[0]);
        
        //Walking animation timer
        animationTimer.mark();
        
        velocity = 3; //sets velocity to 3
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
        
        //Animate the player
        animatePlayer();
    }    
    
    /**
     * Fires player's weapon
     */
    public void fire() {
        PlayerOneBullet bullet = new PlayerOneBullet();
        getWorld().addObject(bullet, getX(), getY());
    }
    
    /**
     * Animate the player
     */
    int currentImage = 0;
    public void animatePlayer() {
        //Switching between walking animation frames takes longer
        if(animationTimer.millisElapsed() < 300) {
            return;
        }
        animationTimer.mark(); 
        
        setImage(walk[currentImage]);
        currentImage = (currentImage + 1) % walk.length;
        
    }
    
    
    /**
     * When the player is falling
     */
    public void fall() {
        setLocation(getX(), getY() + velocity); //player falls
        
        if(isOnGround()) { //checks if player is on the ground
            velocity = 0; //velocity = 0, player is not moving
        }
        else {
            velocity = 3; //velocity = 3, player is falling
        }
    }
    
    /**
     * When player jumps, moves player up
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
