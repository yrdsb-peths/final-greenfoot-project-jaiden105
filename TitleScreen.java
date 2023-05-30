import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Toy Story", 120);
    Label titleLabel2 = new Label("Battlegrounds", 110);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        addObject(titleLabel, getWidth()/2, (getHeight()/2)-300);
        addObject(titleLabel2, getWidth()/2, (getHeight()/2)-200);
        prepare();
    }
    
    /**
     * The main world act loop
     */
    public void act() {
        //Starts game if user presses space
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the game.
     * Creates the inital objects and adds them to the world.
     */
    private void prepare() {
        Platform ground = new Platform();
        addObject(ground,getWidth()/2, 720);
        
        PlayerOne playerOne = new PlayerOne();
        addObject(playerOne,387,307);
        
        PlayerTwo playerTwo = new PlayerTwo();
        addObject(playerTwo,879,308);
        playerTwo.setLocation(886,300);
    }
    
}
