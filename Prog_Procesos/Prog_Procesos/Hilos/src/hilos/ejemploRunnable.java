package hilos;

public class ejemploRunnable {

	public static void main(String[] args) {
		CajaSupermercado cliente1 = new CajaSupermercado();
		CajaSupermercado cliente2 = new CajaSupermercado();

		Thread h1 = new Thread(cliente1, "Caja1");
		Thread h2 = new Thread(cliente2, "Caja2");

		//Llamar a los clientes uno tras otro
		h1.start();
		try {
			h1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //Esperar a que termine el primero
		
		h2.start();
		
		try {
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //Esperar al segundo
		
		System.out.println("Ambos clientes han terminado sus compras");
	}

}

 class CajaSupermercado implements Runnable{

	@Override
	public void run() {
		Thread actual = Thread.currentThread();
		try {
			actual.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	 
 }
