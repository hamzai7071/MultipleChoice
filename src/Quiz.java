import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//The listener interface for receiving action events
public class Quiz implements ActionListener {

    //Creating Array that will holds all the answers.
    String[] question = {

            "Which counrtry created java? ",
            "Which year was Java created? ",
            "What was java originally called? ",
            "Who is credited with creating Java? "
    };

    //we also add the 2D array that holds .
    String[][] options = {
            {"Sun Microsystem", "Starbuks", "Alphabets", "Oracle"},
            {"1989", "1996", "1992", "1988"},
            {"Apple", "Latte", "Oak", "Koffing"},
            {"Steve jobs", "Bill Gates", "James Gosling", "Mark"}
    };

    //This array will hold all the character, For example, A,B,C,D
    char[] answers = {
            'A',
            'B',
            'c',
            'c'
    };

    //Now we will initialize the variables to use in the methods and classes.
    char guess; //Its going to hold the guess number
    char answer; //This will hold the answers
    char index;  //We will also need the Index  and this will be added in the nextQuestion method.
    char correct_guessues = 0;  //We will need int value to hold the guesses number
    int total_questions = question.length;   // this will be added in the nextQuestion method.
    /* This will tell the total question. For example,
    whatever the question, we will hold, will tells us how many total questions we have which means
    will give the whole length of it */
    int result;  // This will hold the result
    int seconds = 10; //this is the Timer but we can adjust the time later too.


    //Now before constructore, we can make the GUI which has JFrame options.
//This is pre-defined Object that can make the frame
    JFrame frame = new JFrame();

    JTextField textfield = new JTextField(); //This will hold the current question that we are on.
    JTextArea textarea = new JTextArea(); //This will hold the print question.

    JButton buttonA = new JButton();  // Creating the button
    JButton buttonB = new JButton();  // Creating the button
    JButton buttonC = new JButton();  // Creating the button
    JButton buttonD = new JButton();  // Creating the button

    JLabel answer_labelA = new JLabel(); //Label will hold different answers.
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();

    JLabel time_label = new JLabel(); //It will display the word timer;
    JLabel second_left = new JLabel(); //This will create the count-down timer;
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField(); // This will give percentage.

