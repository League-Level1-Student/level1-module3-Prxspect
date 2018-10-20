import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorRunner implements ActionListener {

	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton addButton = new JButton();
	static JButton multiplyButton = new JButton();
	static JButton subtractButton = new JButton();
	static JButton divideButton = new JButton();
	static JTextField num1 = new JTextField();
	static JTextField num2 = new JTextField();
	static JTextField answer = new JTextField();
	static JLabel label = new JLabel();
	Calculator calc = new Calculator();
	int ans;
	
	
	
	public static void main(String[] args) {
	  
		CalculatorRunner cr = new CalculatorRunner();
		cr.buildCalculator();
		
		}
	
	void buildCalculator() {
		
		frame.setVisible(true);
		frame.setTitle("Simple Calculator");
		frame.add(panel);
		frame.setPreferredSize(new Dimension(500, 150));
		
		panel.add(num1);
		panel.add(num2);
		num1.setPreferredSize(new Dimension(240,30));
		num2.setPreferredSize(new Dimension(240,30));
		
		addButton.setText("ADD");
		addButton.addActionListener(this);
		panel.add(addButton);
		addButton.setPreferredSize(new Dimension(120,30));
		
		multiplyButton.setText("MULTIPLY");
		multiplyButton.addActionListener(this);
		panel.add(multiplyButton);
		multiplyButton.setPreferredSize(new Dimension(120,30));
		
		subtractButton.setText("SUBTRACT");
		subtractButton.addActionListener(this);
		panel.add(subtractButton);
		subtractButton.setPreferredSize(new Dimension(120,30));
		
		divideButton.setText("DIVIDE");
		divideButton.addActionListener(this);
		panel.add(divideButton);
		divideButton.setPreferredSize(new Dimension(120,30));
		
		panel.add(label);
		label.setPreferredSize(new Dimension(500,50));
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(num1.getText());
		int b = Integer.parseInt(num2.getText());
		int c = 0;
		
		JButton buttonpressed = (JButton)e.getSource();
		if (buttonpressed == addButton) {
			ans = calc.add(a, b, c);
		}
		if (buttonpressed == multiplyButton) {
			ans = calc.multiply(a, b, c);
		}
		if (buttonpressed == subtractButton) {
			ans = calc.subtract(a, b, c);
		}
		if (buttonpressed == divideButton) {
			ans = calc.divide(a, b, c);
		}
		label.setText(ans + "");
		
		frame.pack();
	}
}
