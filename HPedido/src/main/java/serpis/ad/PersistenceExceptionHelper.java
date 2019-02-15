package serpis.ad;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

public class PersistenceExceptionHelper {

	public static void show(PersistenceException ex) {
		if (ex instanceof OptimisticLockException)
			show((OptimisticLockException)ex);
		else if (ex instanceof EntityNotFoundException)
			show((EntityNotFoundException)ex);
		else if (ex instanceof EntityExistsException)
			show((EntityExistsException)ex);
		else
			System.out.println("No se ha podido realizar la operación. Vuelve a intentarlo en unos minutos.");

	}

	public static void show(OptimisticLockException ex) {
		System.out.println("El registro ha sido modificado por otro usuario.");
	}

	public static void show(EntityNotFoundException ex) {
		System.out.println("No existe ese registro.");
	}

	public static void show(EntityExistsException ex) {
		System.out.println("Ese registro ya existe.");
	}
}
