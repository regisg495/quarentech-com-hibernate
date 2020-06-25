package ebay.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ebay.modelo.Compra;
import ebay.modelo.Usuario;

public class UsuarioDAO extends JPAUtil implements IDAO<Usuario> {

	@Override
	public void save(Usuario object) {
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
	public Usuario load(int id) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Usuario u = em.find(Usuario.class, id);

			em.getTransaction().commit();

			return u;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			em.close();
		}
	}

	@Override
	public List<Usuario> loadAll() {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			String sql = "FROM Usuario";

			Query query = em.createQuery(sql);

			List<Usuario> usuarios = query.getResultList();

			em.getTransaction().commit();

			return usuarios;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Usuario object) {
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
