package org.uob.a1;

public class Score {
    private final int PUZZLE_VALUE = 10;
    private int score;
    private int roomsVisited;
    private int puzzles;
    
    
    public Score(int startingScore)
    {
        this.score = startingScore;
        roomsVisited= 0;
        puzzles= 0;
        
    }

    public void visitRoom()
    {
        roomsVisited = roomsVisited + 1;
        
    }

    public void solvePuzzle()
    {
        puzzles = puzzles + 1;
    }

    public double getScore()
    {
        
        return score - roomsVisited + (puzzles * PUZZLE_VALUE);
        //Calculates and returns the current score. The score is calculated as the starting score minus the number of rooms visited plus the number of solved puzzles times the score per puzzle.
    }
        
}