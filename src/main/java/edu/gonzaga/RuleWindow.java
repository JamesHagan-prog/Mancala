package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RuleWindow extends JFrame {
    private JLabel titleLabel;
    private JTextArea ruleTextArea;
    private JButton backButton;

    public RuleWindow() {
        setTitle("Mancala Game Rules");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 360);
        setLocationRelativeTo(null); // Center the window

        // Set color scheme
        // Java Orange RGB: (248, 152, 32)
        // Java Blue RGB: (83, 130, 161)
        getContentPane().setBackground(new Color(248, 152, 32));    // change background color
        getContentPane().setForeground(Color.WHITE);    // change text color

        // Create components
        titleLabel = new JLabel("How to Play");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        ruleTextArea = new JTextArea();
        ruleTextArea.setEditable(false);
        ruleTextArea.setLineWrap(true);
        ruleTextArea.setWrapStyleWord(true);
        ruleTextArea.setText("Object:\n" +
                "The object of the game is to collect the most pieces by the end of the game.\n\n" +
                "Game Play:\n" +
                "1. The game begins with one player picking up all of the pieces in any one of the pockets on his/her side.\n" +
                "2. Moving counter-clockwise, the player deposits one of the stones in each pocket until the stones run out.\n" +
                "3. If you run into your own Mancala (store), deposit one piece in it. If you run into your opponent's Mancala, skip it and continue moving to the next pocket.\n" +
                "4. If the last piece you drop is in your own Mancala, you take another turn.\n" +
                "5. If the last piece you drop is in an empty pocket on your side, you capture that piece and any pieces in the pocket directly opposite.\n" +
                "6. Always place all captured pieces in your Mancala (store).\n" +
                "7. The game ends when all six pockets on one side of the Mancala board are empty.\n" +
                "8. The player who still has pieces on his/her side of the board when the game ends captures all of those pieces.\n" +
                "9. Count all the pieces in each Mancala. The winner is the player with the most pieces.");
        ruleTextArea.setBackground(new Color(83, 130, 161));    // change background color
        ruleTextArea.setForeground(Color.WHITE);    // change text color
        ruleTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));


        backButton = new JButton("Back to Main Screen");
        backButton.setForeground(Color.BLACK);    // change text color
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Return to main screen button pressed");
                // Temporarily just close the rule window
                IntroWindow introWindow = new IntroWindow();
                introWindow.runGUI();
                setVisible(false);
            }
        });

        // Set layout
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(ruleTextArea, BorderLayout.CENTER);

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RuleWindow();
    }
}
