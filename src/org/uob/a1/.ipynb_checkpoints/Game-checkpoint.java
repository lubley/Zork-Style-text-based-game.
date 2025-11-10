package org.uob.a1;

import java.util.Scanner; 

public class Game {
    private Map map;
    private Inventory inventory;
    private Room currentRoom;
    private Score score;
    private boolean gameOn;

    private Room throneroom ;
    private Room garden;
    private Room northHall;
    private Room diningHall;
    private Room centreHall;
    private Room southHall;
    private Room kitchen;
    private Room meatRoom;
    private Room bakery;
    private Room freezer;
    
    public static void main(String args[])
    {
        Game game = new Game();
        game.startGame();
        game.playgame();
        
    }

    public void startGame()
    {
        inventory = new Inventory();
        score = new Score(100);
        map = new Map(6,7);
        gameOn = true;

        String lettuce = "lettuce";
        String patty = "patty";
        String fish = "fish";
        String bun = "bun";
        String cheese = "cheese";
        String burger = "burger";

        throneroom = new Room("Throne Room","A grand room with the King sitting on his Throne, you may speak to him",'T', new Position(2,1));
        garden = new Room("Garden","A beautiful lush garden filled with delicately grown vegetables (lettuce) and the hungry royal cat",'G',new Position(1,2));
        northHall = new Room("North Hall","The north of the Grand Hallway leading to the Throne Room, Garden and Dining Hall",'H',new Position(2,2));
        diningHall = new Room("Dining Hall","A large dining hall with a long table where the food is served for the king",'D',new Position(3,2));
        centreHall = new Room("Centre Hall","The centre of the grand Hallway it connects to the north and south of the grand hall",'H',new Position(2,3));
        southHall = new Room("South Hall","The south of the grand Hallway, leading to the meat room, bakery and Kitchen",'H',new Position(2,4));
        kitchen = new Room("Kitchen","The palaces great kitchen where you can cook anything you can dream of! You can access the freezer from here",'K',new Position(3,4));
        meatRoom = new Room("Meat Room","Filled with fish and meat for all of the Kings favourite recipes, there is a fish and burger patty lying on the shelf",'M',new Position(1,4));
        bakery = new Room("Bakery","The palaces finest bakery filled with buns and pastries.",'B',new Position(2,5));
        freezer = new Room("Freezer","A chilling freezer with cheese blocks and other cold ingredients",'F',new Position(4,4));

        currentRoom = throneroom;

        map.placeRoom(throneroom.getPosition(),throneroom.getSymbol());
        map.placeRoom(garden.getPosition(),garden.getSymbol());
        map.placeRoom(northHall.getPosition(),northHall.getSymbol());
        map.placeRoom(diningHall.getPosition(),diningHall.getSymbol());
        map.placeRoom(centreHall.getPosition(),centreHall.getSymbol());
        map.placeRoom(southHall.getPosition(),southHall.getSymbol());
        map.placeRoom(kitchen.getPosition(),kitchen.getSymbol());
        map.placeRoom(meatRoom.getPosition(),meatRoom.getSymbol());
        map.placeRoom(bakery.getPosition(),bakery.getSymbol());
        map.placeRoom(freezer.getPosition(),freezer.getSymbol());

        
        
    }

    public void playgame()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Escape the palace");
        System.out.println("Complete the tasks given to you by the King to leave, you are a Royal Chef at the palace");
        System.out.println("You are currently in the Throne Room, the king is sitting on the throne at the end of the room, type 'talk king' to speak to the king");
        System.out.println("Type 'help' for a list of commands!");

