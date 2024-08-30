package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
public class EndScreen {
    private JFrame frame;
    private String Gamewinner;
    EndScreen(String winner){
        Gamewinner=winner;
    }
    public void runGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                endScreen();
            }
        });
    }

    private void endScreen() {
        // Java Orange RGB: (248, 152, 32)
        // Java Blue RGB: (83, 130, 161)
        // Create and set up the window
        frame = new JFrame("EndScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 152, 32)); // Set the background color of the panel

        // Create two buttons
        JButton button1 = new JButton("Play Again");
        JButton button2 = new JButton("Exit");
        button1.setForeground(new Color(83, 130, 161)); // Set the text color of button1
        button2.setForeground(new Color(83, 130, 161)); // Set the text color of button2
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic for the "Play Again" button here
                System.out.println("Play button pressed");
                TurnWindow turn = new TurnWindow();
                turn.runGUI();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        JLabel title = new JLabel("Game Over. "+Gamewinner+" Wins!");
        // Create a new font with bold style and increased size
        Font boldFont = new Font(title.getFont().getName(), Font.BOLD, 16);

        // Set the font of the label
        title.setFont(boldFont);
        title.setForeground(new Color(83, 130, 161)); // Set the text color of the title label
        title.setHorizontalAlignment(SwingConstants.CENTER); // Center align the title label

        // Create a panel for the buttons and use GridBagLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(248, 152, 32)); // Set the background color of the button panel

        // Add the buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        buttonPanel.add(button1, gbc);

        gbc.gridx = 1;
        buttonPanel.add(button2, gbc);

        // Add the title label to the top of the main panel
        panel.add(title, BorderLayout.NORTH);

        // Add the button panel to the bottom of the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Display the window
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
