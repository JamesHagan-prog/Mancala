/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors:
 * 
 * 
 * Copyright: 2023
 */
package edu.gonzaga;


/** Main program class for launching your team's program. */
public class MainGame {
    public static void main(String[] args) {
        // Your code here. Good luck!
        Mancala mancala = new Mancala();
        IntroWindow introWindow = new IntroWindow();
        introWindow.runGUI();
        mancala.startGame();

        //GUI TEST STUFF

    }
}