        while(gameOn == true)
        {
            System.out.print(">> ");
            String input = scanner.nextLine();
            input = input.trim();
            input = input.toLowerCase();

            switch(input){
                case "quit":
                    gameOn = false;
                    System.out.println("Thanks for playing");
                    System.out.println(score.getScore());
                    break;
                case "help":
                    System.out.println("Commands: move <direction>, talk, look, look <feature>, look <item>, inventory, score, map, quit");
                    break;
                case "look":
                    System.out.println(currentRoom.getDescription());
                    break;
                case "map":
                    System.out.println(map.display());
                    break;
                case "score":
                    System.out.println("Score: "+ score.getScore());
                    break;
                case "inventory":
                    System.out.println(inventory.displayInventory());
                    break;
                case "make burger":
                    if (inventory.hasItem("lettuce") != -1 &&
                    inventory.hasItem("bun") != -1 &&
                    inventory.hasItem("patty") != -1 &&
                    inventory.hasItem("cheese") != -1) 
                    {
                        inventory.removeItem("lettuce");
                        inventory.removeItem("bun");
                        inventory.removeItem("patty");
                        inventory.removeItem("cheese");
                        inventory.addItem("burger");
                        System.out.println("You have made a burger! Go to the dining hall to server the burger to the king");
                    }
                    else
                    {
                        System.out.println("Sorry you do not have all the items to cook a burger.");
                    }
                    break;
                case "place burger":
                    if(inventory.hasItem("burger") != - 1)
                    {
                        
                        System.out.println("The burger has been placed on the dining table. Puzzle #1 Complete! Your score has been updated.");
                        score.solvePuzzle();
                    }
                    else
                    {
                        System.out.println("Sorry you have not completed the burger puzzle");
                    }
                    break;

                case "feed cat":
                    if(inventory.hasItem("fish") != -1)
                    {
                        System.out.println("The royal cat has been fed. Puzzle #2 Complete! Your score has been updated.");
                        score.solvePuzzle();
                    }
                case "take cheese":
                    System.out.println("A cheese block has been added to your inventory.");
                    inventory.addItem("cheese");
                    break;
                case "take patty":
                    System.out.println("A burger patty has been added to your inventory.");
                    inventory.addItem("patty");
                    break;
                case "take bun":
                    System.out.println("A burger bun has been added to your inventory.");
                    inventory.addItem("bun");
                    break;
                case "take lettuce":
                    System.out.println("Lettuce has been added to your inventory.");
                    inventory.addItem("lettuce");
                    break;
                case "take fish":
                    System.out.println("A fish has been added to your inventory.");
                    inventory.addItem("fish");
                    break;
                default:
                    if (input.startsWith("move")) {
                        move(input);
                    } else {
                        System.out.println("I don't understand that command.");
                    }
                    break;
            }
            
        }
    }
    public void move(String input)
    {
        score.visitRoom();
        switch(currentRoom.getName())
        {
            case "Throne Room":
                if(input.equals("move south")){
                    currentRoom = northHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else{
                    System.out.println("You cannot go that way!!");
                }
                break;
            case "Garden":
                if (input.equals("move east")) {
                    currentRoom = northHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                } 
                else 
                {
                    System.out.println("You cannot go that way!!");
                }
                 break;
            case "Dining Hall":
                if(input.equals("move west")){
                    currentRoom = northHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else {
                    System.out.println("You cant go that way!!");
                }
                break;
            case "North Hall":
                if (input.equals("move north")) {
                    currentRoom = throneroom;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if (input.equals("move south")) {
                    currentRoom = centreHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if (input.equals("move west")) {
                    currentRoom = garden;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if (input.equals("move east")) {
                    currentRoom = diningHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else {
                    System.out.println("You can't go that way!");
                }
                break;
            case "Centre Hall":
                if (input.equals("move north")) {
                    currentRoom = northHall;
                    System.out.println("You are now in the " + currentRoom.getName()); }
                else if (input.equals("move south")) {
                    currentRoom = southHall;
                    System.out.println("You are now in the " + currentRoom.getName()); }
                else {
                    System.out.println("You can't go that way!"); }
                break;
            case "South Hall":
                if (input.equals("move north")) {
                    currentRoom = centreHall; 
                    System.out.println("You are now in the " + currentRoom.getName()); }
                else if (input.equals("move south")){
                    currentRoom = bakery;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if (input.equals("move west")) {
                    currentRoom = meatRoom;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if (input.equals("move east")) {
                    currentRoom = kitchen;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else {
                    System.out.println("You can't go that way!"); }
                break;
            case "Meat Room":
                if(input.equals("move east")){
                    currentRoom = southHall;
                    System.out.println("You are now in the " + currentRoom.getName()); 
                }
                else {
                    System.out.println("You cant go that way!!");
                }
                break;
            case "Bakery":
                if(input.equals("move north")){
                    currentRoom = southHall;
                    System.out.println("You are now in the " + currentRoom.getName()); 
                }
                else {
                    System.out.println("You cant go that way!!");
                }
                break;
            case "Kitchen":
                if(input.equals("move west")){
                    currentRoom = southHall;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else if(input.equals("move east")){
                    currentRoom = freezer;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else {
                    System.out.println("You cant go that way!!");
                }
                break;
            case "Freezer":
                if(input.equals("move west")){
                    currentRoom = kitchen;
                    System.out.println("You are now in the " + currentRoom.getName());
                }
                else {
                    System.out.println("You cant go that way!!");
                }
                break;
        }
    }
            
                
                    

}