package edu.gonzaga;

public class Pocket {

    public int numStones;

    Pocket() {
        numStones = 4; //game always starts with 4 stones
    }
    public void setNumStones(int num){
        numStones = num;
    }
    public int getNumStones() {
        return numStones;
    }
    public void visitedPocket() {
        numStones += 1;
    }
}
