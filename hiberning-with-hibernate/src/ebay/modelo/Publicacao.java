package ebay.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publicacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPublicacao;

	@Column(nullable = false)
	private BigDecimal valor;

	@Column(nullable = false)
	private Integer quantidade;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar data;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Produto produto;

	@OneToMany(mappedBy="publicacao", fetch = FetchType.EAGER)
	private List<Avaliacao> avaliacoes;
	
	@OneToMany(mappedBy="publicacao")
	private List<Compra> compras;

	public Publicacao() {
	}

	@Deprecated
	public Publicacao(BigDecimal valor, Integer quantidade, String descricao, Calendar data, Usuario usuario,
			Produto produto) {
		super();
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.data = data;
		this.usuario = usuario;
		this.produto = produto;
	}

	@Deprecated
	public Publicacao(int idPublicacao, BigDecimal valor, Integer quantidade, String descricao, Calendar data,
			Usuario usuario, Produto produto) {
		super();
		this.idPublicacao = idPublicacao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.data = data;
		this.usuario = usuario;
		this.produto = produto;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Publicacao [idPublicacao=" + idPublicacao + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", descricao=" + descricao + ", data=" + data + "]";
	}

}
