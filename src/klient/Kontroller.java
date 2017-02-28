package klient;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import klient.handelser.Connect;
import klient.handelser.Exit;


public class Kontroller extends JFrame{
	
	private Lyssnare keyListener;
	

	private JMenuBar menubar;
	private JMenu actionMenu;
	private JMenuItem exitButton;
	private JMenuItem connectButton;
	private JMenuItem videoButton;
	private JLabel mainLabel;
	
	public Kontroller() {
		
		
		
		
		//GUI
		this.setSize(640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		keyListener = new Lyssnare();
		
		this.addKeyListener(keyListener);
		
		mainLabel = new JLabel("Drive like you stole it faggot! :D");
		mainLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		this.add(mainLabel);
		
		menubar = new JMenuBar();
		this.add(menubar,BorderLayout.NORTH);
		JMenu actionMenu = new JMenu("actions");
		actionMenu.setMnemonic('a');
		menubar.add(actionMenu);
		
		connectButton = new JMenuItem(new Connect(this));
		connectButton.setText("connect");
		connectButton.setMnemonic('c');
		actionMenu.add(connectButton);
		

		
		exitButton = new JMenuItem(new Exit());
		exitButton.setText("exit");
		exitButton.setMnemonic('e');
		actionMenu.add(exitButton);

		
		

		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Kontroller();
	}
	
	public void setStream(ObjectOutputStream outStream){
		keyListener.setOutStream(outStream);
		
	}
	
}

