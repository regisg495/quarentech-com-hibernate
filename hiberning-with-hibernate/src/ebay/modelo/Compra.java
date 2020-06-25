package ebay.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;


@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar data;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Usuario usuario;
	
	@Min(1)
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private BigDecimal totalGasto;
	
	@ManyToOne
	private Publicacao publicacao;

	public Compra() {

	}

	public Compra(int idCompra, Calendar data, Usuario usuario, @Min(1) int quantidade, Publicacao publicacao) {
		super();
		this.idCompra = idCompra;
		this.data = data;
		this.usuario = usuario;
		this.quantidade = quantidade;
		this.publicacao = publicacao;
		this.totalGasto = publicacao.getValor().multiply(new BigDecimal(quantidade));
	}

	public Compra(Calendar data, Usuario usuario, @Min(1) int quantidade, Publicacao publicacao) {
		super();
		this.data = data;
		this.usuario = usuario;
		this.quantidade = quantidade;
		this.publicacao = publicacao;
		this.totalGasto = publicacao.getValor().multiply(new BigDecimal(quantidade));
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public BigDecimal getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(BigDecimal totalGasto) {
		this.totalGasto = totalGasto;
	}
	

}
