package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorDeVendas {

	Map<Cliente, Produto> vendas = new LinkedHashMap<Cliente, Produto>();

	List<Cliente> clientes = new ArrayList<Cliente>();

	Collection<Produto> produtos = new ArrayList<Produto>();

	private static GerenciadorDeVendas instance = new GerenciadorDeVendas();

	public static GerenciadorDeVendas getInstance() {
		return instance;

	}

	public GerenciadorDeVendas() {

		// Clientes cadastrados para teste

		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();

		c1.setNomeCliente("Leydson Tavares");
		c1.setE_mail("leydson_tavares@hotmail.com");
		c1.setFone("98770-8212");

		c2.setNomeCliente("Arthur Martins");
		c2.setE_mail("arthur_martins@hotmail.com");
		c2.setFone("98212-8770");

		clientes.add(c1);
		clientes.add(c2);

		// Produtos cadastrados para teste
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto p3 = new Produto();
		Produto p4 = new Produto();
		Produto p5 = new Produto();

		p1.setDescricao("CocaCola");
		p1.setQuantidade(20);
		p1.setValorCusto(1.25);
		p1.setValorVenda(2.50);
		p1.setDataCadastro("19/01/2016");

		p2.setDescricao("Pepsi");
		p2.setQuantidade(25);
		p2.setValorCusto(1.00);
		p2.setValorVenda(2.00);
		p2.setDataCadastro("19/01/2016");

		p3.setDescricao("Simba");
		p3.setQuantidade(50);
		p3.setValorCusto(1.00);
		p3.setValorVenda(2.00);
		p3.setDataCadastro("19/01/2016");

		p4.setDescricao("Sprite");
		p4.setQuantidade(30);
		p4.setValorCusto(1.15);
		p4.setValorVenda(2.50);
		p4.setDataCadastro("19/01/2016");

		p5.setDescricao("Skol");
		p5.setQuantidade(30);
		p5.setValorCusto(2.29);
		p5.setValorVenda(4.00);
		p5.setDataCadastro("19/01/2016");

		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		produtos.add(p5);

	}

	public void adicionarClientes(Cliente cliente) {
		clientes.add(cliente);

	}

	public void adicionarProdutos(Produto produto) {
		produtos.add(produto);
	}

	public void removeCliente(Cliente cliente) {
		clientes.remove(cliente);

	}

	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
	public void efetuarVenda(Cliente cliente,Collection<Produto> produtos){
		cliente.setCarrinhoDeProdutos(produtos);
	}
	public void atualizarEstoque(Produto produto, int newQuantidade){
		produto.setQuantidade(produto.getQuantidade() - newQuantidade );
	}
	public void inserirPendencia(Cliente cliente, Collection<Produto> produtos ){
		cliente.setPendentes(produtos);
		
	}
}
