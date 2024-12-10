package ejHilos;

public class ej1 {

	public static void main(String[] args) {
		int[] tiemp = {2,2,1,5,2,3};
		int[] tiemp2 = {1,3,5,1,1};
		SuperMercado1 h1 = new SuperMercado1(tiemp);
		Thread hilo = new Thread(h1, "Cliente 1");
		hilo.start();
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SuperMercado1 h2 = new SuperMercado1(tiemp2);
		Thread hilo2 = new Thread(h2, "Cliente 2");
		hilo2.start();
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("FINISH");

	}

}

class SuperMercado1 implements Runnable{
	private int[] tiempos;
	
	public SuperMercado1(int[] tiempos) {
		this.tiempos = tiempos;
	}

	@Override
	public void run() {
		Thread actual = Thread.currentThread();
		int total = 0;
		for (int i = 0; i < tiempos.length; i++) {
			try {
				System.out.println("\nProducto: " + (i+1));
				System.out.println("Tiempo: " + tiempos[i]);
				actual.sleep(tiempos[i]*1000);
				total = total + tiempos[i];
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Tiempo total: " + total + "s");
	}

}
