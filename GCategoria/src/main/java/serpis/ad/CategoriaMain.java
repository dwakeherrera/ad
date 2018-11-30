package serpis.ad;

import java.util.Scanner;

public class CategoriaMain {
	private static Scanner scanner = new Scanner(System.in);
	
	private static boolean exit = false;
	public static void main(String[] args) {
		Menu.create("Menú Categoría")
		.add("\t1 - Nuevo", CategoriaMain::nuevo)
		.add("\t2 - Editar", CategoriaMain::editar)
		.exitWhen("\t0 - Salir")
		.loop();		
	}
	
	public static void nuevo() {
		System.out.println("Método nuevo");
	}
	
	public static void editar() {
		System.out.println("Método editar");
		int id = ScannerHelper.getInt("Id: ");
	}
}
