package ejercicioThreads3;

import java.util.ArrayList;

public class Thread1 implements Runnable{
	private String trabajo;
	static int cantidad = 0;
	static ArrayList<Integer> productos = new ArrayList<Integer>();
	static Object lock = new Object();
	
	public Thread1(String trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while(productos.size() >= 0 && productos.size() <= 10) {
				if(trabajo.equalsIgnoreCase("vendedor")) {
					if(cantidad <= 10) {
						int producto = (int)Math.floor(Math.random() * 100);
						productos.add(producto);
						System.out.println("Vendedor añadió el producto: " + producto);
						try {
							Thread.sleep((int) (Math.random() * 3000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						lock.notifyAll();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					if(cantidad > -1) {
						if(productos.size() == 0) {
							System.out.println("El consumidor no consume ningun producto");
							try {
								lock.wait();
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}else {
							int productoC = (int)Math.round(Math.random() * (productos.size() - 1));
							int prodConsumido = productos.get(productoC);
							System.out.println("Consumidor consume el producto: " + prodConsumido);
							productos.remove(productoC);
							System.out.println("Cantidad actual: " + productos.size());
							try {
								Thread.sleep((int) (Math.random() * 3000));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							lock.notifyAll();
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
