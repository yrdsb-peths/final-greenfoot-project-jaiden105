import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains player two's bullet size and functionality (movement).
 * 
 * @author Jaiden Ing
 * @version June 13, 2023
 */
public class PlayerTwoBullet extends Actor
{
    /**
     * Default constructor for PlayerTwoBullet
     */
    public PlayerTwoBullet() {
        this(25,25); //sets default size to 25x25 pixels
        
    }
    /**
     * PlayerTwoBullet constructor for customizing size
     */
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
        move(-8); //speed bullet moves at backwards
        if(getX() <= 10) {
            getWorld().removeObject(this); //removes bullet if touching border
        }
    }    
}
