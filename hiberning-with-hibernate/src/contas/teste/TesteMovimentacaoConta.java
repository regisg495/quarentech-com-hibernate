package contas.teste;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import contas.modelo.Conta;
import contas.modelo.Movimentacao;
import contas.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] arg){
		
		EntityManager manager = new JPAUtil().getEntityManager();

		javax.persistence.Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = query.getResultList(); 
		
		for (Conta conta : contas) {
			System.out.println("\nTitular: " + conta.getTitular() + "\nNumero de movimenta��es: " + conta.getMovimentacoes().size());
		}
		
		
		/*
		Conta conta = manager.find(Conta.class, 1);
		
		System.out.println(conta.getMovimentacoes().size());
		*/
		
		
		/*
		Movimentacao mov = manager.find(Movimentacao.class, 2);
		
		System.out.println("Titular conta: " + mov.getConta().getTitular());
		*/
	}
}
