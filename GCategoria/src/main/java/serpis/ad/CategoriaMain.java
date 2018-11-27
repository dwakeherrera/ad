package serpis.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriaMain {
	
	private static Scanner scanner = new Scanner(System.in);
	@FunctionalInterface
	public interface Action {
		void execute();
	}

	public static class Menu {
		public static Menu create(String labelMenu) {
			return new Menu(labelMenu);
		}
		
		private String labelMenu;
		private Menu(String labelMenu) {
			this.labelMenu = labelMenu;
		}
		List<String> options = new ArrayList<>();
		List<String> labels = new ArrayList<>();
		List<Action> actions = new ArrayList<>();
		public Menu add(String label, Action action) {
			String option = label.trim().substring(0, 1).toUpperCase();
			options.add(option);
			labels.add(label);
			actions.add(action);
			return this;
		}
		
		private boolean exit = false;
		public Menu exitWhen(String label) {
			return add(label, () -> exit = true);
		}
		
		private void loop() {
			while (!exit) {
				//for (String label : labels)
					//System.out.println(label);
				labels.forEach(item -> System.out.println(item));
				int option = getOption();
				actions.get(option).execute();
			}
		}
		
		private int getOption() {
			while (true) {
				System.out.println("Elige opción: ");
				String option = scanner.nextLine();
				if (options.contains(option))
					return options.indexOf(option);
				System.out.println("Opción inválida. Vuelve a introducir.");
			}
		}
	}
	
	private static boolean exit = false;
	public static void main(String[] args) {
		Menu.create("Menú Categoría")
		.exitWhen("0 - Salir")
		.add("1 - Nuevo", CategoriaMain::nuevo)
		.add("2 - Editar", CategoriaMain::editar)
		.loop();
		
		
		
		
		
		List<Action> actions = new ArrayList<>();
		actions.add( () -> exit = true );
		actions.add( CategoriaMain::nuevo );
		actions.add( CategoriaMain::editar );
		
		/*while (!exit) {
			System.out.println("0 - Salir\n1 - Nuevo\n2 - Editar\nElige opción: ");
			int option = Integer.parseInt(scanner.nextLine());
			actions.get(option).execute();
		}*/
		
		
	}
	
	public static void nuevo() {
		System.out.println("Método nuevo");
	}
	
	public static void editar() {
		System.out.println("Método editar");
	}

}
