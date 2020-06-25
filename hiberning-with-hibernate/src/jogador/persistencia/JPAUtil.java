package jogador.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	EntityManagerFactory mf = Persistence.createEntityManagerFactory("hibernate");

	public EntityManager getEntityManager() {
		return mf.createEntityManager();
	}
}
