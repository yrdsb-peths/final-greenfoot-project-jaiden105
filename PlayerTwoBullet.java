import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwoBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwoBullet extends Actor
{
    public PlayerTwoBullet() {
        this(25,25);
        
    }
    public PlayerTwoBullet(int width, int height) {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
    /**
     * Act - do whatever the PlayerTwoBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-8);
        if(getX() <= 10) {
            getWorld().removeObject(this);
        }
    }    
}
