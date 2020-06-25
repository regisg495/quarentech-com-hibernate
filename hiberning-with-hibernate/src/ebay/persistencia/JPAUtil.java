package ebay.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private final EntityManagerFactory mf = Persistence.createEntityManagerFactory("hibernate");

	
	public EntityManager getEntityManager() {
		return mf.createEntityManager();
	}

}
