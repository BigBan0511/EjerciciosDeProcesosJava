package progSincro;

public class ejemplo3 {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		
		Thread productor = new Thread(() -> {
			try {
				for (int i = 0; i < 20; i++) {
					buffer.producir();
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread consumidor = new Thread(() -> {
			try {
				for (int x = 0; x < 20; x++) {
					buffer.consumir();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		});
		
		productor.start();
		consumidor.start();
	}

}

class Buffer{
	private int capacidad = 10;
	private int contador = 0;
	
	public synchronized void producir() throws InterruptedException {
		while(capacidad == contador) {
			System.out.println("El bufer esta lleno, esperando...");
			wait();
		}
		contador++;
		System.out.println("Producido 1 elemento. Elementos del búfer: " + contador);
		notifyAll();
	}
	
	public synchronized void consumir() throws InterruptedException {
		while(contador == 0) {
			System.out.println("El bufer está vacio, esperando...");
			wait();
		}
		contador--;
		System.out.println("Consumido 1 elemento. Elementos del bufer: " + contador);
		notifyAll();
	}
	
	public int getContador() {
		return contador;
	}
}
