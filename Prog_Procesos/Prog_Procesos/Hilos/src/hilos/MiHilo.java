package hilos;

public class MiHilo extends Thread{
	private String nombre;
	
	public MiHilo(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(this.nombre + " - Contador: " + i);
			try {
				Thread.sleep(1000); //Pausa el hilo por 1 segundo
			} catch (InterruptedException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
