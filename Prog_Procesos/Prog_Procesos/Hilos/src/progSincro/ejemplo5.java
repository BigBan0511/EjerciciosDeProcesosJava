package progSincro;

public class ejemplo5 {

	public static void main(String[] args) {
		HiloConBandera tarea = new HiloConBandera();
		Thread hilo = new Thread(tarea);
		hilo.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tarea.detener();
	}

}

class HiloConBandera implements Runnable{
	private volatile boolean running = true;

	@Override
	public void run() {
		while(running) {
			try {
				System.out.println("El hilo sigue ejecutandose.");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}

		if(!running) {
			System.out.println("El hilo ha terminado");
		}
	}

	public void detener() {
		running = false;
	}
}