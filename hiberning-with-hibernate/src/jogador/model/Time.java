package jogador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTime;
	
	private String nome;
	
	@OneToMany(mappedBy="time")
	private List<Jogador> jogadores;
	
	@OneToOne
	private Tecnico tecnico;

	public Time(String nome, List<Jogador> jogadores, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.jogadores = jogadores;
		this.tecnico = tecnico;
	}

	public Time(String nome, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.tecnico = tecnico;
	}

	public Time() {
		super();
	}

	public Time(String nome) {
		super();
		this.nome = nome;
	}

	public int getIdTime() {
		return idTime;
	}

	public void setIdTime(int idTime) {
		this.idTime = idTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@Override
	public String toString() {
		return "Time [idTime=" + idTime + ", nome=" + nome + ", jogadores=" + jogadores + ", tecnico=" + tecnico + "]";
	}
	
	
	
}
