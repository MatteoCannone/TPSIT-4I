package it.edu.iisgubbio;

public class Prova {
	public static void main(String[] args) {
//		int a, b, c;
//		a = 10;
//		b = 0;
//		try {
//			c = a / b;
//			System.out.println(c);
//		} catch (ArithmeticException e) {
//			System.out.println("non si divide per zero");
//		}
//		int y[] = new int[8];
//		try {
//			y[4] = 19;
//			System.out.println("tutto ok");
//		} catch (ArrayIndexOutOfBoundsException x) {
//			System.out.println("stai attento");
//		}
//		System.out.println("FINE");
		
		
		int b = 0;
		int y[] = new int[8];
		try {
			y[4] = 19;
			y[3] = y[2]/b; //problema col calcolo
			y[3] = y[13]/b; //problema col vettore
			System.out.println("tutto ok");
		} catch(ArithmeticException erroreAritmetico) {
			System.out.println("problema nel calcolo"); //y[3] = y[2]/b   il catch trova gli errori
		} catch(ArrayIndexOutOfBoundsException erroreVettore) {
			System.out.println("problema col vettore"); //y[3] = y[13]/b
		}
		System.out.println("FINE");
	}

}
