package hilos;

public class ejemplo3 {

	public static void main(String[] args) {
		NombreHilo h1 = new NombreHilo();
		new Thread(h1).start();
		
		NombreHilo h2 = new NombreHilo();
		Thread hilo = new Thread(h2, "Hilo 2");
		hilo.start();
		
		new Thread(new NombreHilo()).start();;
	}

}

class NombreHilo implements Runnable{

	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		System.out.println("Hola desde el hilo " + hiloActual.getName());
		
	}
	
}