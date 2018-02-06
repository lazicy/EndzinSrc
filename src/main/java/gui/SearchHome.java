package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class SearchHome extends JFrame {
	
	public int screenHeight = getScreenSize().height;
	public int screenWidth = getScreenSize().width;
	
	
	public SearchHome() {
		setSize((int) (screenWidth/1.40), (int)(screenHeight/1.40));
		setTitle("СрчЕнџин");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//initialise();
		
		
	}
	
	public Dimension getScreenSize() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		Image img = kit.getImage("images/rsz_3logo.png");
		setIconImage(img);
		return screenSize;
	}

}
