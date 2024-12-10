package progSincro;

public class ejemplo4 {

	public static void main(String[] args) {
		Thread thread = new Thread(new HiloInterrumpido());
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}

class HiloInterrumpido implements Runnable{

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("El hilo sigue ejecutandose.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Hilo interrumpido");
				break;
			}
		}

	}

}
