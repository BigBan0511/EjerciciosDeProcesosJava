package hilos;

public class ejemplo1 {

	public static void main(String[] args) {
		Hilo h1 = new Hilo(8);
		h1.start();

	}

}

class Hilo extends Thread{
	private int num;
	
	public Hilo(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < num; i++) {
			System.out.println("Mensaje " + (i+1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
