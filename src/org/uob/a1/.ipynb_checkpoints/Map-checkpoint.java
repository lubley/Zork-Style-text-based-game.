package org.uob.a1;

public class Map {
    final private char EMPTY = '.';
    private int width;
    private int height;
    private char[][] map;

    public Map(int width, int height)
    {
        //this represents the rows and columns starting at the top left of the map
        this.width = width;
        this.height = height;

        map = new char[height][width];
        
        for( int y = 0 ; y < height; y++){
            for( int x = 0 ; x < width; x++){
                map[y][x]= EMPTY;
            }
        }       
    }

    public void placeRoom(Position position, char symbol)
    {
        map[position.y][position.x] = symbol;
        
    }

    public String display()
    {
        if (height == 0 || width == 0)
            return "";
        String mapdisplay = "";
        for( int y = 0 ; y < height; y++)
        {
            for( int x = 0 ; x < width; x++)
            {
                mapdisplay += map[y][x];
            }
            mapdisplay += "\n";
        }
        return mapdisplay;
    }
    
}