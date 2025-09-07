import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Programm extends JFrame{

    //for checks grades
    float five = 0f;
    float four = 0f;
    float three = 0f;
    float two = 0f;

    JButton res_button;
    JLabel Enter_label, res_label;
    JTextField res_field, input_field;

    Programm() {

        this.setTitle("The average score");
        this.setSize(320, 270);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //Label
        Enter_label = new JLabel("Enter the scores separated by a space: ");
        Enter_label.setBounds(1, -30, 250, 100);

        res_label = new JLabel("Result: ");
        res_label.setBounds(1, 30, 150, 100);

        //Text Field
        input_field = new JTextField();
        input_field.setBounds(1, 30, 300, 40);

        res_field = new JTextField();
        res_field.setBounds(1, 90, 300, 40);
        res_field.setEditable(false);

        //button
        res_button = new JButton("Find out the average score");
        res_button.setBounds(1, 150, 300, 40);

        res_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get numbers
                String data_numbers = input_field.getText();
                String[] strNumbers = data_numbers.split(" ");
                float[] numbers = new float[strNumbers.length];

                for (int i = 0; i < strNumbers.length; i++) {
                    numbers[i] = Float.parseFloat(strNumbers[i]);
                }

                //check grades
                for (int check = 0; check < strNumbers.length; check++) {
                    if (numbers[check] == 5)
                        five++;
                    if (numbers[check] == 4)
                        four++;
                    if (numbers[check] == 3)
                        three++;
                    if (numbers[check] == 2)
                        two++;
                }

                //output answer
                float results = (5 * five + 4 * four + 3 * three + 2 * two) / (five + four + three + two);
                String result = String.valueOf(results);
                res_field.setText(result);
            }
        });

        this.add(res_button);
        this.add(Enter_label);
        this.add(res_label);
        this.add(res_label);
        this.add(res_field);
        this.add(input_field);
        this.setVisible(true);

    }

}