package geekbrains.lesson8;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private final GameField gameField;
    private int value1;
    private static final JTextArea textArea = new JTextArea();
    private Graphics g;

    public static void addText(String str){
        textArea.append(str);
    }

    public MainForm() {
        this.setTitle("Guess the number");
        this.setBounds(500, 300, 800, 440);
       // this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.gameField = new GameField();
        this.add(gameField);
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        Button btnStart = new Button("Start New Game");
        Button btnExit = new Button("Exit Game");
        bottomPanel.add(btnStart);
        bottomPanel.add(btnExit);
        bottomPanel.setPreferredSize(new Dimension(1, 40));
        this.add(bottomPanel, BorderLayout.SOUTH);

        btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnStart.setBackground(Color.WHITE);
        btnExit.setBackground(Color.WHITE);


        JScrollPane jsp = new JScrollPane(textArea);
        this.add(jsp, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(1, 10, 5, 0));
        this.add(southPanel, BorderLayout.NORTH);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            southPanel.add(button);

            final int index = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    value1 = index;
                    textArea.append(String.valueOf(index) + '\n');
                    gameField.setNum(index);
                    if (!gameField.checkAnswer()) {
                        if (gameField.getTries() == 0) {
                            gameField.setGameOn(false);
                        } else {
                            gameField.setTries(gameField.getTries() - 1);
                        }
                        if (!gameField.isGameOn()) {
                            textArea.append("GAME OVER"+ '\n');
                        }
                    }
                }
            });
        }


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameField.startGame();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }
}
