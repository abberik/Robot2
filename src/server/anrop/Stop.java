package server.anrop;

import java.io.IOException;

public class Stop extends Thread{

	private Process currentProcess;
	
	public Stop(Process currentProcess) {
		this.currentProcess = currentProcess;

		
	}
	
	public void run(){
		try{
			currentProcess.destroy();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			System.out.println("try00");
			//This could potentially fuck up badly, but catch exception :D
			currentProcess.destroy();

		}catch(Exception ex){}


		try {
			System.out.println("try1");
			Process p = Runtime.getRuntime().exec("killall python");
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
