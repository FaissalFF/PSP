package ejercicioThreads3;

class Principal {
	static String trabajo;

	public static void main(String[] args) {
		while(true) {
			int num = (int) Math.round(Math.random() * 2);
			if(num == 1) {
				trabajo = "vendedor";
			}else {
				trabajo = "comprador";
			}
			Thread t = new Thread(new Thread1(trabajo));
			t.start();
		}
	}
}
