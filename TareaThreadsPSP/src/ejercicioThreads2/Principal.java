package ejercicioThreads2;

class Principal {

	public static void main(String[] args) {
		String [] ficheros = {"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero1", 
				"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero2", 
				"C:\\Users\\Vocius\\workspace-accesoadatos\\TareaThreadsPSP\\fichero3"};
		for(int i = 0; i<ficheros.length; i++) {
			Thread t = new Thread(new Thread1(ficheros[i]));
			t.start();
		}
		

	}

}
