package it.edu.iisgubbio.threads;

/*
 * Un thread in java può essere realizzato in vari modi:
 * 1) faccio una classe che estende la classe nativa di
 * java thread che ha due metodi principali:
 * Start() : fa partire il thread
 * Run() : contiene il codice che deve essere eseguito
 * dal thread
 */
public class HelloThreads extends Thread{
	
	public static void main(String args[]) {
		
		HelloThreads t1 = new HelloThreads();
		t1.start();
		
	}
	
	//il cuore è il metodo run
	public void run() { System.out.println("Hello from a thread"); }
	
}
