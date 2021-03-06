import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	JButton button = new JButton();
	JButton button2 = new JButton();
	public static void main(String[] args) {
	
	
	NastySurprise ns = new NastySurprise();
	ns.createGui();
	
	
	
}

void createGui() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	frame.setVisible(true);
	frame.setTitle("Trick or Treat?");
	frame.add(panel);
	panel.add(button);
	button.setText("Treat");
	button.addActionListener(this);
	
	panel.add(button2);
	
	button2.setText("Trick");
	button2.addActionListener(this);
	
	
	
	frame.pack();
}

private static void showPictureFromTheInternet(String imageUrl) {
    try {
         URL url = new URL(imageUrl);
         Icon icon = new ImageIcon(url);
         JLabel imageLabel = new JLabel(icon);
         JFrame frame = new JFrame();
         frame.add(imageLabel);
         frame.setVisible(true);
         frame.pack();
    } catch (MalformedURLException e) {
         e.printStackTrace();
    }
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonpressed = (JButton)e.getSource();
	if (buttonpressed == button) {
		showPictureFromTheInternet("https://c1.staticflickr.com/5/4112/5170590074_714d36db83_b.jpg");
	}
	if (buttonpressed == button2) {
		showPictureFromTheInternet("https://i.ytimg.com/vi/CtB4_dU38hM/hqdefault.jpg");
	}
}

}
