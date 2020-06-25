package jogador.persistencia;


import javax.persistence.EntityManager;
import jogador.model.Time;

public class TimeDAO extends JPAUtil implements IDAO<Time> {
	

	@Override
	public void save(Time object) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(object);
			
			em.getTransaction().commit();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Time object) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			em.remove(object);
			em.getTransaction().commit();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	@Override
	public Time find(int id) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Time t = em.find(Time.class, id);

			em.getTransaction().commit();

			return t;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
	
}
