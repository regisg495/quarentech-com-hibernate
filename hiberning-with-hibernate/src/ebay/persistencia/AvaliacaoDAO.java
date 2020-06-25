package ebay.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ebay.modelo.Avaliacao;

public class AvaliacaoDAO extends JPAUtil implements IDAO<Avaliacao> {

	@Override
	public void save(Avaliacao object) {

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
	public Avaliacao load(int id) {

		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			Avaliacao av = em.find(Avaliacao.class, id);
			
			em.getTransaction().commit();
			
			return av;
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Avaliacao> loadAll() {

		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			String sql = "FROM Avaliacao";
			
			Query query = em.createQuery(sql);
			
			List<Avaliacao> avs = query.getResultList();
			
			em.getTransaction().commit();
			
			return avs;
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Avaliacao object) {

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

	
	
}
