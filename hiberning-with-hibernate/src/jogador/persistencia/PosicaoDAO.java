package jogador.persistencia;

import javax.persistence.EntityManager;

import jogador.model.Posicao;

public class PosicaoDAO extends JPAUtil implements IDAO<Posicao>{

	@Override
	public void save(Posicao object) {

		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			
			em.persist(object);
			
			
			em.getTransaction().commit();
			
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(Posicao object) {
		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			
			em.remove(object);
			em.getTransaction().commit();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}		
	}

	@Override
	public Posicao find(int id) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Posicao p = em.find(Posicao.class, id);

			em.getTransaction().commit();

			return p;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
			
}
