import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	
	static JFrame frame = new JFrame();
	char currentLetter;
	JLabel label = new JLabel();

	public static void main(String[] args) {
	
	TypingTutor tt = new TypingTutor();
	tt.setup();
	
}
	
void setup() {
	
	frame.setVisible(true);
	frame.setTitle("Type or Die");
	frame.add(label);
	frame.addKeyListener(this);
	
    currentLetter = generateRandomLetter();
    
    label.setText(currentLetter + "");
    label.setFont(label.getFont().deriveFont(35.0f));
    label.setHorizontalAlignment(JLabel.CENTER);
    
    

    frame.pack();
}

static char generateRandomLetter() {
    Random r = new Random();
    return (char) (r.nextInt(26) + 'a');
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	

}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
	char pressed = e.getKeyChar();
	
    if (pressed == currentLetter) {
    frame.getContentPane().setBackground(Color.GREEN);
    	System.out.println("You Typed: " + currentLetter);
    	System.out.println("Correct!");
    	currentLetter = generateRandomLetter();
    	 label.setText(currentLetter + "");
     }
   
    else {
    	 
    	frame.getContentPane().setBackground(Color.RED);
    	System.out.println("Incorrect");
   
    }
    
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
	
}

}
