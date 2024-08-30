package edu.gonzaga;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IntroWindow extends JFrame{
    Timer timer;
    JFrame mainWindowFrame;
    JPanel mainTitle = new JPanel();
    JLabel teamLogo = new JLabel();
    JButton playButton = new JButton();
    JButton rulesButton = new JButton();

    public static void main() {
        IntroWindow introWindow = new IntroWindow();
        introWindow.runGUI();

    }
    void setupTitle() {
        Color blue = new Color(83, 130, 161);
        Color orange = new Color(248, 152, 32);
        //setup stuff
        this.mainWindowFrame = new JFrame("Java Juggernauts Mancala");
        this.mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindowFrame.setLocation(100,100);
        ImageIcon backgroundImage = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/gonzaga/Images/mancalaBackground.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        mainWindowFrame.getContentPane().add(backgroundLabel);
        //title label
        JLabel titleM = makeTitleCharacter("M");
        JLabel titleA1 = makeTitleCharacter("A");
        JLabel titleN = makeTitleCharacter("N");
        JLabel titleC = makeTitleCharacter("C");
        JLabel titleA2 = makeTitleCharacter("A");
        JLabel titleL = makeTitleCharacter("L");
        JLabel titleA3 = makeTitleCharacter("A");

        //team logo
        ImageIcon logo = new ImageIcon();
        this.teamLogo.setIcon(logo);
        //play button
        this.playButton = new JButton("PLAY");
        this.playButton.setFont(new Font("Sanserif", Font.PLAIN, 30 ));
        this.playButton.setBackground(orange);
        this.playButton.setForeground(blue);
        this.playButton.setBorder(new EmptyBorder(10,0,10,0));
        this.playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //rules button
        this.rulesButton = new JButton("RULES");
        this.rulesButton.setFont(new Font("Sanserif", Font.PLAIN, 30 ));
        this.rulesButton.setBackground(orange);
        this.rulesButton.setForeground(blue);
        this.rulesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //end stuff
        mainTitle.setLayout(new BoxLayout(mainTitle, BoxLayout.X_AXIS));
        mainTitle.add(titleM);
        mainTitle.add(titleA1);
        mainTitle.add(titleN);
        mainTitle.add(titleC);
        mainTitle.add(titleA2);
        mainTitle.add(titleL);
        mainTitle.add(titleA3);
        this.mainTitle.setBorder(new EmptyBorder(50,115,20,200));
        mainTitle.setAlignmentX(0);

        mainTitle.setOpaque(false);
        mainTitle.repaint();


        JPanel buttons = new JPanel();
        JLabel buttonBuffer = new JLabel();
        JLabel bottomBuffer = new JLabel();
        buttonBuffer.setBorder(new EmptyBorder(10,10,10,10));
        bottomBuffer.setBorder(new EmptyBorder(10,10,10,10));
        //bottomBuffer.setOpaque(true);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.add(playButton);
        buttons.add(buttonBuffer);
        buttons.add(rulesButton);
        buttons.add(bottomBuffer);
        buttons.setOpaque(false);
        buttons.repaint();

        backgroundLabel.add(BorderLayout.NORTH, this.mainTitle);
        //mainTitle.setAlignmentX(0);
        JLabel teamName = new JLabel("By the Java Juggernauts");
        teamName.setBorder(new EmptyBorder(0,130,0,0));
        teamName.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        teamName.setForeground(blue);
        backgroundLabel.add(BorderLayout.CENTER, teamName);
        backgroundLabel.add(BorderLayout.SOUTH, buttons);

        //mainWindowFrame.setSize(612, 408);

        animateTitle(mainTitle);
        mainWindowFrame.setResizable(false);
        mainWindowFrame.pack();
        mainWindowFrame.setLocationRelativeTo(null);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens up James' window
                System.out.println("Play button pressed");
                TurnWindow turn = new TurnWindow();
                turn.runGUI();
                mainWindowFrame.setVisible(false);
            }
        });
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens up Abby's window
                System.out.println("Rules button pressed");
                RuleWindow ruleWindow = new RuleWindow();
                mainWindowFrame.setVisible(false);
            }
        });
    }
    void runGUI() {
        System.out.println("Starting GUI app");
        setupTitle();

        mainWindowFrame.setVisible(true);
        System.out.println("Done in GUI app");
    }

    void animateTitle (JPanel titleCard) {
        Timer timer = new Timer(1000, new ActionListener() {
            int fontSize = 70;
            boolean increasing = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Iterate through each JLabel in the panel
                Component[] components = titleCard.getComponents();
                for (Component component : components) {
                    if (component instanceof JLabel) {
                        JLabel label = (JLabel) component;
                        Font font = label.getFont();
                        // Increase font size from 70 to 90, then decrease back to 70
                        if (increasing) {
                            fontSize = (fontSize < 90) ? fontSize + 20 : fontSize;
                            label.setFont(font.deriveFont((float) fontSize));
                            if (fontSize == 90) {
                                increasing = false;
                            }
                        } else {
                            fontSize = (fontSize > 70) ? fontSize - 20 : fontSize;
                            label.setFont(font.deriveFont((float) fontSize));
                            if (fontSize == 70) {
                                increasing = true;
                            }
                        }
                    }
                    titleCard.setAlignmentX(Component.CENTER_ALIGNMENT);
                }
            }
        });
        timer.start();
    }
    JLabel makeTitleCharacter (String letter) {
        Color blue = new Color(83, 130, 161);
        JLabel newLabel = new JLabel(letter);
        newLabel.setOpaque(false);
        newLabel.repaint();
        newLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70 ));
        newLabel.setForeground(blue);
        return newLabel;
    }



}


