package ebay.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ebay.modelo.Publicacao;

public class PublicacaoDAO extends JPAUtil implements IDAO<Publicacao> {

	@Override
	public void save(Publicacao object) {
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
	public Publicacao load(int id) {

		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Publicacao p = em.find(Publicacao.class, id);

			em.getTransaction().commit();

			return p;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}

	}

	@Override
	public List<Publicacao> loadAll() {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			String sql = "FROM Publicacao";

			Query query = em.createQuery(sql);

			List<Publicacao> publicacoes = query.getResultList();

			em.getTransaction().commit();

			return publicacoes;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Publicacao object) {

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
