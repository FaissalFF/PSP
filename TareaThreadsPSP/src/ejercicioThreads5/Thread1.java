package ejercicioThreads5;

class Thread1 implements Runnable{
	public char nombreThread;
	static public boolean [][] butacas;
	static private int cont = 0;
	static private Object lock = new Object();
	
	@Override
	public void run() {
			while(cont <=(20*25)) {
				int x = (int)Math.round(Math.random() * 24);
				int y = (int)Math.round(Math.random() * 19);
				if(butacas[x][y] == true) {
					butacas[x][y] = false;
					System.out.println("Taquilla " + nombreThread + "| fila " + x + "butaca " + y + " reservado");
					cont ++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					cont ++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}
