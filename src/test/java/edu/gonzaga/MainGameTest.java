package edu.gonzaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MainGameTest {
    @Test
    void alwaysTrue() {
        Assertions.assertTrue(true);
    }
    @Test
    void checkEndGame(){
        Board board1 = new Board();
        Board board2 = new Board();
        board1.testSetup();
        board2.testSetup();
        board1.makeMove(5,1);
        board2.makeMove(5,0);
        Assertions.assertEquals(1,board1.endGame());
        Assertions.assertEquals(2,board2.endGame());
    }
    @Test
    void checkCaptureP1(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(4,0);
        board1.makeMove(0,0);
        Assertions.assertEquals(6,board1.getScore(1));
    }
    @Test
    void checkCaptureP2(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(4,1);
        board1.makeMove(0,1);
        Assertions.assertEquals(6,board1.getScore(2));
    }
    @Test
    void checkMove1(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,0);
        Assertions.assertEquals(0,board1.getBoard()[0][0].getNumStones());
        Assertions.assertEquals(5,board1.getBoard()[0][4].getNumStones());
    }
    @Test
    void checkMove2(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(5,0);
        Assertions.assertEquals(0,board1.getBoard()[0][5].getNumStones());
        Assertions.assertEquals(5,board1.getBoard()[1][2].getNumStones());
    }
    @Test
    void checkMove3(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,1);
        Assertions.assertEquals(0,board1.getBoard()[1][0].getNumStones());
        Assertions.assertEquals(5,board1.getBoard()[1][4].getNumStones());
    }
    @Test
    void checkMove4(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(5,1);
        Assertions.assertEquals(0,board1.getBoard()[1][5].getNumStones());
        Assertions.assertEquals(5,board1.getBoard()[0][2].getNumStones());
    }
    @Test
    void checkMove5(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(3,0);
        Assertions.assertEquals(0,board1.getBoard()[0][3].getNumStones());
        Assertions.assertEquals(5,board1.getBoard()[1][0].getNumStones());
    }
    @Test
    void checkP1PlayAgain() {
        Board board1 = new Board();
        board1.testSetup();
        Assertions.assertTrue(board1.makeMove(2, 0));
    }
    @Test
    void checkP2PlayAgain() {
        Board board1 = new Board();
        board1.testSetup();
        Assertions.assertTrue(board1.makeMove(2,1));
    }
    @Test
    void checkP1Score(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,0);
        board1.makeMove(1,0);
        board1.makeMove(2,0);
        board1.makeMove(3,0);
        board1.makeMove(4,0);
        board1.makeMove(5,0);
        Assertions.assertEquals(11,board1.getScore(1));
    }
    @Test
    void checkP2Score(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,1);
        board1.makeMove(1,1);
        board1.makeMove(2,1);
        board1.makeMove(3,1);
        board1.makeMove(4,1);
        board1.makeMove(5,1);
        Assertions.assertEquals(11,board1.getScore(2));
    }
    @Test
    void checkP1HasLost(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,0);
        board1.makeMove(1,0);
        board1.makeMove(2,0);
        board1.makeMove(3,0);
        board1.makeMove(4,0);
        board1.makeMove(5,0);
        board1.makeMove(0,0);
        board1.makeMove(1,0);
        board1.makeMove(2,0);
        board1.makeMove(3,0);
        board1.makeMove(4,0);
        board1.makeMove(5,0);
        Assertions.assertEquals(48,board1.getScore(1));
        Assertions.assertTrue(board1.p1HasLost());
    }
    @Test
    void checkP2HasLost(){
        Board board1 = new Board();
        board1.testSetup();
        board1.makeMove(0,1);
        board1.makeMove(1,1);
        board1.makeMove(2,1);
        board1.makeMove(3,1);
        board1.makeMove(4,1);
        board1.makeMove(5,1);
        board1.makeMove(0,1);
        board1.makeMove(1,1);
        board1.makeMove(2,1);
        board1.makeMove(3,1);
        board1.makeMove(4,1);
        board1.makeMove(5,1);
        Assertions.assertEquals(48,board1.getScore(2));
        Assertions.assertTrue(board1.p2HasLost());
    }
}
