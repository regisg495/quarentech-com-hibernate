package ebay.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import ebay.modelo.Produto;

public class ProdutoDAO extends JPAUtil implements IDAO<Produto> {

	@Override
	public void save(Produto object) {

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
	public Produto load(int id) {

		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			Produto p = em.find(Produto.class, id);
			
			em.getTransaction().commit();
			
			return p;
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
			
	}

	@Override
	public List<Produto> loadAll() {
		
		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			String sql = "FROM Produto";
			
			Query query = em.createQuery(sql);
			
			List<Produto> produtos = query.getResultList();
			
			em.getTransaction().commit();
			
			return produtos;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		
		
	}

	@Override
	public void delete(Produto object) {

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

}
