import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOneBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOneBullet extends Actor
{
    public PlayerOneBullet() {
        this(25,25);
    }
    public PlayerOneBullet(int width, int height) {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
    /**
     * Act - do whatever the PlayerOneBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(8);
        if(getX() >= 1270) {
            getWorld().removeObject(this);
        }
    } 
    
    
}
