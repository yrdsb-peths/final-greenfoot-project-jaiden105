import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor class will create the platforms needed for the game.
 * 
 * @author Jaiden Ing 
 * @version June 13, 2023
 */
public class Platform extends Actor
{
    /**
     * Default constructor of Platform
     */
    public Platform() {
        this(1280, 100); //sets as default size
    }
    /**
     * Constructor to set the platforms size
     */
    public Platform(int width, int height) {
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
}
