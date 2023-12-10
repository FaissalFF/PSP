package ejercicioThreads2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Thread1 implements Runnable{
	private String ruta;
	int cont = 0;
	static int contTotal = 0;
	static int contFichero = 0;
	static Object lock = new Object();
	
	public Thread1(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public void run() {
		synchronized (lock) {
			File f1 = new File(ruta);
			BufferedReader bf1;
			try {
				bf1 = new BufferedReader(new FileReader(f1));
				String linea = "";
				while((linea = bf1.readLine()) != null) {
					String [] partes = linea.split(" ");
					for (String string : partes) {
						cont ++;
						contTotal++;
					}
				}
				System.out.println(ruta + ": " + cont + " palabras");
				contFichero++;
				cont = 0;
				if(contFichero == 3) {
					System.out.println("Total: " + contTotal);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
	}
		}

}
}
