package progSincro;

public class ejemplo2 {

	public static void main(String[] args) {
		Contar contar = new Contar();
		Thread[] hilos = new Thread[1000];
		for (int x = 0; x < 1000; x++) {
			hilos[x] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						contar.incrementar();
					}
				}
			});
			hilos[x].start();
		}
		
		try {
			for (Thread hilo : hilos) {
				hilo.join();
			}
		} catch (InterruptedException e) {
			System.out.println("Hubo un error inesperado");
		}
		System.out.println("Valor final = " + contar.getCuenta());
	}

}

class Contar{
	private int cuenta = 0;
	
	public synchronized void incrementar() {
		this.cuenta++;
	}
	
	public synchronized int getCuenta() {
		return cuenta;
	}
}
