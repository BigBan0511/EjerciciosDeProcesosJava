package ejHilos;

import java.util.ArrayList;
import java.util.Scanner;

public class ej2 {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		System.out.println("Introduza el numero de cajas abiertas");
		int numCajas = datos.nextInt();
		System.out.println("Introduzca el numero de clientes");
		int clientes = datos.nextInt();
		ArrayList<ArrayList<Integer>> numProd = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> prod = new ArrayList<Integer>();
		int numProductos = 1;
		while(numProductos != 0) {
			System.out.println("Introduzca el numero de productos, introduzca 0 para salir");
			numProductos = datos.nextInt();
			prod.add(numProductos);
		}
		for (int i = 0; i < clientes; i++) {
			numProd.add(prod);
		}
		int caja = (int)(Math.random()*(numCajas+1));
		if(numCajas >= 1 && numCajas <=5) {
			if(clientes >= 1 && clientes <= 7) {
				int[] tiempoProd = new int[numProductos];
				for (int x = 0; x < tiempoProd.length; x++) {
					tiempoProd[x] = (int)(Math.random()*6);
				}
				if((numCajas/clientes) == 0) {
					
				}else {
					clientes = clientes - 1;
					//A una caja aleatoria con int caja ponerle +1
				}
				ArrayList<Cajas> cajas = new ArrayList<Cajas>();
				for (Cajas actual : cajas) {
					Thread hilo = new Thread((actual = new Cajas(tiempoProd, clientes, prod)), "Cliente " + (Integer.toString(clientes)));
					hilo.start();
					try {
						hilo.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}

class Cajas implements Runnable{
	private int[] tiempos;
	private int clientes;
	private ArrayList<Integer> productos;
	
	public Cajas(int[] tiempos, int clientes, ArrayList<Integer> productos) {
		this.tiempos = tiempos;
		this.clientes = clientes;
		this.productos = productos;
	}

	@Override
	public void run() {
		Thread actual = Thread.currentThread();
		int total = 0;
		for (int x = 0; x < clientes;) {
			for (int i = 0; i < tiempos.length; i++) {
				try {
					System.out.println("\nProducto: " + (i+1));
					System.out.println("Tiempo: " + tiempos[i]);
					actual.sleep(tiempos[i]*1000);
					total = total + tiempos[i];
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			x++;
		}
		System.out.println("Tiempo total: " + total + "s");
	}

}
