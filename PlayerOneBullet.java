import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Contains player one's bullet size and functionality (movement).
 * 
 * @author Jaiden Ing
 * @version June 13, 2023
 */
public class PlayerOneBullet extends Actor
{
    /**
     * Default constructor for PlayerOneBullet
     */
    public PlayerOneBullet() {
        this(25,25); //sets default size to 25x25 pixels
    }
    /**
     * PlayerOneBullet constructor for customizing size
     */
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
        move(8); //speed bullet moves at
        if(getX() >= 1270) {
            getWorld().removeObject(this); //removes bullet if touching border
        }
    } 
    
    
}
