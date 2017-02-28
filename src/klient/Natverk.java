package klient;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Natverk {

	private String host;
	private int port;
	private Socket socket;
	private ObjectInputStream inStream;
	private ObjectOutputStream outStream;
	private Runnable initiate;
	
	public Natverk(String host, int port,Kontroller kontroller) {
		
		this.host = host;
		this.port = port;
				
		 initiate = new Runnable(){

			@Override
			public void run() {
				
				try {
					System.out.println("1a");

					socket = new Socket(host,port);
					
					outStream = new ObjectOutputStream(socket.getOutputStream());
					inStream = new ObjectInputStream(socket.getInputStream());
					
					
					kontroller.setStream(outStream);
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
		};
		
		Thread t = new Thread(initiate);
		t.start();
		
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getInStream() {
		return inStream;
	}

	public void setInStream(ObjectInputStream inStream) {
		this.inStream = inStream;
	}

	public ObjectOutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(ObjectOutputStream outStream) {
		this.outStream = outStream;
	}

	public Runnable getInitiate() {
		return initiate;
	}

	public void setInitiate(Runnable initiate) {
		this.initiate = initiate;
	}
	
	
	
}
