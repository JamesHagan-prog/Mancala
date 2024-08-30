package edu.gonzaga;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    public int score;
    public boolean playerTurn;
    public Pocket playerBank;
    public int playerSide;
    private String name;

    // constructor for player
    public Player(String name) {
        this.name = name;
    }

    // return name of player
    public String getName() {
        return this.name;
    }

    // update player score
    public void updateScore(int score) {
        this.score += score;
    }

    // return player score
    public int getScore() {
        return this.score;
    }
    
    // get user input for user names
    public static String getUserNameInput() {
        Scanner s_Input = new Scanner(System.in);
        String playerName = s_Input.nextLine();
        // default name to "Unknown Player"
        if(Objects.equals(playerName, "")) {
            playerName = "Unknown Player";
        }
        return playerName;
    }

}
