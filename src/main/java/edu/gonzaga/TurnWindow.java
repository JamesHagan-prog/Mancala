package edu.gonzaga;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// import com.github.dnsev.identicon.Identicon;

class TurnWindow {
    Board board = new Board();
    JFrame mainWindowFrame;
    Color orange = new Color(248, 152, 32);
    ImageIcon backgroundImage = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/gonzaga/Images/mancalaBackground.jpg");


    // Player name
    JTextField playerOneNameTextField = new JTextField();
    JTextField playerTwoNameTextField = new JTextField();
    // Buttons for showing dice and checkboxes for meld include/exclude
    ArrayList<JButton> sideA = new ArrayList<>();
    ArrayList<JButton> sideB = new ArrayList<>();
    JButton playerOneBank = new JButton();
    JButton playerTwoBank = new JButton();
    JLabel playerOneScoreLabel = new JLabel();
    JLabel playerTwoScoreLabel = new JLabel();
    JLabel playerNameLabel = new JLabel();
    JLabel helperLabel = new JLabel();

    JPanel playerInfoPanel = new JPanel();
    JPanel mancalaControlPanel = new JPanel();
    JPanel playerTurnPanel = new JPanel();

    StoneImages stoneImages = new StoneImages("media/");



    public static void main(String [] args) {
        TurnWindow app = new TurnWindow();    // Create, then run GUI
        app.runGUI();
    }

    // Constructor for the actual Farkle object
    public TurnWindow() {
        // player = new Player();
        // Create any object you'll need for storing the game:
        // Player, Scorecard, Hand/Dice
    }

    // Sets up the full Swing GUI, but does not do any callback code
    void setupGUI() {
        // Make and configure the window itself
        this.mainWindowFrame = new JFrame("Java Juggernauts Mancala");
        this.mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainWindowFrame.setLocation(100,100);


        this.playerInfoPanel = genPlayerInfoPanel();

        this.mancalaControlPanel = genMancalaControlPanel();

        this.playerTurnPanel = genPlayerTurnPanel();

        mainWindowFrame.getContentPane().add(BorderLayout.NORTH, this.playerInfoPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, this.mancalaControlPanel);
        mainWindowFrame.getContentPane().add(BorderLayout.SOUTH, this.playerTurnPanel);
        mainWindowFrame.pack();
        mainWindowFrame.setLocationRelativeTo(null);
    }

    /**
     * Generates and returns a JPanel containing components for meld control.
     *
     * This method creates a JPanel with a flow layout. It includes components such as a label
     * for meld score, a button to calculate meld, and a label to display the meld score.
     *
     * @return A JPanel containing components for meld control.
     */


    /**
     * Generates and returns a JPanel containing components for dice control.
     *
     * This method creates a JPanel with a black border and a grid layout (3 rows, 7 columns).
     * It includes components such as labels for dice values and meld options, buttons for each
     * dice, and checkboxes for melding. The dice buttons and meld checkboxes are added to
     * corresponding lists for further manipulation.
     *
     * @return A JPanel containing components for dice control.
     */
    private JPanel genMancalaControlPanel() {
        board.setupGame();
        BackgroundPanel newPanel = new BackgroundPanel(System.getProperty("user.dir") + "/src/main/java/edu/gonzaga/Images/mancalaBackground.jpg");
        newPanel.setLayout(new GridLayout(4, 8, 1, 1));

        newPanel.add(new JLabel("Player 2 Side"));
        for(Integer index = 0; index < 6; index++) {
            //JLabel colLabel = new JLabel(index.toString(), SwingConstants.CENTER);
            JLabel colLabel = new JLabel();
            colLabel.setText(String.valueOf(5 - index));
            colLabel.setHorizontalAlignment(SwingConstants.CENTER);
            newPanel.add(colLabel);
        }
        newPanel.add(new JLabel());
        playerTwoBank = new JButton(stoneImages.getStoneImage(board.getScore(1)));
        newPanel.add(playerTwoBank);
        for(Integer index = 0; index < 6; index++) {
            JButton diceStatusButton = new JButton();
            diceStatusButton.setIcon(stoneImages.getStoneImage(board.getBoard()[0][index].getNumStones()));
            this.sideA.add(diceStatusButton);
            newPanel.add(diceStatusButton);
        }

        playerOneScoreLabel = new JLabel();
        playerOneScoreLabel.setText(String.valueOf(board.getScore(1)));
        playerOneScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newPanel.add(playerOneScoreLabel);

        playerTwoScoreLabel = new JLabel();
        playerTwoScoreLabel.setText(String.valueOf(board.getScore(0)));
        playerTwoScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newPanel.add(playerTwoScoreLabel);

        for(Integer index = 0; index < 6; index++) {
            JButton diceStatusButton = new JButton();
            diceStatusButton.setIcon(stoneImages.getStoneImage(board.getBoard()[1][index].getNumStones()));
            this.sideB.add(diceStatusButton);
            newPanel.add(diceStatusButton);
        }
        playerOneBank = new JButton(stoneImages.getStoneImage(board.getScore(1)));
        newPanel.add(playerOneBank);
        newPanel.add(new JLabel());
        for(Integer index = 0; index < 6; index++) {
            //JLabel colLabel = new JLabel(index.toString(), SwingConstants.CENTER);
            JLabel colLabel = new JLabel();
            colLabel.setText(String.valueOf(index + 0));
            colLabel.setHorizontalAlignment(SwingConstants.CENTER);
            newPanel.add(colLabel);
        }
        newPanel.add(new JLabel("Player 1 Side"));
        return newPanel;
    }

