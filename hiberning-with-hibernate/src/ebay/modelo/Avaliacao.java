package ebay.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvaliacao;

	@Min(1)
	@Max(5)
	@Column(nullable = false)
	private Integer pontuacao;

	@Column(columnDefinition = "TEXT")
	private String comentario;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "Usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "publicacao", nullable = false)
	private Publicacao publicacao;

	@Deprecated
	public Avaliacao(int idAvaliacao, int pontuacao, String comentario, Usuario usuario, Publicacao publicacao) {
		this.idAvaliacao = idAvaliacao;
		this.pontuacao = pontuacao;
		this.comentario = comentario;
		this.usuario = usuario;
		this.publicacao = publicacao;

	}

	@Deprecated
	public Avaliacao(Integer pontuacao, String comentario, Usuario usuario, Publicacao publicacao) {
		this.pontuacao = pontuacao;
		this.comentario = comentario;
		this.usuario = usuario;
		this.publicacao = publicacao;

	}

	
	public Avaliacao() {
		super();
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	@Override
	public String toString() {
		return "Avaliacao [idAvaliacao=" + idAvaliacao + ", pontuacao=" + pontuacao + ", comentario=" + comentario
				+ "]";
	}

}
