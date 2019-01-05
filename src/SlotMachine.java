import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	JButton spin = new JButton();
	JLabel winCounter = new JLabel();
	int numOfWins = 0;
	static Random rand = new Random();
	static int num = rand.nextInt(3);
	
	
	public static void main(String[] args) {
		SlotMachine sm = new SlotMachine();
		sm.getRandomImage();
		sm.makeFrame();
		sm.makeButton();
		
	}
	

void makeButton() {
	
	spin.setText("SPIN!");
	spin.setPreferredSize(new Dimension(100,75));
	spin.addActionListener(this);
	
}
	
    void makeFrame() {

    	frame.setVisible(true);
   	frame.setTitle("Slot Machine");
    	frame.add(panel);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setPreferredSize(new Dimension(480,280));
    	frame.pack();
  
    panel.setBackground(new Color(240,240,255));	
    panel.add(slot1);
    	panel.add(slot2);
    	panel.add(slot3); 
    	panel.add(spin);
    	panel.add(winCounter);
    	winCounter.setText("Win Counter: " +numOfWins);
    	slot1.setPreferredSize(new Dimension(150,150));
    	slot2.setPreferredSize(new Dimension(150,150));
    	slot3.setPreferredSize(new Dimension(150,150));
    	
    }
   
    void getRandomImage() {
    
    	int num = rand.nextInt(3);
    	if (num == 0) {
    		slot1 = showImage("cherry.png");
    	}
    	if (num == 1) {
    		slot1 = showImage("orange.jpeg");
    	}
    if (num == 2) {
     	slot1 = showImage("lemon.png");
    }
    
    int num2 = rand.nextInt(3);
    if (num2 == 0) {
		slot2 = showImage("cherry.png");
	}
	if (num2 == 1) {
		slot2 = showImage("orange.jpeg");
	}
    if (num2 == 2) {
 	slot2 = showImage("lemon.png");
    }
    
   int num3 = rand.nextInt(3);
    if (num3 == 0) {
		slot3 = showImage("cherry.png");
	}
	if (num3 == 1) {
		slot3 = showImage("orange.jpeg");
	}
    if (num3 == 2) {
 	slot3 = showImage("lemon.png");
    }
    
    if (num == num2 && num == num3 && num2 == num3) {
    	JOptionPane.showMessageDialog(null, "You Win! Keep Playing!");
    	numOfWins++;
    }
    	
    }
    
    private JLabel showImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		return image;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton buttonpressed = (JButton)e.getSource();
	    if (buttonpressed == spin) {
	    	frame.dispose();
	    	frame.remove(panel);
	    	 	getRandomImage();
	    	 	panel = new JPanel();
	    	 	makeFrame();
	   
	    }
	
	}
}