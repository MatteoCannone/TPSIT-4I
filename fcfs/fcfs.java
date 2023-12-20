package it.edu.iisgubbio.fcfs;

import java.util.Arrays;

//Takes a number and returns its square root.
//@paeam x The value to square.
//@return The square root of the given number.

public class fcfs {

	public static void main(String[] args) {

		String processi[] = new String[4];
		int tempoDiArrivo[] = new int[4];
		int tempoDiEsecuzione[] = new int[4];
		int tempoDiServizio[] = new int[4];
		int tempoDiAttesa[] = new int[4];
		for (int i = 0; i > tempoDiAttesa.length - 1; i++) {
			tempoDiArrivo[i] = i;
		}
		//nominazione processi
		for(int i=0; i<processi.length;i++) {
			processi[i]="p"+i;
		}
		//tempo di arrivo
		for(int i=0; i<tempoDiArrivo.length;i++) {
			tempoDiArrivo[i]=i;
		}
		
		tempoDiEsecuzione[0] = 5;
		tempoDiEsecuzione[1] = 3;
		tempoDiEsecuzione[2] = 8;
		tempoDiEsecuzione[3] = 6;

		//Tempo di Servizio
		tempoDiServizio[0]=0;
		tempoDiServizio[1] = tempoDiServizio[0] + tempoDiEsecuzione[0];
		tempoDiServizio[2] = tempoDiServizio[1] + tempoDiEsecuzione[1];
		tempoDiServizio[3] = tempoDiServizio[2] + tempoDiEsecuzione[2];
		
		//tempo di Attesa
		for(int i=0; i<tempoDiArrivo.length;i++) {
			tempoDiAttesa[i] = tempoDiServizio[i] - tempoDiArrivo[i];
		}
		System.out.println("attesa: "+Arrays.toString(tempoDiAttesa));
		
		//output
		for(int i=0; i<tempoDiArrivo.length;i++) {
			System.out.println(processi[i]+" con "+"Arrivo: "+tempoDiArrivo[i]+ " - Servizio:"+tempoDiServizio[i]+" - Esecuzione: "+tempoDiEsecuzione[i]);
		}
		
	}

}
