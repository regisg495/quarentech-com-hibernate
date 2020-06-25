package jogador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTecnico;
	
	private String nome;
	
	
	@OneToOne
	private Time time;

	public Tecnico(int idTecnico, String nome, Time time) {
		super();
		this.idTecnico = idTecnico;
		this.nome = nome;
		this.time = time;
	}

	public Tecnico(String nome, Time time) {
		super();
		this.nome = nome;
		this.time = time;
	}
	
	public Tecnico(String nome) {
		super();
		this.nome = nome;
	}

	public Tecnico() {
		super();
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
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

	@Override
	public String toString() {
		return "Tecnico [idTecnico=" + idTecnico + ", nome=" + nome + ", time=" + time + "]";
	}
	
	
}
