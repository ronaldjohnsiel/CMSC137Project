import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class About extends JPanel implements MouseListener{
	
	private JPanel back = new JPanel();
	private ImageIcon image;
	private Image img;
	
	public About(){
	
		this.setLayout(null);
		
		image = new ImageIcon("graphics/back.png");
		img = Menu.resizeImage(image, 50, 50);
		back.add(new JLabel(new ImageIcon(img)));
		back.setBounds(10, 10, 60, 60);
		back.addMouseListener(this);
		back.setOpaque(false);
		add(back);
		
		image = new ImageIcon("graphics/about.png");
		img = image.getImage();
		img = Menu.resizeImage(image, 800, 600);
		JLabel background = new JLabel();
		ImageIcon icon = new ImageIcon(img);
		background.setIcon(icon);
		background.setBounds(0, 0, 800, 570);
		background.setOpaque(false);
		
		this.setOpaque(false);
		this.setBounds(0, 0, 800, 600);
		this.add(background);
	}
	
	public void mouseExited(MouseEvent me){ }
	
	public void mouseClicked(MouseEvent me){ 
		CardLayout cardLayout = (CardLayout)Main.getCards().getLayout();
		if(me.getSource() == back){
			cardLayout.first(Main.getCards());
		}
	}
	
	public void mousePressed(MouseEvent me){ }
	
	public void mouseReleased(MouseEvent me){ }
	
	public void mouseEntered(MouseEvent me){ }

}