package edu.gonzaga;

import java.util.Scanner;

public class Board {
    private Pocket[][] board = new Pocket[2][6];
    public Player player1;
    public Player player2;
    public void setupGame() {
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 6; j++){
                board[i][j] = new Pocket();
                board[i][j].setNumStones(4);
            }
        }

        //CAPTURE TEST CODE
//        board[0][1].setNumStones(0);
//        board[0][2].setNumStones(0);
//        board[0][3].setNumStones(0);
//        board[0][4].setNumStones(0);
//        board[0][5].setNumStones(0);


        //
        Scanner scanner = new Scanner(System.in);
        // get player names
        System.out.println("Enter Player 1's name: ");
        player1 = new Player("1");
        System.out.println("Enter Player 2's name: ");
        player2 = new Player("2");

        player1.playerBank = board[0][5];
        player1.playerSide = 0;
        player2.playerBank = board[1][5];
        player2.playerSide = 1;


    }
    public void playerTurns(){
        Scanner scanner = new Scanner(System.in);
        displayBoard();
        System.out.println(player1.getName() + "'s turn, enter move");
        makeMove(scanner.nextInt(), player1.playerSide);
        displayBoard();
        System.out.println(player2.getName() + "'s turn, enter move");
        makeMove(scanner.nextInt(), player2.playerSide);
    }
    public void displayBoard() {

        System.out.println("     " + player2.getName() + "'s side v");
        System.out.print("[5]  " + player2.getScore() + "  ");
        for (int i = 5; i >= 0; i--) {
            System.out.print(board[1][i].getNumStones() + " ");
        }
        System.out.print("    [0]\n[0]     ");
        for (int i = 0; i < 6; i++) {
            System.out.print(board[0][i].getNumStones() + " ");
        }
        System.out.println(" " + player1.getScore() + "  [5]\n     " + player1.getName() + "'s side ^\n");

    }
    public boolean makeMove(int input, int playerSide) {
        int numStones = board[playerSide][input].getNumStones(); //Number of moves
        int side = playerSide; //Starting side
        board[playerSide][input].setNumStones(0); //Set pocket taking from to zero
        for (int i = numStones; i > 0; i--){
            input++;//Move to next space
            if (input>5) { //Check if you have to change sides
                input = 0;// Start at zero on next side
                if (side == playerSide) { //CHeck if you bank 1 stone
                    if (playerSide == 0) {
                        player1.updateScore(1);
                        if (checkTurnAgain(i, playerSide) == true){
                            return true;
                        }
                    } else {
                        player2.updateScore(1);
                        if (checkTurnAgain(i, playerSide) == true){
                            return true;
                        }
                    }
                    i--;//Remove one stone as you banked
                    if (i == 0) {
                        return false; //If out of stones return
                    }
                }
                side = (side+1)%2;//Change side
            }
            board[side][input].visitedPocket();//Add stone
        }
        if (playerSide == side) {
            checkCapture(side, input, playerSide);
        }
        return false;
    }

    public boolean checkTurnAgain(int stonesLeft, int playerSide) {
        Scanner scanner = new Scanner(System.in);

        if (playerSide == 0) {  //for player 1
           if (stonesLeft - 1 == 0) { //the last stone just went into the bank
               displayBoard();
               //System.out.println(player1.getName() + "'s turn again, enter move"); //says they go again
               //makeMove(scanner.nextInt(), player1.playerSide); //calls makeMove, so just this player goes again
               return true;
           }
        }
        else {    //for player 2
            if (stonesLeft - 1 == 0) {
                displayBoard();
                //System.out.println(player2.getName() + "'s turn again, enter move");
                //makeMove(scanner.nextInt(), player2.playerSide);
                return true;
            }
        }
        return false;
    }

    public void checkCapture(int side, int pocket, int playerSide) {
        if (board[side][pocket].getNumStones() == 1) { //meaning the stone just put in is the only one
            if (playerSide == 0) {
                player1.updateScore(board[1][5 - pocket].getNumStones()); //takes stones from adjacent pocket
                board[1][5 - pocket].setNumStones(0);                     //sets that pocket to 0
            } else {    //playerSide == 1
                player2.updateScore(board[0][5 - pocket].getNumStones());   //takes stones from adjacent pocket
                board[0][5 - pocket].setNumStones(0);                       //sets that pocket to 0
            }
        }
    }
 
    public boolean p1HasLost(){
        for (int i=0;i<6;i++){
            if (board[0][i].getNumStones()!=0){
                return false;
            }
        }
        return true;
    }
      
    public boolean p2HasLost(){
        for (int i=0;i<6;i++){
            if (board[1][i].getNumStones()!=0){
                return false;
            }
        }
        return true;
    }
    public int endGame(){
       int winner;
       for (int i=0;i<6;i++){ //Iteriate through and take all stones
           player1.updateScore(board[0][i].getNumStones());
           player2.updateScore(board[1][i].getNumStones());
       }
       if (player1.getScore()>player2.getScore()){//Check whos winner
           winner = 1;
       }
       else
           winner = 2;

       return winner;
    }
    public void testSetup(){
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 6; j++){
                board[i][j] = new Pocket();
                board[i][j].setNumStones(4);
            }
        }
        player1 = new Player("J");
        player2 = new Player("S");

        player1.playerBank = board[0][5];
        player1.playerSide = 0;
        player2.playerBank = board[1][5];
        player2.playerSide = 1;
    }
    public Pocket[][] getBoard() {
        return board;
    }
    public int getScore(int i) {
        if (i == 1)
            return player1.getScore();
        else
            return player2.getScore();
    }
}
