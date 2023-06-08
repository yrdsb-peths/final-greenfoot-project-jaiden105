import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fight extends World
{
    public int score1 = 0;
    public int score2 = 0;
    Label playerOneScore;
    Label playerTwoScore;
    /**
     * Constructor for objects of class MyWorld. 
     */
    public Fight()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        
        //Creates the ground
        Platform ground = new Platform();
        addObject(ground, getWidth()/2, 720);
        
        //Creates platforms
        Platform plat1 = new Platform(200, 25);
        Platform plat2 = new Platform(200, 25);
        Platform plat3 = new Platform(200, 25);
        
        addObject(plat1, 400, 500);
        addObject(plat2, 900, 500);
        
        //Creates the players
        PlayerOne p1 = new PlayerOne();
        PlayerTwo p2 = new PlayerTwo();
        
        addObject(p1, 100, 600);
        addObject(p2, 1180, 600);
        //Creates score for both players
        playerOneScore = new Label(0, 100);
        playerTwoScore = new Label(0, 100);
        addObject(playerOneScore, getWidth()/2 - 50, 100);
        addObject(playerTwoScore, getWidth()/2 + 50, 100);
        
        
    }
    /**
     * Increases score for player one
     */
    public void increasePlayerOneScore() {
        score1++;
        playerOneScore.setValue(score1);
    }
    /**
     * Increases score for player two
     */
    public void increasePlayerTwoScore() {
        score2++;
        playerTwoScore.setValue(score2);
    }
    
    
    
}
