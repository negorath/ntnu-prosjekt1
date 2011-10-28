package Map;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapTesting {
	public static void main(String[] args) throws Exception{
	}
	public void call(String s, String tittle) throws Exception{
	    JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    BufferedImage image = ImageIO.read(new URL(s));
	    JLabel label = new JLabel(new ImageIcon(image));
	    panel.add(label);
	    frame.add(panel);
	    frame.setTitle(tittle);
	    frame.pack();
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
}
