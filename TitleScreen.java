import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the game. Players will learn how to play the game.
 * 
 * @author Jaiden Ing 
 * @version June 13, 2023
 */
public class TitleScreen extends World
{
    //Labels for the title
    Label titleLabel = new Label("Toy Story", 120);
    Label titleLabel2 = new Label("Battlegrounds", 110);
    
    public GreenfootSound backgroundMusic = new GreenfootSound("sounds/Toy Story - Youve Got a Friend in Me.mp3"); //background music
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        //Adds the title labels and sets the location
        addObject(titleLabel, getWidth()/2, (getHeight()/2)-300);
        addObject(titleLabel2, getWidth()/2, (getHeight()/2)-200);
        prepare(); //adds all of the other actors
        
    }
    
    /**
     * The main world act loop
     */
    public void act() {
        startMusic(); //plays music infinitely
        
        //Starts game if user presses space
        if(Greenfoot.isKeyDown("space")) {
            Fight gameWorld = new Fight();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the game.
     * Creates the inital actors and adds them to the world.
     */
    private void prepare() {
        //Adds the ground
        Platform ground = new Platform();
        addObject(ground, getWidth()/2, 720);

        //Adds the first platform
        Platform platform1 = new Platform(200, 25);
        addObject(platform1,getWidth()/2, getHeight()/2);

        //Adds the first platform
        Platform platform2 = new Platform(200, 25);
        addObject(platform2, getWidth()/2, getHeight()/2);

        //Adds player one
        PlayerOne playerOne = new PlayerOne();
        addObject(playerOne,1014,413);

        //Adds player two
        PlayerTwo playerTwo = new PlayerTwo();
        addObject(playerTwo,884,310);

        //Adds labels for the controls of both players
        Label label = new Label("Press <space> to Start", 50);
        Label label2 = new Label("Use \u2190, \u2191, \u2193 and \u2192 move. Enter to shoot", 30);
        Label label3 = new Label("Use WASD to move, F to shoot", 30);

        //Adds the control labels
        addObject(label,601,628);
        addObject(label3,438,413);
        addObject(label2,913,418);

        //Sets location of the two players
        playerTwo.setLocation(854,317);
        playerOne.setLocation(426,315);
        
        //Sets location of the control labels
        label.setLocation(getWidth()/2,646);
        label3.setLocation(468,405);
        label2.setLocation(895,409);
        
        //Sets location of the 2 platforms
        platform1.setLocation(440, 380);
        platform2.setLocation(860, 380);
    }
    /**
     * Play background music
     */
    public void startMusic() {
        backgroundMusic.playLoop(); 
    }
}
