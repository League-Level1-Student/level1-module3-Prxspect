import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
	int missedMoles = 0;
	int molesWhacked = 0;
	Date timeAtStart = new Date();
	

	public static void main(String[] args) {
		WhackAMole wam = new WhackAMole();
		wam.makeFrame();
		wam.drawButtons(num);
	}

	void makeFrame() {

		panel = new JPanel();
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Whack A Button");
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void drawButtons(int num) {

		for (int i = 0; i < 16; i++) {
			JButton button = new JButton();
			panel.add(button);
			button.addActionListener(this);
			if (i == num) {
				button.setText("Mole!");
			}
		}
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton buttonpressed = (JButton)e.getSource();
		String text = buttonpressed.getText();
		
		if ("Mole!".equals(text)) {
        	 playSound("hit.wav");
         }
         else {
        	 speak("Missed");
        	 missedMoles++;
         }
       
		 if (missedMoles == 5) {
        	 frame.dispose();
        	 JOptionPane.showMessageDialog(null, "You Lose.");
         }
		 else if (molesWhacked == 10) {
			 endGame(timeAtStart, molesWhacked);
		 }
		 else {
         frame.dispose();
         num = rand.nextInt(16);
         makeFrame();
         drawButtons(num);
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
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}



}
