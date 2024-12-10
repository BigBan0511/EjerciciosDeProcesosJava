package hilos;

public class ejemplo2 {

	public static void main(String[] args) {
		Hilo2 h1 = new Hilo2("Hilo1");
		Hilo2 h2 = new Hilo2("Hilo2");
		Hilo2 h3 = new Hilo2("Hilo3");
		
		h1.start();
		h2.start();
		h3.start();
	}

}

class Hilo2 extends Thread{
	private String nombre;
	
	public Hilo2(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hilo: " + this.nombre + " contador " + (i + 1));
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
