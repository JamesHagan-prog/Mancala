package edu.gonzaga;

public class Mancala {
    public void startGame() {
        boolean run=true;
        this.terminalIntroScreen();
        Board mainBoard = new Board();
        mainBoard.setupGame();
        while (run&&!mainBoard.p1HasLost()&&!mainBoard.p2HasLost()){
            mainBoard.playerTurns();
        }
        System.out.println("game over");
        int winner = mainBoard.endGame();
        if (winner==1){
            System.out.println("Player 1 wins");
        }
        else{
            System.out.println("Player 2 wins");
        }
    }
    public void terminalIntroScreen() {
        System.out.println("*****************************************");
        System.out.println("*                MONCALA                *");
        System.out.println("*              Created by               *");
        System.out.println("*         The Java Juggernauts          *");
        System.out.println("*****************************************");
    }
}
