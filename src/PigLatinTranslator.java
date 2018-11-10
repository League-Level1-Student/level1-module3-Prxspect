import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {

	JFrame frame = new JFrame();
	JTextField text = new JTextField(40);
	JTextField text2 = new JTextField(40);
	JButton button = new JButton();
	JPanel panel = new JPanel();
	PigTranslator pt = new PigTranslator();
	
	public static void main(String[] args) {
	PigLatinTranslator plt = new PigLatinTranslator();
	plt.translator();
}
	
	void translator() {
		
		frame.setVisible(true);
		frame.setTitle("Pig Latin Translator");
		frame.setPreferredSize(new Dimension(500,140));
		
		frame.add(panel);
		panel.add(text);
		panel.add(button);
		panel.add(text2);
		
		button.setText("Translate");
		button.addActionListener(this);
		text2.setEditable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String word = text.getText();
		
		JButton buttonpressed = (JButton)e.getSource();
		if (buttonpressed == button) {
			String translatedWord = pt.translate(word);
			System.out.println(translatedWord);
			text2.setText(translatedWord);
			
		}
	}
}
