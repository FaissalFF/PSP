package ejercicioThreads1;

public class Thread1 implements Runnable{
	private static int cont = 0;
	static Object lock = new Object();
	private int turno;
	
	public Thread1(int turno) {
		this.turno = turno;
	}
	public Thread1() {
	// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		synchronized (lock) {
			while(cont < 98) {
				while(cont % 3 != turno) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				cont ++;
				System.out.println("Turno " + (turno + 1) + ":" + cont);
				lock.notifyAll();
			}

		}
	}

}
