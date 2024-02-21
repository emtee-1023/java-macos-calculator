import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;


public class Main extends JFrame implements ActionListener {

    private DecimalFormat df = new DecimalFormat("#,###.00");

    private String[] btnLabels = {
            "(", ")", "mc", "m+", "m-", "mr", "C", "+/-", "%", "÷",
            "2ⁿᵈ", "x²", "x³", "xʸ", "eˣ", "10ˣ", "7", "8", "9", "x",
            "1/x", "²√x", "³√x", "ʸ√x", "ln", "log₁₀", "4", "5", "6", "-",
            "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+",
            "Rad", "sinh", "cosh", "tanh", "π", "Rand", "0","", ".", "="
    };
    private int operator = 0;
    private JPanel panel = new JPanel(new BorderLayout(0, 0));
    private JPanel btnPanel = new JPanel(new GridLayout(5, 10, 1, 1));
    private JButton[] btns = new JButton[50];
    private JTextArea screen = new JTextArea(2, 40);
    private double firstNum = 0, secondNum = 0;


    public Main() {
        init();
    }

    private void init() {
    screen.setFont(new Font("sans-serif", Font.PLAIN, 30));
    screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    screen.setMargin(new Insets(20, 20, -25, 20));
    screen.setBackground(new Color(50, 50, 47));
    panel.setBackground(Color.black);
    btnPanel.setBackground(Color.black);
    screen.setForeground(Color.white);

    int[] numberButtons = {16,17,18,26,27,28,36,37,38,47,48};
    int[] arithmeticButtons = {9,19,29,39,49};
    int[] zero = {46};

    for (int i = 0; i < btns.length; i++) {
        btns[i] = new JButton(btnLabels[i]);
        btns[i].setOpaque(true);
        btns[i].setBorderPainted(false);
        btns[i].setForeground(Color.WHITE);
        btns[i].addActionListener(this);
        btns[i].setFont(new Font("sans-serif", Font.PLAIN, 20));
        btns[i].setMargin(new Insets(0, 5, 0, 5));
        
        GridBagConstraints gbc = new GridBagConstraints();
        btnPanel.add(btns[i],gbc);

        // Setting background color for number buttons
        if (Arrays.binarySearch(numberButtons, i) >= 0) {
            btns[i].setBackground(new Color(100, 100, 98));

        // Setting background color for Arithmetic buttons
        } else if (Arrays.binarySearch(arithmeticButtons, i) >= 0) {
            btns[i].setBackground(new Color(255, 159, 9));

        } else if (Arrays.binarySearch(zero, i) >=0) {
            btns[i].setBackground(new Color(100, 100, 98));
            btns[i].setMargin(new Insets(0, 35, 0, -5));
            gbc.gridwidth = 2;
        }
        
        // Setting background color for function buttons
        else {
            btns[i].setBackground(new Color(69, 68, 66));
        }
        
        btnPanel.add(btns[i],gbc);
    }

    panel.add(btnPanel, BorderLayout.CENTER);
    panel.add(screen, BorderLayout.NORTH);
    screen.setEditable(false);
    add(panel);
    setSize(700, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cmd = e.getActionCommand().toString();
           

            switch (cmd) {
                // Handle parentheses
                case "(":
                    screen.setText(screen.getText() + "(");
                    break;
                case ")":
                    if (parenthesesAreValid(screen.getText() + ")")) {
                        screen.setText(screen.getText() + ")");
                    } else {
                        // Display error message or ignore the click
                    }
                    break;
                }


            
            switch (cmd) {
                case ".":
                    if (!screen.getText().contains(".")) {
                        screen.setText(screen.getText() + ".");
                    }
                    break;
                case "0":
                    screen.setText(screen.getText() + "0");
                    break;
                case "1":
                    screen.setText(screen.getText() + "1");
                    break;
                case "2":
                    screen.setText(screen.getText() + "2");
                    break;
                case "3":
                    screen.setText(screen.getText() + "3");
                    break;
                case "4":
                    screen.setText(screen.getText() + "4");
                    break;
                case "5":
                    screen.setText(screen.getText() + "5");
                    break;
                case "6":
                    screen.setText(screen.getText() + "6");
                    break;
                case "7":
                    screen.setText(screen.getText() + "7");
                    break;
                case "8":
                    screen.setText(screen.getText() + "8");
                    break;
                case "9":
                    screen.setText(screen.getText() + "9");
                    break;
            
                case "π":
                    screen.setText(screen.getText() + Math.PI);
                    break;
                case "e":
                    screen.setText(screen.getText() + Math.exp(1));
                    break;
                case "Rand":
                    screen.setText(screen.getText() + Math.random());
                    break;

                case "+":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 1;
                        screen.setText("");
                    }
                    break;
                case "-":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 2;
                        screen.setText("");
                    }
                    break;
                case "x":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 3;
                        screen.setText("");
                    }
                    break;
                case "÷":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 4;
                        screen.setText("");
                    }
                    break;
                case "xʸ":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 5;
                        screen.setText("");
                    }
                    break;
                case "ʸ√x":
                    if (!screen.getText().isEmpty()) {
                        firstNum = Double.parseDouble(screen.getText().toString());
                        operator = 6;
                        screen.setText("");
                    }
                    break;

                case "%":
                    double num = Double.parseDouble(screen.getText().toString());
                    screen.setText(String.valueOf(num / 100.0));
                    break;
                
                case "+/-":
                    String currentText = screen.getText();
                    if (!currentText.isEmpty()) {
                        double number = Double.parseDouble(currentText);
                        number = -1*number; // Toggle the sign
                        screen.setText(df.format(number)); // Format the number appropriately
                    }
                    break;
                
                
                case "x!":
                    double currentInput = Double.parseDouble(screen.getText().toString());
                    int fact = 1;
                    for(int i=1;i<=currentInput;i++){
                        fact = fact*i;
                    }
                    screen.setText(String.valueOf(fact));
                    break;
                
                case "C":
                    screen.setText("");
                    break;

                case "sin", "cos", "tan", "²√x", "x²", "x³", "³√x", "10ˣ", "1/x",
                        "log₁₀", "ln", "eˣ", "sinh", "cosh", "tanh":
                    specialFunctions(cmd);
                    break;

                default:
            }

            if (cmd.equalsIgnoreCase("=")) {

                if (!screen.getText().isEmpty()) {

                    secondNum = Double.parseDouble(screen.getText().toString());

                    switch (operator) {
                        case 1: // addition
                            screen.setText(String.valueOf(firstNum + secondNum));
                            break;
                        case 2: // subtraction
                            screen.setText(String.valueOf(firstNum - secondNum));
                            break;
                        case 3: // multiplication
                            screen.setText(String.valueOf(firstNum * secondNum));
                            break;
                        case 4: // division
                            if (secondNum != 0){
                                screen.setText(String.valueOf(firstNum / secondNum));
                            }else {
                                throw new ArithmeticException("Cannot divide by zero");
                            }
                            break;
                        case 5: // xʸ
                            screen.setText(String.valueOf(Math.pow(firstNum, secondNum)));
                            break;
                        case 6: // ʸ√x
                            screen.setText(String.valueOf(Math.pow(firstNum, (1 / secondNum))));
                            break;
                        default:
                    }
                }
                
            }
        
        }catch (NumberFormatException e1){
            screen.setText("Error: Invalid input");
        }catch (ArithmeticException e2){
            screen.setText("Error: " + e2.getMessage());}
        }
        

        // Method to check if parentheses are valid
        private boolean parenthesesAreValid(String text) {
            int openParentheses = 0;
            for (char c : text.toCharArray()) {
                if (c == '(') {
                    openParentheses++;
                } else if (c == ')') {
                    openParentheses--;
                    if (openParentheses < 0) {
                        return false; // More close parentheses than open parentheses
                    }
                }
            }
            return openParentheses == 0; // Should have equal number of open and close parentheses
}


    private void specialFunctions(String operation) {
        try {
            if (!screen.getText().isEmpty()) {
                double currentInput = Double.parseDouble(screen.getText().toString());
                double result = 0;
                double radian = Math.toRadians(currentInput);

                switch (operation) {
                    case "sin":
                        result = Math.sin(radian);
                        break;
                    case "cos":
                        result = Math.cos(radian);
                        break;
                    case "tan":
                        result = Math.tan(radian);
                        break;
                    case "x²":
                        result = Math.pow(currentInput, 2);
                        break;
                    case "²√x":
                        result = Math.sqrt(currentInput);
                        break;
                    case "x³":
                        result = Math.pow(currentInput, 3);
                        break;
                    case "³√x":
                        result = Math.cbrt(currentInput);
                        break;
                    case "10ˣ":
                        result = Math.pow(10, currentInput);
                        break;
                    case "eˣ":
                        result = Math.exp(currentInput);
                        break;
                    case "1/x":
                        if (currentInput != 0){
                            result = 1 / currentInput;
                        }else {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        break;
                    case "log₁₀":
                        result = Math.log10(currentInput);
                        break;
                    case "ln":
                        result = Math.log(currentInput);
                        break;
                    case "sinh":
                        result = Math.sinh(currentInput);
                        break;
                    case "cosh":
                        result = Math.cosh(currentInput);
                        break;
                    case "tanh":
                        result = Math.tanh(currentInput);
                        break;

                }
                screen.setText(String.valueOf(result));
            }
        }catch (NumberFormatException e1){
            screen.setText("Error: Invalid input");
        }catch (ArithmeticException e2){
            screen.setText("Error:" + e2.getMessage());
        }
    }

}