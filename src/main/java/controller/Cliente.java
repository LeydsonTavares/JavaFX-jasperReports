package controller;

import java.util.Collection;

public class Cliente {

	private String nomeCliente;
	private String e_mail;
	private String fone;
	private Collection<Produto> carrinhoDeProdutos;
	
	private Collection<Produto> pendentes;
	
	public Cliente(String nomeCliente, String e_mail, String fone, Collection<Produto> carrinhoDeProdutos) {
		super();
		this.nomeCliente = nomeCliente;
		this.e_mail = e_mail;
		this.fone = fone;
		this.carrinhoDeProdutos = carrinhoDeProdutos;
	}

	/**
	 * @return the pendentes
	 */
	public Collection<Produto> getPendentes() {
		return pendentes;
	}

	/**
	 * @param pendentes the pendentes to set
	 */
	public void setPendentes(Collection<Produto> pendentes) {
		this.pendentes = pendentes;
	}

	public Cliente() {

	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente
	 *            the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the e_mail
	 */
	public String getE_mail() {
		return e_mail;
	}

	/**
	 * @param e_mail
	 *            the e_mail to set
	 */
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	/**
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone
	 *            the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the carrinhoDeProdutos
	 */
	public Collection<Produto> getCarrinhoDeProdutos() {
		return carrinhoDeProdutos;
	}

	/**
	 * @param carrinhoDeProdutos
	 *            the carrinhoDeProdutos to set
	 */
	public void setCarrinhoDeProdutos(Collection<Produto> carrinhoDeProdutos) {
		this.carrinhoDeProdutos = carrinhoDeProdutos;
	}

}
