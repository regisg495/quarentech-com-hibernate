package ebay.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ebay.modelo.Compra;
import ebay.modelo.Publicacao;

public class CompraDAO extends JPAUtil implements IDAO<Compra> {

	@Override
	public void save(Compra object) {
		
		
		EntityManager em = this.getEntityManager();
		
		
			em.getTransaction().begin();
			
			Publicacao p = em.merge(object.getPublicacao());
			
			if(p.getQuantidade() < object.getQuantidade()) {
				throw new RuntimeException("Quantidade excede o disponivel");
			}
			
			p.setQuantidade(p.getQuantidade() - object.getQuantidade());
			
			em.getTransaction().commit();
			
		
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
	public Compra load(int id) {
		
		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction();
			
			Compra compra = em.find(Compra.class, id);
			
			em.getTransaction().commit();
			
			return compra;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Compra> loadAll() {
		
		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			String sql = "FROM Compra";
			
			Query query = em.createQuery(sql);
			
			List<Compra> compras = query.getResultList();
			
			em.getTransaction().commit();
			
			return compras;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(Compra object) {
		
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
