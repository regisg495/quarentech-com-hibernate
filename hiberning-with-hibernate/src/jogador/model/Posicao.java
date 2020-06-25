package jogador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPosicao;
	
	private String nome;
	
	
	public Posicao() {
		super();
	}

	public Posicao(String nome) {
		super();
		this.nome = nome;
	}

	
	
	public int getIdPosicao() {
		return idPosicao;
	}

	public void setIdPosicao(int idPosicao) {
		this.idPosicao = idPosicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Posicao [nome=" + nome + "]";
	}
	
	
	
}
