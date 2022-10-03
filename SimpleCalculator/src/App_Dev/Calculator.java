package App_Dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	//initialize window characters
	Font textAreaFont = new Font("Arial", Font.PLAIN, 15);
	Font calculatorFont = new Font("Arial", Font.PLAIN, 11);
	JFrame frame;
	JPanel panel;
	JTextField textArea;
	JButton[] operationButton = new JButton[9];
	JButton[] numberButton = new JButton[10];
	JButton addButton, minusButton,negativeButton, multiplyButton, divisionButton, equalButton, decimalButton, deleteButton, clearButton;
	
	
	//initialize numbers and result 
	double num1 = 0, num2 = 0, result = 0;
	
	char operator;

	public Calculator() {
		
		//create window
		frame = new JFrame("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(235,308);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		
		//create area for text display
		textArea = new JTextField();
		textArea.setBounds(25, 12, 175, 30);
		textArea.setFont(textAreaFont);
		textArea.setHorizontalAlignment(JTextField.RIGHT);
		textArea.setEditable(false);
		frame.add(textArea);
		
		//adding & setting buttons
		addButton = new JButton("+");
		minusButton = new JButton("-");
		multiplyButton = new JButton("x");
		divisionButton = new JButton("÷");
		deleteButton = new JButton("DEL");
		clearButton = new JButton("CLR");
		equalButton = new JButton("=");
		decimalButton = new JButton(".");
		negativeButton = new JButton("(-)");
		
		operationButton[0] = addButton;
		operationButton[1] = minusButton;
		operationButton[2] = multiplyButton;
		operationButton[3] = divisionButton;
		operationButton[4] = deleteButton;
		operationButton[5] = clearButton;
		operationButton[6] = equalButton;
		operationButton[7] = decimalButton;
		operationButton[8] = negativeButton;
		
		for(int i = 0; i < 9; i++) {
			operationButton[i].addActionListener(this);
			operationButton[i].setFont(calculatorFont);
			operationButton[i].setFocusable(false);
		}
		
		
		for(int i = 0; i < 10; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(calculatorFont);
			numberButton[i].setFocusable(false);
			
		}
		negativeButton.setBounds(151,50,49,30);
		deleteButton.setBounds(88, 50, 58, 30);
		clearButton.setBounds(25, 50, 58, 30);
		
		panel = new JPanel();
		panel.setBounds(25, 85, 175, 170);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		frame.add(panel);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(multiplyButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(divisionButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(addButton);
		panel.add(decimalButton);
		panel.add(numberButton[0]);
		panel.add(equalButton);
		panel.add(minusButton);
		
		
		
		frame.add(negativeButton);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//display text based on what button is clicked
		for (int i = 0; i < 10; i++) {
			if(e.getSource() == numberButton[i]) {
				textArea.setText(textArea.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decimalButton ) {
			textArea.setText(textArea.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textArea.getText());
			operator = '+';
			textArea.setText("");
		}
		if(e.getSource() == minusButton ) {
			num1 = Double.parseDouble(textArea.getText());
			operator = '-';
			textArea.setText("");
		}
		if(e.getSource() == multiplyButton ) {
			num1 = Double.parseDouble(textArea.getText());
			operator = '*';
			textArea.setText("");
		}
		if(e.getSource() == divisionButton ) {
			num1 = Double.parseDouble(textArea.getText());
			operator = '/';
			textArea.setText("");
		}
		if(e.getSource() == equalButton ) {
			num2 = Double.parseDouble(textArea.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textArea.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clearButton ) {
			textArea.setText("");
		}
		if(e.getSource() == deleteButton ) {
			String string = textArea.getText();
			textArea.setText("");
			for(int i = 0; i<string.length() -1; i++) {
				textArea.setText(textArea.getText() + string.charAt(i));
			}
		}
		if(e.getSource() == negativeButton ) {
			double temp = Double.parseDouble(textArea.getText());
			temp *= -1;
			textArea.setText(String.valueOf(temp));
		}
	}
}