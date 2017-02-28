package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Network {

	public static void main(String[] args) {
		new Network();
	}

	private static int port = 1337;


	private ServerSocket serverSocket;
	private Socket socket; //Den aktiva socketen
	private ObjectInputStream inStream;
	private ObjectOutputStream outStream;
	private boolean connected = false;

	private Styrning styrning;

	public Network() {

		styrning = new Styrning();

		try {

			serverSocket = new ServerSocket(Network.port);

			// Endast en klient ska tas emot
			socket = serverSocket.accept();
			connected = true;
			System.out.println("connected to " + socket.getInetAddress().toString());
			
			outStream = new ObjectOutputStream(socket.getOutputStream());
			inStream = new ObjectInputStream(socket.getInputStream());

			System.out.println("created streams");
			while(connected){
				System.out.println("waiting");
				int msg;

				try{
					socket.isConnected();	
					msg = inStream.readInt();
					System.out.println("msg : " + msg);
					if(msg == 1){

						styrning.stop();

					}

					if(msg == 2){

						styrning.fram();

					}

					if(msg == 3){

						styrning.hoger();

					}

					if(msg == 4){

						styrning.vanster();

					}

					if(msg == 5){

						styrning.bak();

					}
					



				}catch(Exception ex){ex.printStackTrace();}


			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
