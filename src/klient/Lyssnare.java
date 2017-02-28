package klient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Lyssnare implements KeyListener {

	private ObjectOutputStream outStream;
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int keycode = e.getKeyCode();
		
		if(outStream == null) System.out.println("outstream is null");
		
		if(keycode == KeyEvent.VK_SPACE){
			
			System.out.println("1");
			
			if(outStream != null){	try {System.out.println("writing");outStream.writeInt(1);	} catch (IOException e1) {	e1.printStackTrace();	}	}
			
		}else if(keycode == KeyEvent.VK_UP){
			
			System.out.println("2");
			
			if(outStream != null){	try {System.out.println("writing");outStream.writeInt(2);	} catch (IOException e1) {	e1.printStackTrace();	}	}
			
		}else if(keycode == KeyEvent.VK_LEFT){
			
			System.out.println("4");
			
			if(outStream != null){	try {System.out.println("writing");outStream.writeInt(4); 	} catch (IOException e1) {	e1.printStackTrace();	}	}
			
		}else if(keycode == KeyEvent.VK_RIGHT ){
			
			System.out.println("3");
			
			if(outStream != null){	try {System.out.println("writing");outStream.writeInt(3);	} catch (IOException e1) {	e1.printStackTrace();	}	}
			
		}else if(keycode == KeyEvent.VK_DOWN){
			
			System.out.println("5");
			
			if(outStream != null){	try {System.out.println("writing");outStream.writeInt(5);	} catch (IOException e1) {	e1.printStackTrace();	}	}
			
		}
		
		if(outStream != null){
			try {
				outStream.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		//Ska inte g???ra n???gonting, h???ll koll p??? n???r tangenter sl???pps och trycks ned.
		
	}

	public ObjectOutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(ObjectOutputStream outStream) {
		System.out.println("set outstream");
		this.outStream = outStream;
	}
	
	
	
	
}
