package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ControllerECF {

	private GerenciadorDeVendas gerenciador = GerenciadorDeVendas.getInstance();

	private String path; // Caminho base
	private String pathToReportPackage; // Caminho para o package onde est�o
										// armazenados os relatorios Jarper

	// Recupera os caminhos para que a classe possa encontrar os relat�rios
	public ControllerECF() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "/jasper/";

	}

	// Imprime/gera uma lista de Clientes
	public void imprimir(Collection<Produto> collection) throws Exception {
		try {
			JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(gerenciador.produtos);
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("", "");

			JasperReport report = JasperCompileManager
					.compileReport(this.getPathToReportPackage() + "cupomNaoFiscal.jrxml");

			// preenche relatorio com par�metros e datasource
			JasperPrint printer = JasperFillManager.fillReport(report, parametros, jrds);

			// abre visualizador
			JasperViewer jv = new JasperViewer(printer, false);
			jv.setTitle("Cupom não fiscal");
			jv.setVisible(true);

			// grava relatorio pdf em disco
			/*
			 * FileOutputStream fos = new
			 * FileOutputStream("C:/Users/Emerson/Desktop/Relatorio.pdf");
			 * JasperExportManager.exportReportToPdfStream(printer, fos);
			 * fos.flush(); fos.close();
			 */
		} catch (Exception e) {
			System.out.println("ERRO DESCONHECIDO - Contacte o suporte");
			e.printStackTrace();
		}
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
}
