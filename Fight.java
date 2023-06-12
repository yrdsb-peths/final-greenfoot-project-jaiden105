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
    //Creates the players
    PlayerOne p1 = new PlayerOne();
    PlayerTwo p2 = new PlayerTwo();
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
        
        
        addObject(p1, 100, 600);
        addObject(p2, 1180, 600);
        //Creates score for both players
        playerOneScore = new Label(0, 100);
        playerTwoScore = new Label(0, 100);
        addObject(playerOneScore, getWidth()/2 - 50, 100);
        addObject(playerTwoScore, getWidth()/2 + 50, 100);
        
        if(score1 == 5) {
            PlayerOneWin victory = new PlayerOneWin();
            Greenfoot.setWorld(victory);
        }
        else if(score2 == 5) {
            PlayerTwoWin victory = new PlayerTwoWin();
            Greenfoot.setWorld(victory);
        }
    }
    /**
     * Increases score for player one
     */
    public void increasePlayerOneScore() {
        this.score1++;
        playerOneScore.setValue(this.score1);
        removeObjects(getObjects(PlayerOneBullet.class));
        removeObjects(getObjects(PlayerTwoBullet.class));
        p1.setLocation(100, 600);
        p2.setLocation(1180, 600);
        if(score1 == 5) {
            PlayerOneWin victory = new PlayerOneWin();
            Greenfoot.setWorld(victory);
        }
    }
    /**
     * Increases score for player two
     */
    public void increasePlayerTwoScore() {
        this.score2++;
        playerTwoScore.setValue(this.score2);
        removeObjects(getObjects(PlayerOneBullet.class));
        removeObjects(getObjects(PlayerTwoBullet.class));
        p1.setLocation(100, 600);
        p2.setLocation(1180, 600);
        if(score2 == 5) {
            PlayerTwoWin victory = new PlayerTwoWin();
            Greenfoot.setWorld(victory);
        }
    }
    
    
    
}
