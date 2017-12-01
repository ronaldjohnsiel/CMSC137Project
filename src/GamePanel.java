import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class GamePanel extends JPanel implements MouseListener{
	private static String inetAdd = "Werpa Pu";
	private static String clientName = "localhost";
	private static JPanel statusPanel = new JPanel();
	private static JPanel chatPanel = new JPanel(new BorderLayout());

	public GamePanel(String inetAdd, String clientName){
		this.inetAdd = inetAdd;
		this.clientName = clientName;
		
		// UI Layer Indicator
		System.out.println("Game Panel Level");

		// Chat Panel 
		ChatGUI client = new ChatGUI(clientName, inetAdd);
        try {
			System.out.println("Added " + clientName + " to the group chat.");
			Thread thread = new Thread(client);
			thread.start();
		} catch(Exception e){
			e.printStackTrace();
		}
		chatPanel.setOpaque(true);
		chatPanel.setBackground(Color.WHITE);
		chatPanel.add(client, BorderLayout.SOUTH);

		// Status Panel (Game Stats)
		String stats = "Game Stats for "  + clientName;
		JLabel label = new JLabel(stats);
		statusPanel.setOpaque(true);
		statusPanel.setBackground(Color.WHITE);
		statusPanel.add(label);

		// Game Panel
		this.setLayout(new BorderLayout());
		this.add(chatPanel, BorderLayout.EAST);
		this.add(statusPanel, BorderLayout.NORTH);

		try {
			this.add(new BattleSplix(inetAdd, clientName), BorderLayout.CENTER);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


	// I-OVERRIDE DAW EH
	public void mouseExited(MouseEvent me){ }
	public void mouseClicked(MouseEvent me){ }
	public void mousePressed(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){ }
	public void mouseEntered(MouseEvent me){ }
}