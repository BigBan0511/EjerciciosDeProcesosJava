package progSincro;

public class ej1 {

	public static void main(String[] args) {
		Thread[] hilo = new Thread[30];
		int intentos = 0;
		
		for (int x = 0; x < 30; x++) {
			hilo[x] = new Thread(() -> {
				try {
					sala.entrar();
					Thread.sleep(10000);
					sala.salir();
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			hilo[x].start();
		}
	}

}

class HiloEmpleados implements Runnable{
	private int empleados;
	
	public HiloEmpleados(int empleados) {
		this.empleados = empleados;
	}
	
	@Override
	public void run() {
		for (int x = 0; x < this.empleados; x++) {
			Sala sala = new Sala();
			try {
				sala.entrar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

class Sala{
	private int capacidad = 5;
	private int contador = 0;
	
	public synchronized void entrar() throws InterruptedException {
		while(capacidad == contador) {
			System.out.println("Sala llena");
			wait();
		}
		contador++;
		System.out.println("Ha entrado una persona");
		notifyAll();
	}
	
	public synchronized void salir() {
		while(contador == 0) {
			System.out.println("no se puede salir");
		}
		contador--;
		notifyAll();
	}
	
	public int getContador() {
		return contador;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
}