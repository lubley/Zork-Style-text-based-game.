package org.uob.a1;

import java.util.Scanner; 

public class Game {
    private Map map;
    private Inventory inventory;
    private Room currentRoom;
    private Score score;
    private boolean gameOn;
    
    public static void main(String args[])
    {
        Game game = new Game();
        game.playgame();
        
    }

    public void Game()
    {
        inventory = new Inventory();
        score = new Score(100);
        map = new Map(6,7);
        gameOn = true;

        Room throneroom = new Room("Throne Room","A grand room with the King sitting on his Throne, you may speak to him",'T', new Position(2,1));
        Room garden = new Room("Garden","A beautiful lush garden filled with delicately grown vegetables (lettuce) and the hungry royal cat",'G',new Position(1,2));
        Room northHall = new Room("North Hall","The north of the Grand Hallway leading to the Throne Room, Garden and Dining Hall",'H',new Position(2,2));
        Room diningHall = new Room("Dining Hall","A large dining hall with a long table where the food is served for the king",'D',new Position(3,2));
        Room centreHall = new Room("Centre Hall","The centre of the grand Hallway it connects to the north and south of the grand hall",'H',new Position(2,3));
        Room southHall = new Room("South Hall","The south of the grand Hallway, leading to the meat room, bakery and Kitchen",'H',new Position(2,4));
        Room kitchen = new Room("Kitchen","The palaces great kitchen where you can cook anything you can dream of! You can access the freezer from here",'K',new Position(3,4));
        Room meatRoom = new Room("Meat Room","Filled with fish and meat for all of the Kings favourite recipes",'M',new Position(1,4));
        Room bakery = new Room("Bakery","The palaces finest bakery filled with buns and pastries.",'B',new Position(2,5));
        Room freezer = new Room("Freezer","A chilling freezer with cheese blocks and other cold ingredients",'F',new Position(4,4));

        currentRoom = throneroom;
        //constructur method which starts the game up
    }

    public void playgame()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Escape the palace");
        System.out.println("Complete the tasks given to you by the King to leave, you are a Royal Chef at the palace");
        System.out.println("You are currently in the Throne Room, the king is sitting on the throne at the end of the room, type 'talk king' to speak to the king");
        System.out.println("Type 'help' for a list of commands!");

        while(gameOn = true)
        {
            System.out.println("\n >>");
            String input = scanner.nextLine();
            input = input.trim();
            input = input.toLowerCase();

            switch(input){
                case "quit":
                    gameOn = false;
                    System.out.println("Thanks for playing");
                    System.out.println(score);
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
            }
            
        }
    }

}