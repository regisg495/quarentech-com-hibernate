package ebay.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	
	@Column(length = 100, nullable = false)
	private String  nome;
	
	@Column(columnDefinition = "TEXT", nullable = true)
	private String  descricao;
	
    @Enumerated(EnumType.STRING)
	@Column(columnDefinition = "VARCHAR(50)",  nullable = false)
	private Categoria categoria;
    
    
	public Produto() {
		
	}
	
	@Deprecated	
	public Produto(Integer idProduto, String nome, String descricao, Categoria categoria) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	@Deprecated
	public Produto(String nome, String descricao, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", categoria="
				+ categoria + "]";
	}

}
