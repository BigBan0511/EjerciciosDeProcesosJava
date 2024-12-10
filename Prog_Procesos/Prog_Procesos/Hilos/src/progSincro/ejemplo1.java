package progSincro;

public class ejemplo1 {

	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();
	}

}

class HiloA extends Thread{
	private Contador contador;

	public HiloA(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 1000; i++) {
				contador.incrementar();
			}
		}
		synchronized (System.out) {
			System.out.println(getName() + " contador vale " + contador.getNum());
		}

	}
}

class HiloB extends Thread{
	private Contador contador;

	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 1000; i++) {
				contador.decrementar();
			}
		}
		synchronized (System.out) {
			System.out.println(getName() + " contador vale " + contador.getNum());
		}
	}
}

class Contador {
	private int num;

	public Contador(int num) {
		this.num = num;
	}

	public synchronized void incrementar() {
		this.num++;
	}

	public synchronized void decrementar() {
		this.num--;
	}

	public synchronized int getNum() {
		return num;
	}
}