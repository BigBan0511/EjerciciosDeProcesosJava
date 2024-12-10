package ej1;

public class ejercicio1 {
	
	public static void main(String[] args) throws InterruptedException {
		Super1 s1 = new Super1("Cliente 1");
		Super1 s2 = new Super1("Cliente 2");
		Thread h1 = new Thread(s1, "Caja 1");
		Thread h2 = new Thread(s2, "Caja 2");
		
		h1.start();
		h1.join();
		h2.start();
		h2.join();
		
		System.out.println("Ambos clientes han terminado");
		
		Super2 s3 = new Super2("Cliente 1");
		Super2 s4 = new Super2("Cliente 2");
		Thread h3 = new Thread(s1, "Caja 1");
		Thread h4 = new Thread(s2, "Caja 2");
		
		h3.start();
		h4.start();
		h3.join();
		h4.join();
	}
	
}


class Super1 implements Runnable{
	private String nombreCliente;
	
	public Super1(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	@Override
	public void run() {
		System.out.println("Atendiendo al "+ this.nombreCliente + " en la " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El cliente " + this.nombreCliente + " ha terminado en la " + Thread.currentThread().getName());
	}
	
}

class Super2 implements Runnable{
private String nombreCliente;
	
	public Super2(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	@Override
	public void run() {
		System.out.println("Atendiendo al "+ this.nombreCliente + " en la " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El cliente " + this.nombreCliente + " ha terminado en la " + Thread.currentThread().getName());
	}
	
}