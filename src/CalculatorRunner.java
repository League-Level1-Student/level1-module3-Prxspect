import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorRunner {

	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton addButton = new JButton();
	static JButton multiplyButton = new JButton();
	static JButton subtractButton = new JButton();
	static JButton divideButton = new JButton();
	static JTextField num1 = new JTextField();
	static JTextField num2 = new JTextField();
	
	
	public static void main(String[] args) {
	  
		frame.setVisible(true);
		frame.setTitle("Simple Calculator");
		frame.add(panel);
		panel.add(num1);
		panel.add(num2);
		addButton.setText("ADD");
		panel.add(addButton);
		multiplyButton.setText("MULTIPLY");
		panel.add(multiplyButton);
		subtractButton.setText("SUBTRACT");
		panel.add(subtractButton);
		
		
}
}
