package contas.teste;

import javax.persistence.EntityManager;

import contas.modelo.Conta;
import contas.util.JPAUtil;

public class TesteEstadosJPA {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		//Consulta dados no BD passando a class e id desejado da consulta
		Conta conta = manager.find(Conta.class, 3);
		
		System.out.println(conta.getTitular());
		
		//altera dados no BD
		conta.setTitular("Jo�o das Couves");
		
		System.out.println(conta.getTitular());

		manager.getTransaction().commit();
		manager.close();
		
		
		
		
	}

}
