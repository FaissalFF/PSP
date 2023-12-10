package ejerciciosThreads4;

public class Thread1 implements Runnable{
	private int nCaballo;
	private int distanciaRecorrida;
	private int distancia;
	static public int cont= 0;
	static public int numCaballos;
	static private boolean ganador = false;
	static private Object lock = new Object();
	public Thread1(int nCaballo, int distancia) {
		this.nCaballo = nCaballo;
		this.distancia = distancia;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while(ganador == false) {
				distanciaRecorrida = distanciaRecorrida + (int)Math.round(Math.random() * 1000);
				if(distanciaRecorrida >= distancia) {
					lock.notifyAll();
					System.out.println("Caballo " + nCaballo + ": ganador");
					ganador = true;
				}else {
					cont++;
					System.out.println("Caballo " + nCaballo + ": " + distanciaRecorrida + " metros recorridos");
					try {
						if(cont != numCaballos) {
							lock.wait();
						}else {
							lock.notifyAll();
							cont = 0;
							Thread.sleep(4000);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