    Timer timer = new Timer(1000, new ActionListener() {   //excuting at two seconds


        // @Override
        public void actionPerformed(ActionEvent e) {
            second--;
            second_left.setText(String.valueOf(seconds));
            if (s econd <= 0) {
                displayAnswer();
            }
        }


        //Need constructor
        public Quiz() {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(650, 650); //size of the page.
            frame.getContentPane().setBackground(new Color(100, 100, 100)); //Changing the color
            frame.setLayout(null); //It will size by itself.
            frame.setResizable(false); //Nobody will change the size

            textfield.setBounds(0, 0, 650, 50); // It will show the text size and where it can be located.
            textfield.setBackground(new Color(25, 25, 25)); //This will set the color.
            textfield.setForeground(new Color(25, 255, 0)); //Font color
            textfield.setFont(new Font("Ink Free", Font.BOLD, 30)); //Font shape
            textfield.setBorder(BorderFactory.createBevelBorder(1)); //border design
            textfield.setHorizontalAlignment(JTextField.CENTER);
            textfield.setEditable(false); // People wont be able to edit.
            textfield.setText("Testing");

            textarea.setBounds(0, 50, 650, 50); // It will show the text size and where it can be located.
            textarea.setLineWrap(true); // if the text goes off the screen, would proceed.
            textarea.setWrapStyleWord(true);
            textarea.setBackground(new Color(25, 25, 25)); //This will set the color.
            textarea.setForeground(new Color(25, 255, 0)); //Font color
            textarea.setFont(new Font("DialogInput", Font.BOLD, 25)); //Font shape
            textarea.setBorder(BorderFactory.createBevelBorder(1)); //border design
            textarea.setEditable(false); // People wont be able to edit.
            textarea.setText("Testing");

            buttonA.setBounds(0, 100, 100, 100);
            buttonA.setFont(new Font("DialogInput", Font.BOLD, 35));
            buttonA.addActionListener(this);
            buttonA.setFocusable(false);
            buttonA.setText("A");

            buttonB.setBounds(0, 200, 100, 100);
            buttonB.setFont(new Font("DialogInput", Font.BOLD, 35));
            buttonB.addActionListener(this);
            buttonB.setFocusable(false);
            buttonB.setText("B");

            buttonC.setBounds(0, 300, 100, 100);
            buttonC.setFont(new Font("DialogInput", Font.BOLD, 35));
            buttonC.addActionListener(this);
            buttonC.setFocusable(false);
            buttonC.setText("C");

            buttonD.setBounds(0, 400, 100, 100);
            buttonD.setFont(new Font("DialogInput", Font.BOLD, 35));
            buttonD.addActionListener(this);
            buttonD.setFocusable(false);
            buttonD.setText("D");

            answer_labelA.setBounds(123, 100, 500, 100); //Answer display
            answer_labelA.setBackground(new Color(30, 30, 30));
            answer_labelA.setForeground(new Color(25, 225, 0));
            answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
            answer_labelA.setText("Answer 1");

            answer_labelB.setBounds(123, 200, 500, 100); //Answer display
            answer_labelB.setBackground(new Color(30, 30, 30));
            answer_labelB.setForeground(new Color(25, 225, 0));
            answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
            answer_labelB.setText("Answer 2");

            answer_labelC.setBounds(123, 300, 500, 100); //Answer display
            answer_labelC.setBackground(new Color(30, 30, 30));
            answer_labelC.setForeground(new Color(25, 225, 0));
            answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
            answer_labelC.setText("Answer 3");

            answer_labelD.setBounds(123, 400, 500, 100); //Answer display
            answer_labelD.setBackground(new Color(30, 30, 30));
            answer_labelD.setForeground(new Color(25, 225, 0));
            answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

            second_left.setBounds(555, 510, 100, 100);
            second_left.setBackground(new Color(25, 25, 25));
            second_left.setForeground(new Color(255, 0, 0));
            second_left.setFont(new Font("Int Free", Font.BOLD, 60));
            second_left.setBorder(BorderFactory.createBevelBorder(1));
            second_left.setOpaque(true);
            second_left.setHorizontalAlignment(JTextField.CENTER);
            second_left.setText(String.valueOf(seconds));

            time_label.setBounds(535, 475, 100, 25);
            time_label.setBackground(new Color(50, 50, 50));
            time_label.setForeground(new Color(255, 0, 0));
            time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
            time_label.setText("Time >:D");

            number_right.setBounds(225, 225, 200, 100);
            number_right.setBackground(new Color(25, 25, 25));
            number_right.setForeground(new Color(25, 255, 0));
            number_right.setFont(new Font("Int Free", Font.BOLD, 50));
            number_right.setBorder(BorderFactory.createBevelBorder(1));
            number_right.setHorizontalAlignment(JTextField.CENTER);
            number_right.setEditable(false);

            percentage.setBounds(225, 325, 200, 100);
            percentage.setBackground(new Color(25, 25, 25));
            percentage.setForeground(new Color(25, 255, 0));
            percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
            percentage.setBorder(BorderFactory.createBevelBorder(1));
            percentage.setHorizontalAlignment(JTextField.CENTER);
            percentage.setEditable(false);




/*frame.add(number_right);
frame.add(percentage);*/
            frame.add(time_label);
            frame.add(answer_labelA);
            frame.add(answer_labelB);
            frame.add(answer_labelC);
            frame.add(answer_labelD);

            frame.add(second_left);
            frame.add(buttonA);
            frame.add(buttonB);
            frame.add(buttonC);
            frame.add(buttonD);

            frame.add(textarea);
            frame.add(textfield);
            frame.setVisible(true); //visibility


//Now we are going to call the nextQuestion method to begin the quiz
            nextQuestion();
        }


        //Need method to go to the next question
        public void nextQuestion() {
            if (index >= total_questions) {  //Checking which number we on is greater or equal to index.

                results();
            } else {
                textfield.setText("question " + (index + 1));  //This will increase the question to next one
                textarea.setText(question[index]); //This array will ask the question
                answer_labelA.setText(options[index][0]);
                answer_labelB.setText(options[index][1]);
                answer_labelC.setText(options[index][2]);
                answer_labelD.setText(options[index][3]);
                timer.start();


            }
        }

        @Override
        //This is the part of the ActionListener class and anything relates to the button, will go in this method.

        public void actionPerformed(ActionEvent e) {  //This will take an action when someone type click the button
            buttonA.setEnabled(false);    //False will disabled the button but we are doing for temporary.
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            if (e.getSource() == buttonA) {
                answer = 'A';
                if (answer == answers[index]) {
                    correct_guessues++;

                }
            }
            if (e.getSource() == buttonB) {
                answer = 'B';
                if (answer == answers[index]) {
                    correct_guessues++;

                }
            }
            if (e.getSource() == buttonC) {
                answer = 'C';
                if (answer == answers[index]) {
                    correct_guessues++;

                }
            }
            if (e.getSource() == buttonD) {
                answer = 'D';
                if (answer == answers[index]) {
                    correct_guessues++;

                }
            }
            displayAnswer();
        }

        //THis method will show the correct answer
        public void displayAnswer() {

            timer.stop();
            buttonA.setEnabled(false);    //display the button
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            if (answers[index] != 'A')
                answer_labelA.setForeground(new Color(255, 0, 0));

            if (answers[index] != 'B')
                answer_labelB.setForeground(new Color(255, 0, 0));

            if (answers[index] != 'C')
                answer_labelC.setForeground(new Color(255, 0, 0));

            if (answers[index] != 'D')
                answer_labelD.setForeground(new Color(255, 0, 0));

//For pausing and turning the button to red or green, we need to set the time.
            Timer pause = new Timer(2000, new ActionListener() {   //excuting at two seconds

                // @Override
                public void actionPerformed(ActionEvent e) {
                    answer_labelA.setForeground(new Color(25, 255, 0));
                    answer_labelB.setForeground(new Color(25, 255, 0));
                    answer_labelC.setForeground(new Color(25, 255, 0));
                    answer_labelD.setForeground(new Color(25, 255, 0));

                    answer = ' ';
                    seconds = 10; //counting 10 sec
                    second_left.setText(String.valueOf(seconds));
                    buttonA.setEnabled(true);
                    buttonB.setEnabled(true);
                    buttonC.setEnabled(true);
                    buttonD.setEnabled(true);

                    index++;
                    nextQuestion();


                }
            });
            pause.setRepeats(false);
            pause.start();


        }

        //This method will show the final result
        public void results() {
            buttonA.setEnabled(false);
            buttonB.setEnabled(false);
            buttonC.setEnabled(false);
            buttonD.setEnabled(false);

            result = (int) ((correct_guessues / (double) total_questions) * 100);
            textfield.setText("Result");
            textarea.setText(" ");
            answer_labelA.setText(" ");
            answer_labelB.setText(" ");
            answer_labelC.setText(" ");
            answer_labelD.setText(" ");

            number_right.setText("(" + correct_guessues + "/" + total_questions + ")");
            percentage.setText(result + "%");

            frame.add(number_right);
            frame.add(percentage);
        }

}
