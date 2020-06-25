package contas.teste;

import javax.persistence.EntityManager;

import contas.util.JPAUtil;

public class TesteJPA {

  public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo

		manager.getTransaction().commit();

		manager.close();

	}
}