import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The victory screen for player 2, can also replay the game.
 * 
 * @author Jaiden Ing 
 * @version June 13, 2023
 */
public class PlayerTwoWin extends World
{
    //Labels for the victory text
    Label victoryText = new Label("Player Two Wins!", 120);
    Label playAgain = new Label("To play again, click space", 100);
    /**
     * Constructor for objects of class PlayerOneWin.
     * 
     */
    public PlayerTwoWin()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        //Adds the labels into the world and sets their position
        addObject(victoryText, getWidth()/2, getHeight()/2);
        addObject(playAgain, getWidth()/2, (getHeight()/2)+300);
    }
    
    /**
     * Act method, player can replay by pressing "space".
     */
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            TitleScreen homeScreen = new TitleScreen();
            Greenfoot.setWorld(homeScreen);
        }
    }
}
