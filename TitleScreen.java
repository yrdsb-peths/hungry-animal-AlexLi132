import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Alex
 * @version May 28
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("Hungry Elephant", 70);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, 350, 80);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        // Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld World = new MyWorld();
            Greenfoot.setWorld(World);
        }
        else
        {
            MyWorld World = new MyWorld();
            Greenfoot.setWorld(World);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,497,87);
        elephant.setLocation(109,105);
        Label label = new Label("Press <RUN> to Begin!", 60);
        addObject(label,253,184);
        Label label2 = new Label("Use \u2190 and \u2192 to Eat      !", 60);
        addObject(label2,296,309);
        elephant.setLocation(80,84);
        label.setLocation(300,200);
        label2.setLocation(300,267);
        label2.setLocation(515,263);
        Apple apple = new Apple();
        addObject(apple,515,300);
        label2.setLocation(144,265);
        label2.setLocation(300,300);
    }
}
