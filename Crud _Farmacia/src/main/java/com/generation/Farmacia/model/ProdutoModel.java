package com.generation.Farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class ProdutoModel {

	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message= "é obrigatório colocar o nome do produto")
	@Size (min=5, max=100)
	private String nomeProduto;
	
	private int quantidade;
	
	@NotBlank (message= "é obigatorio entrar com a marca do produto")
	@Size (min=5, max=50)
	private String marca;
	
	@Positive (message= "Digite o preço do produto")
	private BigDecimal preco;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private CategoriaModel categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPreço() {
		return preco;
	}

	public void setPreço(BigDecimal preço) {
		this.preco = preço;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
