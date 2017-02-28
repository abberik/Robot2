package server.anrop;

import java.io.IOException;

public class W extends Thread{

	private Process currentProcess;
	
	public W(Process currentProcess) {
		
		this.currentProcess = currentProcess;
		
	}
	
	public void run(){

		try{
			System.out.println("try00");
			//This could potentially fuck up badly, but catch exception :D
			currentProcess.destroy();

		}catch(Exception ex){}


		try {
			System.out.println("try1");
			Process p = Runtime.getRuntime().exec("python w.py");
			System.out.println("try2");
		    p.waitFor();
		    System.out.println("try3");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
