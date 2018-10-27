import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {
	
	 JFrame frame = new JFrame();
	 JTextField text = new JTextField(10);
	 JButton button = new JButton();
	 JPanel panel = new JPanel();

	public static void main(String[] args) {
	
		GetLatestTweet tw = new GetLatestTweet();
		tw.getTweet();
}
	
	void getTweet() {
		frame.setVisible(true);
		frame.setTitle("The Amazing Tweet Retriever");
		frame.add(panel);
		frame.setPreferredSize(new Dimension(300,75));
		
		panel.add(text);
		panel.add(button);
		
		button.setText("Search Twitter");
		button.addActionListener(this);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tweet = text.getText();
		
		JButton buttonpresed = (JButton)e.getSource();
		if (buttonpresed == button) {
			System.out.println(getLatestTweet(tweet));
		}
	}
	

private String getLatestTweet(String searchingFor) {

      Twitter twitter = new TwitterFactory().getInstance();

      AccessToken accessToken = new AccessToken(
            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

      twitter.setOAuthAccessToken(accessToken);

      Query query = new Query(searchingFor);
      try {
            QueryResult result = twitter.search(query);
            return result.getTweets().get(0).getText();
      } catch (Exception e) {
            System.err.print(e.getMessage());
            return "What the heck is that?";
      }
}
}

