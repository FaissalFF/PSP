package ejercicioThreads2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class PrincipalForma1 {
	public static void main(String[] args) {
		int cont = 0;
		int contTotal = 0;
		String [] rutas = {"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero1", 
				"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero2", 
				"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero3"};
		for(int i = 0; i<rutas.length; i++) {
			File f1 = new File(rutas[i]);
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
				System.out.println(rutas[i] + ": " + cont + " palabras");
				cont = 0;
				if(i == 2) {
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
