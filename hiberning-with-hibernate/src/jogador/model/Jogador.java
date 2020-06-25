package jogador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJogador;
	
	private String nome;
	
	@ManyToOne
	private Time time;
	
	@ManyToOne
	private Posicao posicao;
	
	

	public Jogador() {
		super();
	}

	public Jogador(int idJogador, String nome, Time time, Posicao posicao) {
		super();
		this.idJogador = idJogador;
		this.nome = nome;
		this.time = time;
		this.posicao = posicao;
	}

	public Jogador(String nome, Time time, Posicao posicao) {
		super();
		this.nome = nome;
		this.time = time;
		this.posicao = posicao;
	}
	
	

	public Jogador(String nome, Posicao posicao) {
		super();
		this.nome = nome;
		this.posicao = posicao;
	}

	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	@Override
	public String toString() {
		return "Jogador [idJogador=" + idJogador + ", nome=" + nome + ", time=" + time + ", posicao=" + posicao + "]";
	}

	
	
	
	
	
	

}
