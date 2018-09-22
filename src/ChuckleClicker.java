import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {

	static JButton jokebutton = new JButton();
	static JButton punchlinebutton = new JButton();
	
	public static void main(String[] args) {
	
		ChuckleClicker cc = new ChuckleClicker();
		cc.makeButtons();
	
}

void makeButtons() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	frame.add(panel);
	panel.add(jokebutton);
	panel.add(punchlinebutton);
	frame.setTitle("Chucle Clicker");
	frame.setVisible(true);
	jokebutton.setText("Joke");
	punchlinebutton.setText("Punchline");
	jokebutton.addActionListener(this);
	punchlinebutton.addActionListener(this);
}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonpressed = (JButton)e.getSource();
	if (buttonpressed == jokebutton) {
		System.out.println("What did the dad buffalo say to his son on the first day of school?");
	}
	if (buttonpressed == punchlinebutton) {
		System.out.println("Bison");
	}
}

}
