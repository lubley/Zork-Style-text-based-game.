package org.uob.a1;



public class Room {
    private Position position;
    private String name;
    private String description;
    private char symbol;
    
    public Room(String name, String description, char symbol, Position position)
    {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }

    public String getName()
    {
        //display the name of each room based on position
        return name;
    }

    public String getDescription()
    {
        //add description for each room
        return description;
    }

    public char getSymbol()
    {
        //display symbol of the room
        return symbol;
    }

    public Position getPosition()
    {
        //show position on grid
        return position;
    }

    
}