import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static Random rand = new Random();
	static int num = rand.nextInt(16);
	

	public static void main(String[] args) {
		WhackAMole wam = new WhackAMole();
		wam.makeFrame();
		wam.drawButtons(num);
	}

	void makeFrame() {

		frame.setVisible(true);
		frame.setTitle("Whack A Button");
		frame.add(panel);
		frame.setPreferredSize(new Dimension(300, 160));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void drawButtons(int num) {

		for (int i = 0; i < 17; i++) {
			JButton button = new JButton();
			panel.add(button);
			button.addActionListener(this);
			if (i == num) {
				button.setText("Mole!");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
         
		JButton buttonpressed = (JButton)e.getSource();
		String text = buttonpressed.getText();
         if ("Mole!".equals(text)) {
        	 
         }
         else {
        	 speak("Incorrect");
         }
	}
	
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date(molesWhacked);
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}



}
