package contas.teste;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import contas.modelo.Conta;
import contas.modelo.Movimentacao;
import contas.modelo.TipoMovimentacao;
import contas.util.JPAUtil;

public class TesteConsulta {

	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(2);
		
		//NAMED PARAMETERS NOTATION
		javax.persistence.Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta" 
															+ " and m.tipoMovimentacao = :pTipo" 
															+ " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes =  query.getResultList();
		
		for(Movimentacao m : movimentacoes){
			System.out.println("\nDescri��o ..........: " + m.getDescricao());
			System.out.println("Valor       ..........: R$ " + m.getValor());
		}
	}

}
