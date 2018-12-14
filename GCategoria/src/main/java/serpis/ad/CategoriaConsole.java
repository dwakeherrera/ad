package serpis.ad;

import java.util.List;

public class CategoriaConsole {
	
	public static long getId() {
		return ScannerHelper.getInt("Elige Id: ");
	}
	
	public static void newCategoria(Categoria categoria) {
		
	}
	
	public static void editCategoria(Categoria categoria) {
		
	}
	
	public static void idNotExists() {
		
	}
	
	public static boolean deleteConfirm() {
		return ScannerHelper.getConfirm("¿Estás seguro que quieres eliminar el registro? (s/N)").equalsIgnoreCase("s");
	}

	public static void show(Categoria categoria) {
		System.out.printf("%4s %s %n", categoria.getId(), categoria.getNombre());
	}
	
	public static void showList(List<Categoria> categorias) {
		for (Categoria categoria : categorias)
			System.out.printf("%4s %s %n", categoria.getId(), categoria.getNombre());
	}
}
