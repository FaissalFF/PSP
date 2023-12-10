package ejercicioThreads1;

class Principal {

	public static void main(String[] args) {

		for(int i = 0; i < 3; i++) {
			Thread t = new Thread(new Thread1(i));
			t.start();
		}

	}

}
