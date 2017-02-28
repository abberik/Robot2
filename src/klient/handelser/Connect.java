package klient.handelser;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import klient.Kontroller;
import klient.Natverk;

public class Connect extends AbstractAction{

	private Kontroller kontroller;
	private Runnable startaNatverk;
	private Thread natTrad;
	private Natverk natverk;
	
	public Connect(Kontroller kontroller) {
		this.kontroller = kontroller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		startaNatverk = new Runnable(){

			@Override
			public void run() {
				
				String text = JOptionPane.showInputDialog("Ange server enligt [host:port]");
				
				String host = text.split(":")[0];
				int port = Integer.parseInt(text.split(":")[1]);
				
				natverk = new Natverk(host,port,kontroller);
				
			}
			
		};
		
		natTrad = new Thread(startaNatverk);
		natTrad.start();
		
	}

}
