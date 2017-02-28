package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import server.anrop.A;
import server.anrop.D;
import server.anrop.S;
import server.anrop.Stop;
import server.anrop.W;

public class Styrning {

	private Process currentProcess;

	public Styrning() {



	}

	public void stop(){

		Stop stop = new Stop(currentProcess);
		stop.start();

	}

	public void fram(){
		
		W w = new W(currentProcess);
		w.start();
	}

	public void vanster(){

		A a = new A(currentProcess);
		a.start();
		
	}

	public void hoger(){

		D d = new D(currentProcess);
		d.start();
		
	}

	public void bak(){

		S s = new S(currentProcess);
		s.start();
  	}




}

