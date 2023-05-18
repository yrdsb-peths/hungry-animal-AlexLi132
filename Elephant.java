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
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        // Remove apple if elephant eats the apple
        eat();
    }
    /**
     * Eat the apple and spawn a new apple
     */
    public void eat()
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
    
}
