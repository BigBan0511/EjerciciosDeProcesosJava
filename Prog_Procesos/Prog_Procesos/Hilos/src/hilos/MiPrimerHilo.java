package hilos;

public class MiPrimerHilo {

	public static void main(String[] args) {
		//Crear dos hilos
		MiHilo hilo1 = new MiHilo("Hilo 1");
		MiHilo hilo2 = new MiHilo("Hilo 2");
		
		//Iniciar los hilos
		hilo1.start();
		hilo2.start();

	}

}
