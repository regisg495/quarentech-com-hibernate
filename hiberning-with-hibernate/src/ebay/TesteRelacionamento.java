package ebay;

import java.util.List;

import ebay.modelo.Avaliacao;
import ebay.modelo.Compra;
import ebay.modelo.Publicacao;
import ebay.modelo.Usuario;
import ebay.persistencia.UsuarioDAO;

public class TesteRelacionamento {

	public static void main(String[] args) {

		UsuarioDAO udao = new UsuarioDAO();

		// Pegando o user 1 (Karolina)

		Usuario u = udao.load(1);

		System.out.println("Nome: " + u.getNome() + System.lineSeparator() + "Email: " + u.getEmail());

		// Pegando as compras

		List<Compra> compras = u.getCompras();
		for (Compra compra : compras) {
			Publicacao p = compra.getPublicacao();
			System.out.println(
					"Produto Comprado " + p.getProduto().getNome() + " | Quantidade " + compra.getQuantidade());
		}

		// Pegando todas as compras de todos os Users
		List<Usuario> usuarios = udao.loadAll();

		for (Usuario usuario : usuarios) {
			System.out.println("Nome do Usuário: " + usuario.getNome() + " Login: " + usuario.getLogin());
			compras = usuario.getCompras();
			System.out.println("Compras realizadas");
			for (Compra compra : compras) {
				Publicacao p = compra.getPublicacao();
				System.out.println("Compra de " + p.getProduto().getNome() + " Quantidade " + compra.getQuantidade()
						+ " Total gasto: " + compra.getTotalGasto() + System.lineSeparator());
			}
		}
		
		// Pegando todas as publicacoes de todos os usuários 
		for (Usuario usuario : usuarios) {
			System.out.println("Nome do Usuário: " + usuario.getNome() + " Login: " + usuario.getLogin());
			List<Publicacao> publicacoes = usuario.getPublicacoes();
			for (Publicacao publicacao : publicacoes) {
				System.out.println("Publicacao " + publicacao.getDescricao());
				List<Avaliacao> avaliacoes = publicacao.getAvaliacoes();
				for (Avaliacao avaliacao : avaliacoes) {
					System.out.println("Comentario da avaliação " + avaliacao.getComentario());
				}
			}
		}

	}
}
