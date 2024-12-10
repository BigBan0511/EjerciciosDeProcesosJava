package hilos;

public class ejemploSupermercado {

	public static void main(String[] args) {
		SuperMercado1 h1 = new SuperMercado1();
		Thread hilo = new Thread(h1, "Cliente x");
		hilo.start();
		
		Super2 h2 = new Super2();
		Thread hilo2 = new Thread(h2, "Cliente x");
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hilo2.start();
	}

}

class SuperMercado1 implements Runnable{

	@Override
	public void run() {
		Thread actual = Thread.currentThread();
		System.out.println("Atendiendo a cliente X en la caja Y");
		try {
			actual.sleep(5000);
			System.out.println("Atendiendo a cliente Y en la caja X");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Super2 implements Runnable{

	@Override
	public void run() {
		Thread actual = Thread.currentThread();
		System.out.println("Los 2");

	}

}
