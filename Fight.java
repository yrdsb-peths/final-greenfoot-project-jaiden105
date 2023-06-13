import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the world where the players will fight in.
 * 
 * @author Jaiden Ing
 * @version June 13, 2023
 */
public class Fight extends World
{
    public int score1 = 0; //score for player 1
    public int score2 = 0; //score for player 2
    Label playerOneScore; //label for player 1
    Label playerTwoScore; //label for player 2
    
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
        
        //Adds platforms to the world
        addObject(plat1, 400, 500);
        addObject(plat2, 900, 500);
        
        //Adds players to the world
        addObject(p1, 100, 600);
        addObject(p2, 1180, 600);
        
        //Creates score and sets the locations
        playerOneScore = new Label(0, 100);
        playerTwoScore = new Label(0, 100);
        addObject(playerOneScore, getWidth()/2 - 50, 100);
        addObject(playerTwoScore, getWidth()/2 + 50, 100);
        

    }
    /**
     * Increases score for player one
     */
    public void increasePlayerOneScore() {
        this.score1++; //increases player 1 score
        playerOneScore.setValue(this.score1); //sets the score
        
        //Removes all bullets
        removeObjects(getObjects(PlayerOneBullet.class)); 
        removeObjects(getObjects(PlayerTwoBullet.class));
        
        //Sets the locations of players back to original position
        p1.setLocation(100, 600);
        p2.setLocation(1180, 600);
        
        //If player 1 score reaches 5, will switch to victory screen for player 1
        if(score1 == 5) {
            PlayerOneWin victory = new PlayerOneWin();
            Greenfoot.setWorld(victory);
        }
    }
    /**
     * Increases score for player two
     */
    public void increasePlayerTwoScore() {
        this.score2++; //increases player 2 score
        playerTwoScore.setValue(this.score2); //sets the score
        
        //Removes all bullets
        removeObjects(getObjects(PlayerOneBullet.class));
        removeObjects(getObjects(PlayerTwoBullet.class));
        
        //Sets the locations of players back to original position
        p1.setLocation(100, 600);
        p2.setLocation(1180, 600);
        
        //If player 2 score reaches 5, will switch to victory screen for player 2
        if(score2 == 5) {
            PlayerTwoWin victory = new PlayerTwoWin();
            Greenfoot.setWorld(victory);
        }
    }
    
    
    
}
