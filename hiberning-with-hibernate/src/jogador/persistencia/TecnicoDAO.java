package jogador.persistencia;


import javax.persistence.EntityManager;

import jogador.model.Tecnico;
import jogador.model.Time;

public class TecnicoDAO extends JPAUtil implements IDAO<Tecnico> {

	@Override
	public void save(Tecnico object) {

		EntityManager em = this.getEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(object);
			
			Time t = em.find(Time.class, object.getTime().getIdTime());
			
			t.setTecnico(object);
						
			em.persist(t);
			
			em.getTransaction().commit();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(Tecnico object) {

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
	public Tecnico find(int id) {
		EntityManager em = this.getEntityManager();

		try {

			em.getTransaction().begin();

			Tecnico t = em.find(Tecnico.class, id);

			em.getTransaction().commit();

			return t;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
	

}
