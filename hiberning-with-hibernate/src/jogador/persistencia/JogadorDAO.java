package jogador.persistencia;

import javax.persistence.EntityManager;

import jogador.model.Jogador;

public class JogadorDAO extends JPAUtil implements IDAO<Jogador> {

	@Override
	public void save(Jogador object) {

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
	public void delete(Jogador object) {

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
	public Jogador find(int id) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Jogador j = em.find(Jogador.class, id);

			em.getTransaction().commit();

			return j;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}

	}
}
