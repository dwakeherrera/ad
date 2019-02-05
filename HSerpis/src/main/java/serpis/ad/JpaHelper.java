package serpis.ad;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaHelper {
	private static void doInJPA(EntityManagerFactory entityManagerFactory, Consumer<EntityManager> consumer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		consumer.accept(entityManager);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private static <R> R doInJPA(EntityManagerFactory entityManagerFactory, Function<EntityManager, R> function) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		R result = function.apply(entityManager);
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}
}
