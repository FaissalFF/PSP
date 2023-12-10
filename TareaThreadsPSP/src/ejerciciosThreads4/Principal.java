package ejerciciosThreads4;

import java.util.Scanner;

class Principal {
	static Scanner tc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduzca el numero de caballos: ");
		int numCaballos = tc.nextInt();tc.nextLine();
		System.out.println("Introduzca la distancia: ");
		int distancia = tc.nextInt();tc.nextLine();
		Thread1.numCaballos = numCaballos;
			for (int i = 0; i<numCaballos; i++) {
				Thread t = new Thread(new Thread1((i + 1), distancia));
				t.start();
			}
	}
}
