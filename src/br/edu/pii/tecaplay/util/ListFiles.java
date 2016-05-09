package br.edu.pii.tecaplay.util;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;
/**
 * 
 * @author Marcelo
 *
 */
public class ListFiles {
	/**
	 * @param table
	 * 		passa a tabela por parâmetro e a partir da mesma seta algumas configurações a ela.
	 */
	public void tableInfo(JTable table){
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.setBackground(new Color(192,192,192));
		table.getTableHeader().setBackground(new Color(192,192,192));
	}
	/**
	 * 
	 * @param table
	 * Passa a tabela por parãmetro para setar as informações do arquivo .txt na mesma.
	 * @param usrName
	 * 		Necessário para saber qual é o usuário que está logado.
	 * @param genero
	 * 		Necessário para saber em qual gênero o usuário está para listar os filmes.
	 */
	public void updateTable(final JTable table, String usrName, String genero){
		final MyTableModel tableModel = (MyTableModel) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider.loadLines("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\"+genero+".txt");
		final Object[][] dados  = new Object[fileTextProvider.numOfLines()][6];
		for(int i=0; i < lines.size(); i++){				
			final String[] data = FileTextProvider.readData("#", lines.get(i));
			dados[i][0] = data[0];
			dados[i][1] = data[1];
			dados[i][2] = data[2];
			dados[i][3] = data[3];
		}
		
		tableModel.setDados(dados);
		//notifica o componente de que houve alteração, para que ele atualize considerando agora os novos dados
		table.updateUI();
	}
	/**
	 * 
	 * @param table
	 * @param usrName
	 * @param genero
	 * 
	 * Método chamado toda vez que o usuário voltar para um JPanel anterior, ele atualiza o JTable.
	 */
	public void reUpdateTable(final JTable table, String usrName, String genero){
		// criando um objeto para nossos dados
		final Object[][] dados = null;
		// chamando o método MyTableModel para adicionar a tabela ao
		// jpanel
		final MyTableModel myTableModel = new MyTableModel(dados);
		table.setModel(myTableModel);
		tableInfo(table);
		updateTable(table, usrName, genero);
	}
}