    /**
     * Generates and returns a JPanel containing player information components.
     *
     * This method creates a JPanel with a black border and a horizontal flow layout.
     * It includes components such as a JLabel for player name, a JTextField for entering
     * the player name, a JButton for rolling dice, and a debug label for dice information.
     * The player name text field, dice debug label, and roll button are added to the panel
     * with appropriate configurations.
     *
     * @return A JPanel containing components for player information.
     */
    private JPanel genPlayerInfoPanel() {
        JPanel newPanel = new JPanel();
        newPanel.setBackground(orange);
        newPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        newPanel.setLayout(new FlowLayout());    // Left to right

        JLabel playerOneNameLabel = new JLabel("Player 1 name:");
        JLabel playerTwoNameLabel = new JLabel("Player 2 name:");
        playerOneNameTextField.setColumns(20);
        playerTwoNameTextField.setColumns(20);


        newPanel.add(playerOneNameLabel);   // Add our player label
        newPanel.add(playerOneNameTextField); // Add our player text field\
        newPanel.add(playerTwoNameLabel);
        newPanel.add(playerTwoNameTextField);


        return newPanel;
    }
    private JPanel genPlayerTurnPanel() {
        JPanel newPanel = new JPanel();
        newPanel.setBackground(orange);
        newPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        newPanel.setLayout(new FlowLayout());

        JLabel playerTurnLabel = new JLabel("Player turn:");
        playerNameLabel = new JLabel(playerOneNameTextField.getText());
        helperLabel = new JLabel("Select a Box on your side to make your Move");

        newPanel.add(playerTurnLabel);
        newPanel.add(playerNameLabel);
        newPanel.add(helperLabel);

        return newPanel;
    }

    /*
     *  This is a method to show you how you can set/read the visible values
     *   in the various text widgets.
     */
    private void putDemoDefaultValuesInGUI() {
        // Example setting of player name
        this.playerOneNameTextField.setText("Player 1");
        this.playerTwoNameTextField.setText("Player 2");

    }

    private void addDemoButtonCallbackHandlers() {
        sideA.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(5, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideA.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(4, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideA.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(3, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideA.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(2, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideA.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(1, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideA.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(0, 1)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerOneNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(0, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(1, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(2, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(3, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(4, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
        sideB.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.makeMove(5, 0)) {
                    moveEdit();
                    helperLabel.setText("Your Turn Again, make new move");
                    board.displayBoard();
                }
                else {
                    moveEdit();
                    playerNameLabel.setText(playerTwoNameTextField.getText());
                    board.displayBoard();
                }
            }
        });
    }

    /*
     *  Builds the GUI frontend and allows you to hook up the callbacks/data for game
     */
    void runGUI() {
        System.out.println("Starting GUI app");
        setupGUI();

        putDemoDefaultValuesInGUI();
        addDemoButtonCallbackHandlers();

        mainWindowFrame.setVisible(true);
        playerNameLabel.setText(playerOneNameTextField.getText());
        System.out.println("Done in GUI app");
    }

    private void moveEdit() {
        playerOneBank.setIcon(stoneImages.getStoneImage(board.getScore(1)));
        playerOneScoreLabel.setText(String.valueOf(board.getScore(1)));
        playerTwoBank.setIcon(stoneImages.getStoneImage(board.getScore(2)));
        playerTwoScoreLabel.setText(String.valueOf(board.getScore(2)));
        helperLabel.setText("Select a Box on your side to make your Move");

        for (int i = 0; i < 6; i++) {
            sideA.get(i).setIcon(stoneImages.getStoneImage(board.getBoard()[1][5-i].getNumStones()));
            sideB.get(i).setIcon(stoneImages.getStoneImage(board.getBoard()[0][i].getNumStones()));
        }

        if(board.p1HasLost() == true) {
            System.out.println("Game Ended");
            if (board.getScore(1) > board.getScore(2)){
                EndScreen endScreen = new EndScreen(playerOneNameTextField.getText());
                endScreen.runGUI();
            }
            if (board.getScore(2) > board.getScore(1)){
                EndScreen endScreen = new EndScreen(playerTwoNameTextField.getText());
                endScreen.runGUI();
            }
            mainWindowFrame.setVisible(false);

        }
        if(board.p2HasLost() == true) {
            System.out.println("Game Ended");
            if (board.getScore(1)> board.getScore(2)){
                EndScreen endScreen = new EndScreen(playerOneNameTextField.getText());
                endScreen.runGUI();
            }
            if (board.getScore(2) > board.getScore(1)){
                EndScreen endScreen = new EndScreen(playerTwoNameTextField.getText());
                endScreen.runGUI();
            }
            mainWindowFrame.setVisible(false);
        }
    }

}