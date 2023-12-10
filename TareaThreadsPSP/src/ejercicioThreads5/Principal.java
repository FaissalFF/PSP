package ejercicioThreads5;

class Principal {
		
	public static void main(String[] args) {
		boolean [][] butacas = new boolean[25][20];
		for(int i = 0; i<25;i++) {
			butacas[i][0] = true;
			for(int j =0; j<20; j++) {
				butacas[i][j] = true;
			}
		}
			Thread1 t1= new Thread1();
			t1.butacas = butacas;
			t1.nombreThread = 'X';
			Thread t = new Thread(t1);
			t.start();
			Thread1 th1 = new Thread1();
			th1.butacas = butacas;
			th1.nombreThread = 'Y';
			Thread t2 = new Thread(th1);
			t2.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
