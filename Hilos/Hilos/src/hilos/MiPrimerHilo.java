package hilos;

public class MiPrimerHilo {

	public static void main(String[] args) {
		Thread.currentThread().setName("Principal");
		System.out.println("Este hilo se llama " + Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		HiloEjemplo h1 = null;
		
		for (int i = 0; i < 3; i++) {
			h1 = new HiloEjemplo();
			h1.setName("Hilo " + i);
			h1.setPriority(i + 1);
			h1.start();
			System.out.println("\nINFO del " + h1.getName() + ":" + "\n" + h1.toString()); 
		}

	}

}

class HiloEjemplo extends Thread{
	@Override
	public void run() {
		Thread hilo = Thread.currentThread();
		System.out.println("\nDentro del hilo: " + hilo.getName() + "\nPrioridad: " + hilo.getPriority());
	}
}