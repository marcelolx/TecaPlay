package br.edu.pii.tecaplay.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.edu.pii.tecaplay.player.VLCjPlayer;
import br.edu.pii.tecaplay.ui.ListPlaylists;

/**
 * @since 08/05/2016
 * @author Marcelo
 *
 */
public class ListFilesSeries {
	private String  paisCanBan;
	/**
	 * @param table
	 *            passa a tabela por parâmetro e a partir da mesma seta algumas
	 *            configurações a ela.
	 */

	public void tableInfo(JTable table) {

		// table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);

		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setMaxWidth(70);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(250);
		table.getColumnModel().getColumn(4).setMaxWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(95);
		table.getColumnModel().getColumn(6).setMaxWidth(60);
		table.getColumnModel().getColumn(7).setMaxWidth(90);

		table.getColumnModel().getColumn(0).setMinWidth(70);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(250);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(5).setMinWidth(95);
		table.getColumnModel().getColumn(6).setMinWidth(60);
		table.getColumnModel().getColumn(7).setMinWidth(90);
		table.setRowHeight(25);
		table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
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
	public void updateTable(final JTable table, String usrName, String genero, String nomeSerie) {
		String directorie;
		directorie = "c:\\TecaPlay\\" + usrName + "\\Videos\\serie\\" + genero + "\\nomeSerie\\" + nomeSerie.toLowerCase() + ".txt";
		final TableModelSeries tableModel = (TableModelSeries) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider.loadLines(directorie);
		final Object[][] dados = new Object[fileTextProvider.numOfLines()][8];

		for (int i = 0; i < lines.size(); i++) {
			final String[] data = FileTextProvider.readData("#", lines.get(i));
			dados[i][0] = data[0];
			dados[i][1] = data[1];
			dados[i][2] = data[2];
			dados[i][3] = data[3];
			dados[i][4] = data[4];
			dados[i][5] = "Adicionar";
			dados[i][6] = "-X-";
			dados[i][7] = "Assistir";
		}
		//
		// Ação dos botões assistir

		Action open = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[5];
					}
				}
				VLCjPlayer player = new VLCjPlayer(caminho);
				/**
				 * try { Thread.currentThread().join(); } catch
				 * (InterruptedException e1) { // TODO Auto-generated catch
				 * block e1.printStackTrace(); }
				 */
				/*
				 * Método que abre arquivos de vídeo/musica com player default
				 * do windows try { Desktop.getDesktop().open( new File(caminho)
				 * );
				 * 
				 * System.out.println(" Version: {}" +
				 * LibVlc.INSTANCE.libvlc_get_version()); System.out.println(
				 * " Compiler: {}" + LibVlc.INSTANCE.libvlc_get_compiler());
				 * System.out.println(" ChangeSet: {}" +
				 * LibVlc.INSTANCE.libvlc_get_changeset()); } catch (IOException
				 * e1) { }
				 */
			}
		};

		Action remove = new AbstractAction() {

			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[4];
					}
				}
				int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse filme?", "Excluir", JOptionPane.YES_NO_OPTION);
				if(op == JOptionPane.YES_OPTION){
					RemoveFile removeFile = new RemoveFile();
					removeFile.RemoveTxtLine(table.getSelectedRow(), genero, lines.size(),directorie);
					removeFile.FileRemove(caminho);
					((DefaultTableModel) table.getModel()).removeRow(modelRow);
				}
		
			
			}
		};
		Action addFavorite = new AbstractAction() {

			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[0]+"#"+data[1]+"#"+data[2]+"#"+data[3]+"#"+data[4];
					}
				}
				ListPlaylists list = new ListPlaylists(usrName,caminho,"Videos");
			}
		};
		
		ButtonColumn remover = new ButtonColumn(table, remove, 6);
		remover.setMnemonic(KeyEvent.VK_D);

		ButtonColumn addPlaylist = new ButtonColumn(table, addFavorite, 5);
		addPlaylist.setMnemonic(KeyEvent.VK_D);
		
		ButtonColumn openPlayer = new ButtonColumn(table, open, 7);
		openPlayer.setMnemonic(KeyEvent.VK_D);

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
	public void reUpdateTable(final JTable table, String usrName, String genero, String nomeSerie) {
		// criando um objeto para nossos dados
		final Object[][] dados = null;
	
		// chamando o método MyTableModel para adicionar a tabela ao
		// jpanel
		final TableModelSeries myTableModel = new TableModelSeries(dados);
		table.setModel(myTableModel);
		tableInfo(table);
		updateTable(table, usrName, genero, nomeSerie);
	}

	public JTable Tabela(JTable tablee) {
		return tablee;
	}
	
}
