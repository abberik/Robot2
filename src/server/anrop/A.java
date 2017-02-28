package server.anrop;

import java.io.IOException;

public class A extends Thread{

	private Process currentProcess;
	
	public A(Process currentProcess){
		this.currentProcess = currentProcess;
	}
		
	public void run(){
		try{

			//This could potentially fuck up badly, but catch exception :D
			currentProcess.destroy();

		}catch(Exception ex){}


		try {

			Process p = Runtime.getRuntime().exec("python a.py");
		    p.waitFor();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
