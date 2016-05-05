package controller;

public class Produto {

	private int quantidade;
	private double valorVenda;
	private double valorCusto;
	private String dataCadastro;

	public Produto(String descricao, int quantidade, double valorVenda, double valorCusto) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.valorCusto = valorCusto;
	}

	public Produto() {

	}

	private String descricao;

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the valorVenda
	 */
	public double getValorVenda() {
		return valorVenda;
	}

	/**
	 * @param valorVenda
	 *            the valorVenda to set
	 */
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * @return the valorCusto
	 */
	public double getValorCusto() {
		return valorCusto;
	}

	/**
	 * @param valorCusto
	 *            the valorCusto to set
	 */
	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}

	/**
	 * @return the dataCadastro
	 */
	public String getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro
	 *            the dataCadastro to set
	 */
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}
