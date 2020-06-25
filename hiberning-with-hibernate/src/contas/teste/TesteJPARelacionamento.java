package contas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import contas.modelo.Conta;
import contas.modelo.Movimentacao;
import contas.modelo.TipoMovimentacao;
import contas.util.JPAUtil;

public class TesteJPARelacionamento {

  public static void main(String[] args) {

	  	Conta conta = new Conta();
	  	conta.setAgencia("321");
	  	conta.setBanco("HSBC");
	  	conta.setNumero("1236985");
	  	conta.setTitular("Livia");
	  	
	  	Movimentacao mov = new Movimentacao();
	  	mov.setData(Calendar.getInstance());
	  	mov.setDescricao("Conta do BO");
	  	mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
	  	mov.setValor(new BigDecimal("350.05"));
	  	mov.setConta(conta);
	  	
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();

		manager.persist(conta);
		manager.persist(mov);
		
		manager.getTransaction().commit();

		manager.close();

	}
}