import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our Hero
 * 
 * @author Alex
 * @version May 12
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("gameding.mp3");
    GreenfootSound bombSound = new GreenfootSound("bomb.mp3"); 
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    // our elephant is facing ...
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public int speed = 2;
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant()
    {
        for(int i =0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1)  % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1)  % idleLeft.length;
        }
        
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
            facing = "right";
        }
        
        // Remove apple if elephant eats the apple
        eatApple();
        eatBomb();
        // Animate
        animateElephant();
    }
    /**
     * Eat the apple and spawn a new apple
     */
    public void eatApple()
    {
        if(isTouching(Apple.class))
        {
            elephantSound.play();
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            

        }
    }
    public void eatBomb()
    {
        if(isTouching(Bomb.class))
        {
            bombSound.play();
            removeTouching(Bomb.class);
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            world.removeObject(this); 
        }
    }
    
}
    

