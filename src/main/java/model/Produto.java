package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	
	@Id
	@Column(name="id_produto")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Date dataDeCadastro;
	
	@Column(nullable=false)
	private double valorCusto;
	
	@Column(nullable=false)
	private double valorVenda;
	
	@Column(nullable=false)
	private long quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", dataDeCadastro=" + dataDeCadastro + ", valorCusto="
				+ valorCusto + ", valorVenda=" + valorVenda + ", quantidade=" + quantidade + "]";
	}
	
	

}
