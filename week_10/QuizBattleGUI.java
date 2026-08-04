import javax.swing.*;
import java.awt.event.*;

public class QuizBattleGUI extends JFrame implements ActionListener {

    // fields to initialize the class, but what else?
    private Questions currentQuestion;

    JLabel lblQuestion;
    JLabel lblResult;

    JButton btn1;
    JButton btn2;

    public QuizBattleGUI() {
        // name appropriate title
        setTitle("Programming Quiz Battle");

        // set the size, find out the suitable size
        setSize(400, 250);

        setLayout(null);

        // by default set to close method
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentQuestion = new Questions(
            "Which keyword creates an object?", "new", "class", "new"
        );

        lblQuestion = new JLabel(currentQuestion.getQuestion());
        lblQuestion.setBounds(20, 20, 320, 30);

        btn1 = new JButton(currentQuestion.getOption1());
        btn1.setBounds(60, 60, 120, 40);
        btn1.addActionListener(this);

        btn2 = new JButton(currentQuestion.getOption2());
        btn2.setBounds(200, 60, 120, 40);
        btn2.addActionListener(this);

        lblResult = new JLabel("Answer the question!");
        lblResult.setBounds(20, 150, 300, 30);

        add(lblQuestion);
        add(btn1);
        add(btn2);
        add(lblResult);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

        if (currentQuestion.isCorrect(clickedButton.getText())) {
            lblResult.setText("Correct! You defeated the Code Boss!");
        } else {
            lblResult.setText("Wrong! Try Again!");
        }
    }

    // the main entry point to open the app, what is it?
    public static void main(String[] args) {
        new QuizBattleGUI(); // to run the app
    }
}