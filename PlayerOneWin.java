import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOneWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOneWin extends World
{
    Label victoryText = new Label("Player One Wins!", 120);
    Label playAgain = new Label("To play again, click space", 100);
    /**
     * Constructor for objects of class PlayerOneWin.
     * 
     */
    public PlayerOneWin()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        addObject(victoryText, getWidth()/2, getHeight()/2);
        addObject(playAgain, getWidth()/2, (getHeight()/2)+300);
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            TitleScreen homeScreen = new TitleScreen();
            Greenfoot.setWorld(homeScreen);
        }
    }
}
