
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GamePanel extends JPanel {

    private static int ROWS = 6, COLS = 12;
    private static final int PIXLE_SIZE = 100;

    private int score = 0;
    private int highScore1 = 0, highScore2 = 0, highScore3 = 0, highScore4 = 0, highScore5 = 0, highScore6 = 0;
    private Timer timer;
    private int timeSeconds = 0;
    private ImageIcon zapanta;
    private ImageIcon michael;
    private ImageIcon masroor; 
    private JButton newTargetButton1;
    private JButton newTargetButton2;
    private JButton newTargetButton3;
    private JButton newTargetButtonMasroor;
    public int randRowMasroor;
    public int randColMasroor;
    public int randCol1, randCol2, randCol3, randRow1, randRow2, randRow3;

    //Creates a document for high scores of each level, creates images, calls the main menu
    public GamePanel() {
        createmonoPantaMedium();
        ceatemonoPantaHard();
        createmazPanta();
        createmazPantaHard();
        createtriPanta();
        createtriPantaHard();
        michael = new ImageIcon("Michael.jpg");
        zapanta = new ImageIcon("Zapanta1.jpg");
        masroor = new ImageIcon("Masroor.jpg");

        mainMenu();

    }

    //Creates a main menu using a gridbag layout which displays buttons for each level, button for instructions, and highscores
    public final void mainMenu() {

        removeAll();
        revalidate();
        repaint();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;

        JButton ZapantaFace1 = new JButton(zapanta);
        ZapantaFace1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZapantaFace1.setIcon(michael);
            }
        });
        add(ZapantaFace1, c);

        JButton ZapantaFace2 = new JButton(zapanta);
        ZapantaFace2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZapantaFace2.setIcon(michael);
            }
        });
        c.gridx = 2;
        add(ZapantaFace2, c);
        JButton InstructionsButton = new JButton("Help");
        InstructionsButton.setFont(new Font("Arial", Font.PLAIN, 200));
        InstructionsButton.setBackground(Color.blue);
        InstructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Instructions();
            }
        });
        c.gridx = 1;

        add(InstructionsButton, c);
        c.gridy = 1;

        JLabel PlaceHolder1 = new JLabel(" ");
        PlaceHolder1.setFont(new Font("Arial", Font.PLAIN, 50));
        add(PlaceHolder1, c);

        c.gridy = 2;

        JButton MonoPantaButton = new JButton("MonoPanta");
        MonoPantaButton.setFont(new Font("Arial", Font.PLAIN, 50));
        MonoPantaButton.setBackground(Color.YELLOW);
        MonoPantaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ROWS = 6;
                COLS = 12;
                monoPantaMedium();
            }
        });

        c.gridx = 0;
        add(MonoPantaButton, c);

        JButton MonoPantaHardButton = new JButton("MonoPanta Hard");
        MonoPantaHardButton.setFont(new Font("Arial", Font.PLAIN, 50));
        MonoPantaHardButton.setBackground(Color.RED);
        MonoPantaHardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ROWS = 12;
                COLS = 20;
                monoPantaMedium();
            }
        });
        c.gridx = 2;
        add(MonoPantaHardButton, c);

        c.gridy = 3;

        ReadmonoPantaMedium();
        JLabel MonoPantaHighScore = new JLabel();
        if (highScore1 < 20) {
            MonoPantaHighScore.setText("<html>High Score: " + highScore1 + "<br/>Score Required For Stars: 20 </html>");
        } else {
            MonoPantaHighScore.setText("<html>High Score: " + highScore1 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        MonoPantaHighScore.setForeground(Color.WHITE);
        c.gridx = 0;
        add(MonoPantaHighScore, c);
        ReadmonoPantaHard();
        JLabel MonoPantaHardHighScore = new JLabel();
        if (highScore2 < 17) {
            MonoPantaHardHighScore.setText("<html>High Score: " + highScore2 + "<br/>Score Required For Stars: 17 </html>");
        } else {
            MonoPantaHardHighScore.setText("<html>High Score: " + highScore2 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        MonoPantaHardHighScore.setForeground(Color.WHITE);
        c.gridx = 2;
        add(MonoPantaHardHighScore, c);

        c.gridy = 4;
        JLabel PlaceHolder2 = new JLabel(" ");
        PlaceHolder2.setFont(new Font("Arial", Font.PLAIN, 50));
        add(PlaceHolder2, c);
        c.gridy = 5;
        JButton MazPantaButton = new JButton(" MazPanta ");
        MazPantaButton.setFont(new Font("Arial", Font.PLAIN, 50));
        MazPantaButton.setBackground(Color.yellow);
        MazPantaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ROWS = 6;
                COLS = 12;
                mazPanta();
            }
        });
        c.gridx = 0;

        add(MazPantaButton, c);

        JButton MazPantaHardButton = new JButton(" MazPanta  Hard ");
        MazPantaHardButton.setFont(new Font("Arial", Font.PLAIN, 50));
        MazPantaHardButton.setBackground(Color.RED);
        MazPantaHardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ROWS = 12;
                COLS = 20;
                mazPanta();
            }
        });
        c.gridx = 2;

        add(MazPantaHardButton, c);

        c.gridy = 6;
        ReadmazPanta();
        JLabel MazPantaHighScore = new JLabel();
        if (highScore3 < 17) {
            MazPantaHighScore.setForeground(Color.white);
            MazPantaHighScore.setText("<html>High Score: " + highScore3 + "<br/>Score Required For Stars: 17 </html>");
        } else {
            MazPantaHighScore.setForeground(Color.white);
            MazPantaHighScore.setText("<html>High Score: " + highScore3 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        c.gridx = 0;
        add(MazPantaHighScore, c);
        ReadmazPantaHard();
        JLabel MazPantaHardHighScore = new JLabel();
        if (highScore6 < 15) {
            MazPantaHardHighScore.setText("<html>High Score: " + highScore6 + "<br/>Score Required For Stars: 15 </html>");
        } else {
            MazPantaHardHighScore.setText("<html>High Score: " + highScore6 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        MazPantaHardHighScore.setForeground(Color.WHITE);
        c.gridx = 2;
        add(MazPantaHardHighScore, c);

        c.gridy = 7;

        JLabel PlaceHolder3 = new JLabel(" ");
        PlaceHolder3.setFont(new Font("Arial", Font.PLAIN, 50));
        add(PlaceHolder3, c);
        c.gridy = 8;
        JButton TriPantaButton = new JButton("  TriPanta  ");
        TriPantaButton.setFont(new Font("Arial", Font.PLAIN, 50));
        TriPantaButton.setBackground(Color.yellow);
        TriPantaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ROWS = 6;
                COLS = 12;
                triplePanta();
            }
        });
        c.gridx = 0;

        add(TriPantaButton, c);
        JButton TriPantaHardButton = new JButton("  TriPanta  Hard  ");
        TriPantaHardButton.setFont(new Font("Arial", Font.PLAIN, 50));
        TriPantaHardButton.setBackground(Color.red);
        TriPantaHardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ROWS = 12;
                COLS = 20;

                triplePanta();
            }
        });
        c.gridx = 2;

        add(TriPantaHardButton, c);

        c.gridy = 9;
        ReadtriPanta();
        JLabel TriPantaHighScore = new JLabel();
        if (highScore4 < 30) {
            TriPantaHighScore.setText("<html>High Score: " + highScore4 + "<br/>Score Required For Stars: 30 </html>");
        } else {
            TriPantaHighScore.setText("<html>High Score: " + highScore4 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        TriPantaHighScore.setForeground(Color.WHITE);
        c.gridx = 0;
        add(TriPantaHighScore, c);
        ReadtriPantaHard();
        JLabel TriPantaHardHighScore = new JLabel();
        if (highScore5 < 25) {
            TriPantaHardHighScore.setText("<html>High Score: " + highScore5 + "<br/>Score Required For Stars: 25 </html>");
        } else {
            TriPantaHardHighScore.setText("<html>High Score: " + highScore5 + "<br> <span style=\\\"font-family:Arial;font-size:30px;\\\">⭐⭐⭐</html></html>");
        }
        TriPantaHardHighScore.setForeground(Color.WHITE);
        c.gridx = 2;
        add(TriPantaHardHighScore, c);

    }

    //Creates the level using a grid layout with one zapanta button, everytime you click the button your score goes up by 1, and a new grid is created with the button in a different spot.
    //Level ends and high score is recorded after 15 seconds, after displaying your final score 3 seconds the main menu is called again.
    public void monoPantaMedium() {
        removeAll();
        revalidate();
        repaint();
        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
        zapanta = new ImageIcon("Zapanta1.jpg");
        newTargetButton1 = new JButton(zapanta);
        JLabel timerLabel = new JLabel(String.valueOf(timeSeconds));

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeSeconds++;
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));

                if (timeSeconds == 16) {
                    System.out.println("COLS" + COLS);
                    if (COLS == 20) {
                        ceatemonoPantaHard();
                        ReadmonoPantaHard();
                    } else {
                        createmonoPantaMedium();
                        ReadmonoPantaMedium();
                    }

                    for (ActionListener listener : newTargetButton1.getActionListeners()) {
                        newTargetButton1.removeActionListener(listener);
                    }
                    removeAll();
                    revalidate();
                    repaint();
                    setLayout(new GridLayout(1, 1));
                    JLabel finalScreen = new JLabel("FINAL SCORE: " + String.valueOf(score), SwingConstants.CENTER);
                    finalScreen.setFont(new Font("Serif", Font.BOLD, 125));
                    add(finalScreen);

                }
                if (timeSeconds == 19) {
                    //Compare score to old high score on a document, if its higher, replace it
                    timer.stop();
                    timeSeconds = 0;
                    score = 0;
                    mainMenu();
                }
            }

        });

        timer.start();
        setBackground(Color.RED);
        setLayout(new GridLayout(ROWS, COLS));

        int randRow = (int) (Math.random() * ROWS - 1);
        int randCol = (int) (Math.random() * COLS);

        JLabel label = new JLabel("Score: " + String.valueOf(score));

        for (int i = 0; i < COLS - 2; i++) {
            if (i == COLS / 3) {
                label.setFont(new Font("Serif", Font.BOLD, 20));
                add(label);

            } else if (i == ((2 * COLS)) / 3) {
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                add(timerLabel);
                add(new JLabel(""));
                add(new JLabel(""));

            } else {
                add(new JLabel(""));
            }
        }

        for (int r = 0; r < ROWS - 1; r++) {
            for (int c = 0; c < COLS; c++) {
                if (c == randCol && r == randRow) {
                    newTargetButton1.setBackground(Color.RED);
                    newTargetButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score++;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            int randRow = (int) (Math.random() * ROWS - 1);
                            int randCol = (int) (Math.random() * COLS);
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol && r == randRow) {

                                        add(newTargetButton1);
                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButton1);
                } else {
                    JButton newNormalButton = new JButton("");
                    newNormalButton.setBackground(Color.BLACK);

                    add(newNormalButton);

                }

            }

        }

        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
    }

    //Creates the level using a grid layout with one zapanta button and one masroor button, everytime you click the zapanta button your score goes up by 1 and everytime you click the masroor button your score goes down by 1, every time a button is pressed a new grid is created with the button in a different spot.
    //Level ends and high score is recorded after 15 seconds, after displaying your final score 3 seconds the main menu is called again.
    public void mazPanta() {
        removeAll();
        revalidate();
        repaint();
        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
        zapanta = new ImageIcon("Zapanta1.jpg");
        masroor = new ImageIcon("Masroor.jpg");
        newTargetButton1 = new JButton(zapanta);
        newTargetButtonMasroor = new JButton(masroor);
        JLabel timerLabel = new JLabel(String.valueOf(timeSeconds));

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeSeconds++;
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));

                if (timeSeconds == 16) {
                    if (COLS == 20) {
                        createmazPantaHard();
                        ReadmazPantaHard();
                    } else {
                        createmazPanta();
                        ReadmazPanta();
                    }
                    for (ActionListener listener : newTargetButton1.getActionListeners()) {
                        newTargetButton1.removeActionListener(listener);
                    }
                    for (ActionListener listener : newTargetButtonMasroor.getActionListeners()) {
                        newTargetButtonMasroor.removeActionListener(listener);
                    }
                    removeAll();
                    revalidate();
                    repaint();
                    setLayout(new GridLayout(1, 1));
                    JLabel finalScreen = new JLabel("FINAL SCORE: " + String.valueOf(score), SwingConstants.CENTER);
                    finalScreen.setFont(new Font("Serif", Font.BOLD, 125));
                    add(finalScreen);

                }
                if (timeSeconds == 19) {
                    //Compare score to old high score on a document, if its higher, replace it
                    timer.stop();
                    timeSeconds = 0;
                    score = 0;
                    mainMenu();
                }
            }

        });

        timer.start();
        setBackground(Color.RED);
        setLayout(new GridLayout(ROWS, COLS));

        int randRow = (int) (Math.random() * ROWS - 1);
        int randCol = (int) (Math.random() * COLS);

        while (randCol == randColMasroor && randRow == randRowMasroor) {
            randRowMasroor = (int) (Math.random() * ROWS - 1);
            randColMasroor = (int) (Math.random() * COLS);
        }
        JLabel label = new JLabel("Score: " + String.valueOf(score));

        for (int i = 0; i < COLS - 2; i++) {
            if (i == COLS / 3) {
                label.setFont(new Font("Serif", Font.BOLD, 20));
                add(label);

            } else if (i == ((2 * COLS)) / 3) {
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                add(timerLabel);
                add(new JLabel(""));
                add(new JLabel(""));

            } else {
                add(new JLabel(""));
            }
        }
        for (int r = 0; r < ROWS - 1; r++) {
            for (int c = 0; c < COLS; c++) {
                if (c == randCol && r == randRow) {
                    newTargetButton1.setBackground(Color.RED);
                    newTargetButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score++;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            int randRow = (int) (Math.random() * ROWS - 1);
                            int randCol = (int) (Math.random() * COLS);
                            int randRowMasroor = (int) (Math.random() * ROWS - 1);
                            int randColMasroor = (int) (Math.random() * COLS);
                            while (randCol == randColMasroor && randRow == randRowMasroor) {
                                randRow = (int) (Math.random() * ROWS - 1);
                                randCol = (int) (Math.random() * COLS);
                            }
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol && r == randRow) {

                                        add(newTargetButton1);
                                    } else if (c == randColMasroor && r == randRowMasroor) {
                                        add(newTargetButtonMasroor);
                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButton1);

                } else if (c == randColMasroor && r == randRowMasroor) {
                    newTargetButtonMasroor.setBackground(Color.RED);
                    newTargetButtonMasroor.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score--;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            int randRow = (int) (Math.random() * ROWS - 1);
                            int randCol = (int) (Math.random() * COLS);
                            int randRowMasroor = (int) (Math.random() * ROWS - 1);
                            int randColMasroor = (int) (Math.random() * COLS);
                            while (randCol == randColMasroor && randRow == randRowMasroor) {
                                randRowMasroor = (int) (Math.random() * ROWS - 1);
                                randColMasroor = (int) (Math.random() * COLS);
                            }
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol && r == randRow) {

                                        add(newTargetButton1);
                                    } else if (c == randColMasroor && r == randRowMasroor) {
                                        add(newTargetButtonMasroor);
                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButtonMasroor);
                } else {
                    JButton newNormalButton = new JButton("");
                    newNormalButton.setBackground(Color.BLACK);

                    add(newNormalButton);

                }

            }

        }

        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
    }

    
    //Creates the level using a grid layout with three zapanta buttons, everytime you click a zapanta button your score goes up by 1, and a new grid is created with the button pressed in a new place, while 2 more stay in the same place
    //Level ends and high score is recorded after 15 seconds, after displaying your final score 3 seconds the main menu is called again
    public void triplePanta() {
        removeAll();
        revalidate();
        repaint();
        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
        zapanta = new ImageIcon("Zapanta1.jpg");
        newTargetButton1 = new JButton(zapanta);
        newTargetButton2 = new JButton(zapanta);
        newTargetButton3 = new JButton(zapanta);

        JLabel timerLabel = new JLabel(String.valueOf(timeSeconds));

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeSeconds++;
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));

                if (timeSeconds == 16) {

                    if (COLS == 20) {
                        createtriPantaHard();
                        ReadtriPantaHard();
                    } else {
                        createtriPanta();
                        ReadtriPanta();
                    }

                    for (ActionListener listener : newTargetButton1.getActionListeners()) {
                        newTargetButton1.removeActionListener(listener);
                    }
                    for (ActionListener listener : newTargetButton2.getActionListeners()) {
                        newTargetButton2.removeActionListener(listener);
                    }
                    for (ActionListener listener : newTargetButton3.getActionListeners()) {
                        newTargetButton3.removeActionListener(listener);
                    }
                    removeAll();
                    revalidate();
                    repaint();
                    setLayout(new GridLayout(1, 1));
                    JLabel finalScreen = new JLabel("FINAL SCORE: " + String.valueOf(score), SwingConstants.CENTER);
                    finalScreen.setFont(new Font("Serif", Font.BOLD, 125));
                    add(finalScreen);

                }
                if (timeSeconds == 19) {
                    //Compare score to old high score on a document, if its higher, replace it
                    if (score < highScore1) {

                    }
                    timer.stop();

                    timeSeconds = 0;
                    score = 0;
                    mainMenu();
                }
            }

        });

        timer.start();
        setBackground(Color.RED);
        setLayout(new GridLayout(ROWS, COLS));

        randRow1 = (int) (Math.random() * ROWS - 1);
        randCol1 = (int) (Math.random() * COLS);
        randRow2 = (int) (Math.random() * ROWS - 1);
        randCol2 = (int) (Math.random() * COLS);
        randRow3 = (int) (Math.random() * ROWS - 1);
        randCol3 = (int) (Math.random() * COLS);

        while ((randCol1 == randCol2 && randRow1 == randRow2) || (randCol1 == randCol3 && randRow1 == randRow3) || (randCol3 == randCol2 && randRow3 == randRow2)) {
            randRow1 = (int) (Math.random() * ROWS - 1);
            randCol1 = (int) (Math.random() * COLS);
            randRow2 = (int) (Math.random() * ROWS - 1);
            randCol2 = (int) (Math.random() * COLS);
        }
        JLabel label = new JLabel("Score: " + String.valueOf(score));

        for (int i = 0; i < COLS - 2; i++) {
            if (i == COLS / 3) {
                label.setFont(new Font("Serif", Font.BOLD, 20));
                add(label);

            } else if (i == ((2 * COLS)) / 3) {
                timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                add(timerLabel);
                add(new JLabel(""));
                add(new JLabel(""));

            } else {
                add(new JLabel(""));
            }
        }

        for (int r = 0; r < ROWS - 1; r++) {
            for (int c = 0; c < COLS; c++) {
                if (c == randCol1 && r == randRow1) {
                    newTargetButton1.setBackground(Color.RED);
                    newTargetButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score++;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            randRow1 = (int) (Math.random() * ROWS - 1);
                            randCol1 = (int) (Math.random() * COLS);
                            while ((randCol1 == randCol2 && randRow1 == randRow2) || (randCol1 == randCol3 && randRow1 == randRow3) || (randCol3 == randCol2 && randRow3 == randRow2)) {
                                randRow1 = (int) (Math.random() * ROWS - 1);
                                randCol1 = (int) (Math.random() * COLS);
                            }
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol1 && r == randRow1) {

                                        add(newTargetButton1);
                                    } else if (c == randCol2 && r == randRow2) {
                                        add(newTargetButton2);
                                    } else if (c == randCol3 && r == randRow3) {
                                        add(newTargetButton3);

                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButton1);

                } else if (c == randCol2 && r == randRow2) {
                    newTargetButton2.setBackground(Color.RED);
                    newTargetButton2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score++;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            randRow2 = (int) (Math.random() * ROWS - 1);
                            randCol2 = (int) (Math.random() * COLS);
                            while ((randCol1 == randCol2 && randRow1 == randRow2) || (randCol1 == randCol3 && randRow1 == randRow3) || (randCol3 == randCol2 && randRow3 == randRow2)) {
                                randRow2 = (int) (Math.random() * ROWS - 1);
                                randCol2 = (int) (Math.random() * COLS);
                            }
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol1 && r == randRow1) {

                                        add(newTargetButton1);
                                    } else if (c == randCol2 && r == randRow2) {
                                        add(newTargetButton2);
                                    } else if (c == randCol3 && r == randRow3) {
                                        add(newTargetButton3);

                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButton2);
                } else if (c == randCol3 && r == randRow3) {
                    newTargetButton3.setBackground(Color.RED);
                    newTargetButton3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            score++;
                            label.setText(String.valueOf(score));

                            removeAll();
                            revalidate();
                            repaint();
                            JLabel label = new JLabel("Score: " + String.valueOf(score));
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            add(label);
                            for (int i = 0; i < COLS - 2; i++) {
                                if (i == COLS / 3) {
                                    label.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(label);

                                } else if (i == ((2 * COLS)) / 3) {
                                    timerLabel.setText("Time: " + String.valueOf(timeSeconds));
                                    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                    add(timerLabel);
                                    add(new JLabel(""));
                                    add(new JLabel(""));

                                } else {
                                    add(new JLabel(""));
                                }
                            }
                            randRow3 = (int) (Math.random() * ROWS - 1);
                            randCol3 = (int) (Math.random() * COLS);
                            while ((randCol1 == randCol2 && randRow1 == randRow2) || (randCol1 == randCol3 && randRow1 == randRow3) || (randCol3 == randCol2 && randRow3 == randRow2)) {
                                randRow3 = (int) (Math.random() * ROWS - 1);
                                randCol3 = (int) (Math.random() * COLS);
                            }
                            for (int r = 0; r < ROWS - 1; r++) {
                                for (int c = 0; c < COLS; c++) {
                                    if (c == randCol1 && r == randRow1) {

                                        add(newTargetButton1);
                                    } else if (c == randCol2 && r == randRow2) {
                                        add(newTargetButton2);
                                    } else if (c == randCol3 && r == randRow3) {
                                        add(newTargetButton3);

                                    } else {
                                        JButton newNormalButton = new JButton("");
                                        newNormalButton.setBackground(Color.BLACK);

                                        add(newNormalButton);

                                    }

                                }

                            }

                            setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));

                        }
                    });

                    add(newTargetButton3);
                } else {
                    JButton newNormalButton = new JButton("");
                    newNormalButton.setBackground(Color.BLACK);

                    add(newNormalButton);

                }

            }

        }

        setPreferredSize(new Dimension(ROWS * PIXLE_SIZE, COLS * PIXLE_SIZE));
    }

    //Creates text file for monoPantaMedium
    public final void createmonoPantaMedium() {
        try {
            File myObj = new File("monoPantaMedium.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Creates text file for monoPantaHard
    public final void ceatemonoPantaHard() {
        try {
            File myObj = new File("monoPantaHard.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Creates text file for mazPanta
    public final void createmazPanta() {
        try {
            File myObj = new File("mazPanta.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Creates text file for triPanta
    public final void createtriPanta() {
        try {
            File myObj = new File("triPanta.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Creates text file for mazPantaHard
    public final void createmazPantaHard() {
        try {
            File myObj = new File("mazPantaHard.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Creates texxt file for triPantaHard
    public final void createtriPantaHard() {
        try {
            File myObj = new File("triPantaHard.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score for monoPantaMedium
    public void Writelevel1() {
        try {
            FileWriter myWriter = new FileWriter("monoPantaMedium.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score for monoPantaHard
    public void Writelevel2() {
        try {
            FileWriter myWriter = new FileWriter("monoPantaHard.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score mazPantaHard
    public void Writelevel3() {
        try {
            FileWriter myWriter = new FileWriter("mazPanta.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score for triPanta
    public void Writelevel4() {
        try {
            FileWriter myWriter = new FileWriter("triPanta.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score for triPantaHard
    public void Writelevel5() {
        try {
            FileWriter myWriter = new FileWriter("triPantaHard.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Replaces the score for mazPantaHard
    public void Writelevel6() {
        try {
            FileWriter myWriter = new FileWriter("mazPantaHard.txt");
            myWriter.write(String.valueOf(score));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadmonoPantaMedium() {
        int oldScore = 0;
        try {

            File myObj = new File("monoPantaMedium.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore1 = score;
                createmonoPantaMedium();
                Writelevel1();
            } else if (score == 0) {
                highScore1 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadmonoPantaHard() {
        int oldScore = 0;
        try {

            File myObj = new File("monoPantaHard.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore2 = score;
                ceatemonoPantaHard();
                Writelevel2();
            } else if (score == 0) {
                highScore2 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadtriPanta() {
        int oldScore = 0;
        try {

            File myObj = new File("triPanta.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore4 = score;
                ceatemonoPantaHard();
                Writelevel4();
            } else if (score == 0) {
                highScore4 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadmazPanta() {
        int oldScore = 0;
        try {

            File myObj = new File("mazPanta.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore3 = score;
                ceatemonoPantaHard();
                Writelevel3();
            } else if (score == 0) {
                highScore3 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadtriPantaHard() {
        int oldScore = 0;
        try {

            File myObj = new File("triPantaHard.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore5 = score;
                ceatemonoPantaHard();
                Writelevel5();
            } else if (score == 0) {
                highScore5 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //Compares the score achieved in the level to the highscore, if its differrent it calls the corrasponding method to replace the high score.
    public void ReadmazPantaHard() {
        int oldScore = 0;
        try {

            File myObj = new File("mazPantaHard.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldScore = Integer.parseInt(data);

            }

            myReader.close();
            if (oldScore < score) {
                highScore6 = score;
                ceatemonoPantaHard();
                Writelevel6();
            } else if (score == 0) {
                highScore6 = oldScore;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Uses a grid layout to create and instructions sheet with a button to go back to the main menu.
    public void Instructions() {
        removeAll();
        revalidate();
        repaint();
        setBackground(Color.BLACK);
        setLayout(new GridLayout(3, 2));

        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);

        label.setText("            Click the image of Zapanta as much times as possible in 15 seconds in each level.");
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);

        JButton ZapantaFace = new JButton("<-----This is what Zapanta looks like", zapanta);
        ZapantaFace.setFont(new Font("Serif", Font.BOLD, 25));
        ZapantaFace.setBackground(Color.RED);
        add(ZapantaFace);

        JLabel label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setText("            If you see an image of Masroor you must avoid clicking him.");
        label2.setFont(new Font("Serif", Font.BOLD, 25));
        add(label2);

        JButton MasroorFace = new JButton("<-----This is what Masroor looks like", masroor);
        MasroorFace.setBackground(Color.RED);
        MasroorFace.setFont(new Font("Serif", Font.BOLD, 25));
        add(MasroorFace);

        JLabel label3 = new JLabel();
        label3.setForeground(Color.WHITE);

        label3.setText("            You can get stars on a level by reaching a certain score found in the menu.");
        label3.setFont(new Font("Serif", Font.BOLD, 25));

        add(label3);

        JButton MainMenuButton2 = new JButton("Main Menu");
        MainMenuButton2.setFont(new Font("Arial", Font.PLAIN, 100));
        MainMenuButton2.setBackground(Color.RED);
        MainMenuButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });

        add(MainMenuButton2);

    }

}
