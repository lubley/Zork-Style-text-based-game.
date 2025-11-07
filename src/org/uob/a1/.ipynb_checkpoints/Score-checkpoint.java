package org.uob.a1;

public class Score {
    private final int PUZZLE_VALUE = 10
    private int score;
    private int roomsVisited;
    private int puzzles;
    private final int ROOM_VALUE = 3;
    
    
    
    public Score(int startingScore)
    {
        score=100;
        roomsVisited= 0;
        puzzles= 0;
        
    }

    public void visitRoom()
    {
        roomsVisited = roomsVisited + 1;
        score = score - ROOM_VALUE;
    }

    public void solvePuzzle()
    {
    }

    public double getScore()
    {
        //Calculates and returns the current score. The score is calculated as the starting score minus the number of rooms visited plus the number of solved puzzles times the score per puzzle.
        return 100;
    }
        
}