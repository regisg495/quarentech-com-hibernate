package ebay;

import java.math.BigDecimal;
import java.util.Calendar;

import ebay.modelo.Avaliacao;
import ebay.modelo.Categoria;
import ebay.modelo.Compra;
import ebay.modelo.Produto;
import ebay.modelo.Publicacao;
import ebay.modelo.Usuario;
import ebay.persistencia.AvaliacaoDAO;
import ebay.persistencia.CompraDAO;
import ebay.persistencia.ProdutoDAO;
import ebay.persistencia.PublicacaoDAO;
import ebay.persistencia.UsuarioDAO;

public class PopularBD {

	public static void main(String[] args) throws Exception {

		Produto p1 = new Produto("Notebook Dell Inspiron 15", "Notebook i7", Categoria.Notebooks);
		Produto p2 = new Produto("Ritalina 10 mg", "Ritalina 10 mg", Categoria.Medicamento);
		Produto p3 = new Produto("Toalha para Mesa", "Uma toalha para mesa", Categoria.Cozinha);
		Produto p4 = new Produto("TV Samsumg 49", "Televisao Samsumg de 49 polegadas", Categoria.Televisor);
		Produto p5 = new Produto("Sofa Imperial", "Sofa dos Monarcas", Categoria.Sala);
		Produto p6 = new Produto("Shampoo Clear Men do CR7", "O Shampoo do CR7", Categoria.Banheiro);
		Produto p7 = new Produto("Frigideira de Inox", "Muito boa", Categoria.Cozinha);
		Produto p8 = new Produto("PC Gamer AlienWare", "O ideal para games", Categoria.Computador);
		Produto p9 = new Produto("Macbook Pro", "Caro mas bom", Categoria.Notebooks);
		Produto p10 = new Produto("Guarda roupas Luis XV", "Outro movel imperial", Categoria.Quarto);

		Usuario u1 = new Usuario("Karolina", "karolina@gmail.com", "karolinag11", "3123981", "Rua tal 1");
		Usuario u2 = new Usuario("Regis", "regis@gmail.com", "regisg", "31232132", "Rua tal 2");
		Usuario u3 = new Usuario("Tiago", "tiago@gmail.com", "tiagog191", "4234234", "Rua tal 3");
		Usuario u4 = new Usuario("Rafael", "rafael@gmail.com", "rafa13121", "31322131", "Rua tal 4");
		Usuario u5 = new Usuario("Camila", "camila@gmail.com", "Camila49328", "5345643654", "Rua tal 5");
		Usuario u6 = new Usuario("Taina", "taina@gmail.com", "taina3111", "645645645", "Rua tal 6");
		Usuario u7 = new Usuario("Cristiano", "cristiano@gmail.com", "Cristiano423", "423423423", "Rua tal 7");
		Usuario u8 = new Usuario("Joilson", "joilsonr8q2@gmail.com", "Joilson000", "756756756", "Rua tal 8");

		Publicacao pub1 = new Publicacao(new BigDecimal(90000), 30, "Compra de uns Notebook", Calendar.getInstance(),
				u1, p1);
		Publicacao pub2 = new Publicacao(new BigDecimal(100), 10, "Compra de umas toalha", Calendar.getInstance(), u2,
				p3);
		Publicacao pub3 = new Publicacao(new BigDecimal(4000), 1, "Compra de uma Televisao", Calendar.getInstance(), u3,
				p4);
		Publicacao pub4 = new Publicacao(new BigDecimal(4000), 1, "Compra de um Sofa Imperial", Calendar.getInstance(),
				u1, p5);
		Publicacao pub5 = new Publicacao(new BigDecimal(500), 50, "Compra do Shampoo do CR7", Calendar.getInstance(),
				u6, p6);
		Publicacao pub6 = new Publicacao(new BigDecimal(8000), 1, "Compra de um MacBook", Calendar.getInstance(), u5,
				p9);
		Publicacao pub7 = new Publicacao(new BigDecimal(200000), 10, "Compra de uns guarda roupas Luis XV",
				Calendar.getInstance(), u7, p10);
		Publicacao pub8 = new Publicacao(new BigDecimal(10000), 1, "Compra de um Notebook AlienWare",
				Calendar.getInstance(), u1, p8);
		Publicacao pub9 = new Publicacao(new BigDecimal(500), 10, "Compra de algumas Frigideiras",
				Calendar.getInstance(), u1, p7);
		Publicacao pub10 = new Publicacao(new BigDecimal(3000), 10, "Compra de um Notebook", Calendar.getInstance(), u6,
				p1);

		Compra c1 = new Compra(Calendar.getInstance(), u1, 15, pub1);
		Compra c2 = new Compra(Calendar.getInstance(), u2, 4, pub2);
		Compra c3 = new Compra(Calendar.getInstance(), u3, 1, pub3);
		Compra c4 = new Compra(Calendar.getInstance(), u1, 1, pub4);
		Compra c5 = new Compra(Calendar.getInstance(), u2, 34, pub5);
		Compra c6 = new Compra(Calendar.getInstance(), u5, 1, pub6);
		Compra c7 = new Compra(Calendar.getInstance(), u6, 6, pub7);
		Compra c8 = new Compra(Calendar.getInstance(), u8, 1, pub8);
		Compra c9 = new Compra(Calendar.getInstance(), u1, 2, pub9);
		Compra c10 = new Compra(Calendar.getInstance(), u3, 1, pub10);

		
		Avaliacao av = new Avaliacao(4, "Muito bom", u1, pub1);
		Avaliacao av2 = new Avaliacao(2, "Legal", u3, pub7);
		Avaliacao av3 = new Avaliacao(3, "Gostei", u3, pub3);
		Avaliacao av4 = new Avaliacao(5, "Excelente", u5, pub4);
		Avaliacao av5 = new Avaliacao(2, "Legal", u2, pub3);
		Avaliacao av6 = new Avaliacao(2, "Legal", u2, pub5);
		Avaliacao av7 = new Avaliacao(4, "Muito bom", u1, pub6);
		Avaliacao av8 = new Avaliacao(4, "Muito bom", u6, pub7);
		Avaliacao av9 = new Avaliacao(5, "Excelente", u5, pub8);
		Avaliacao av10 = new Avaliacao(5, "Excelente", u4, pub2);
		Avaliacao av11 = new Avaliacao(5, "Excelente", u3, pub3);
		Avaliacao av12 = new Avaliacao(1, "Nao curti", u2, pub4);
		

		UsuarioDAO udao = new UsuarioDAO();
		
		ProdutoDAO pdao = new ProdutoDAO();

		CompraDAO cdao = new CompraDAO();

		PublicacaoDAO pubdao = new PublicacaoDAO();
		
		AvaliacaoDAO avdao = new AvaliacaoDAO();

		try {
		
		pdao.save(p1);
		pdao.save(p2);
		pdao.save(p3);
		pdao.save(p4);
		pdao.save(p5);
		pdao.save(p6);
		pdao.save(p7);
		pdao.save(p8);
		pdao.save(p9);
		pdao.save(p10);

		udao.save(u1);
		udao.save(u2);
		udao.save(u3);
		udao.save(u4);
		udao.save(u5);
		udao.save(u6);
		udao.save(u7);
		udao.save(u8);

		pubdao.save(pub1);
		pubdao.save(pub2);
		pubdao.save(pub3);
		pubdao.save(pub4);
		pubdao.save(pub5);
		pubdao.save(pub6);
		pubdao.save(pub7);
		pubdao.save(pub8);
		pubdao.save(pub9);
		pubdao.save(pub10);
		
		cdao.save(c1);
		cdao.save(c2);
		cdao.save(c3);
		cdao.save(c4);
		cdao.save(c5);
		cdao.save(c6);
		cdao.save(c7);
		cdao.save(c8);
		cdao.save(c9);
		cdao.save(c10);

		avdao.save(av);
		avdao.save(av2);
		avdao.save(av3);
		avdao.save(av4);
		avdao.save(av5);
		avdao.save(av6);
		avdao.save(av7);
		avdao.save(av8);
		avdao.save(av9);
		avdao.save(av10);
		avdao.save(av11);
		avdao.save(av12);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
