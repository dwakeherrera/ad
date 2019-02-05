package serpis.ad;

import javax.persistence.EntityManagerFactory;

public class App {
	private static App instance = new App();
	
	private App() { }
	
	public static App getInstance() {
		return instance;
	}
	
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}
