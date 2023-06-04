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
            Fight gameWorld = new Fight();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the game.
     * Creates the inital objects and adds them to the world.
     */
    private void prepare() {
        Platform ground = new Platform();
        addObject(ground, getWidth()/2, 720);

        Platform platform1 = new Platform(200, 25);
        addObject(platform1,getWidth()/2, getHeight()/2);

        Platform platform2 = new Platform(200, 25);
        addObject(platform2, getWidth()/2, getHeight()/2);

        PlayerOne playerOne = new PlayerOne();
        addObject(playerOne,1014,413);

        PlayerTwo playerTwo = new PlayerTwo();
        addObject(playerTwo,884,310);

        Label label = new Label("Press <space> to Start", 50);

        Label label2 = new Label("Use \u2190, \u2191, \u2193 and \u2192 move. Enter to shoot", 30);

        Label label3 = new Label("Use WASD to move, F to shoot", 30);

        addObject(label,601,628);
        addObject(label3,438,413);
        addObject(label2,913,418);

        label2.setLocation(336,408);
        label.setLocation(getWidth()/2,646);
        playerTwo.setLocation(854,317);
        playerOne.setLocation(336,311);
        label3.setLocation(560,408);
        playerOne.setLocation(426,315);
        label2.setLocation(936,413);

        label3.setLocation(468,405);
        label2.setLocation(895,409);
        
        platform1.setLocation(440, 380);
        platform2.setLocation(860, 380);
    }
    
}
