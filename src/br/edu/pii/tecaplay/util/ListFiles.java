package br.edu.pii.tecaplay.util;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;

/**
 * @since 08/05/2016
 * @author Marcelo
 *
 */
public class ListFiles {
	/**
	 * @param table
	 *            passa a tabela por parâmetro e a partir da mesma seta algumas
	 *            configurações a ela.
	 */
	public void tableInfo(JTable table) {
		// table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		
		table.getColumnModel().getColumn(0).setMaxWidth(350);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(79);
		table.getColumnModel().getColumn(3).setMaxWidth(33);
		table.getColumnModel().getColumn(4).setMaxWidth(75);
		table.getColumnModel().getColumn(5).setMaxWidth(60);
		table.getColumnModel().getColumn(6).setMaxWidth(90);
		
		table.getColumnModel().getColumn(0).setMinWidth(350);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(79);
		table.getColumnModel().getColumn(3).setMinWidth(33);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(5).setMinWidth(60);
		table.getColumnModel().getColumn(6).setMinWidth(90);
		
		table.setBackground(new Color(192, 192, 192));
		table.getTableHeader().setBackground(new Color(192, 192, 192));
	}

	/**
	 * 
	 * @param table
	 *            Passa a tabela por parãmetro para setar as informações do
	 *            arquivo .txt na mesma.
	 * @param usrName
	 *            Necessário para saber qual é o usuário que está logado.
	 * @param genero
	 *            Necessário para saber em qual gênero o usuário está para
	 *            listar os filmes.
	 */
	public void updateTable(final JTable table, String usrName, String genero) {
		final MyTableModel tableModel = (MyTableModel) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider
				.loadLines("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\" + genero + ".txt");
		final Object[][] dados = new Object[fileTextProvider.numOfLines()][7];

		for (int i = 0; i < lines.size(); i++) {
			final String[] data = FileTextProvider.readData("#", lines.get(i));
			dados[i][0] = data[0];
			dados[i][1] = data[1];
			dados[i][2] = data[2];
			dados[i][3] = data[3];
			dados[i][5] = "-X-";
			dados[i][6] = "Assistir";
		}
		//
		// Ação dos botões assistir

		Action open = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[4];
					}
				}
				try {
					Desktop.getDesktop().open( new File(caminho) );
				} catch (IOException e1) {
				}
			}
		};
		
	Action remove = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[4];
					}
				}
			}
		};
		ColumnButtonRemove remover = new ColumnButtonRemove(table, remove, 5, genero, usrName, lines.size());
		remover.setMnemonic(KeyEvent.VK_D);
			
		ButtonColumn buttonColumn = new ButtonColumn(table, open, 6);
		buttonColumn.setMnemonic(KeyEvent.VK_D);

		//
		tableModel.setDados(dados);
		// notifica o componente de que houve alteração, para que ele atualize
		// considerando agora os novos dados
		table.updateUI();
	}

	/**
	 * 
	 * @param table
	 * @param usrName
	 * @param genero
	 * 
	 *            Método chamado toda vez que o usuário voltar para um JPanel
	 *            anterior, ele atualiza o JTable.
	 */
	public void reUpdateTable(final JTable table, String usrName, String genero) {
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
