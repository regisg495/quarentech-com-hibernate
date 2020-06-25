package ebay.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(unique = true, length = 50, nullable = false)
	private String email;

	@Column(unique = true, length = 30, nullable = false)
	private String login;

	@Column(length = 32, nullable = false)
	private String senha;

	@Column(length = 500, nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Compra> compras;

	@OneToMany(mappedBy = "usuario",  fetch = FetchType.EAGER)
	private List<Publicacao> publicacoes;
	
	@OneToMany(mappedBy = "publicacao", fetch = FetchType.EAGER)
	private List<Avaliacao> avaliacoes;
	

	public Usuario() {

	}

	@Deprecated
	public Usuario(int idUsuario, String nome, String email, String login, String senha, String endereco) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
	}

	@Deprecated
	public Usuario(String nome, String email, String login, String senha, String endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}


	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", login=" + login
				+ ", senha=" + senha + ", endereco=" + endereco + "]";
	}

}
