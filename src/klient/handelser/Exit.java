package klient.handelser;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class Exit extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.exit(0);
		
		
	}

}
