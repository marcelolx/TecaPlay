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

import br.edu.pii.tecaplay.ui.ListPlaylists;

public class ListFilesPlaylist {
	private String  paisCanBan;
	private String musicORvideo;
	/**
	 * @param table
	 *            passa a tabela por parâmetro e a partir da mesma seta algumas
	 *            configurações a ela.
	 */

	public void tableInfo(JTable table) {

		// table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setPreferredWidth(43);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);

		table.getColumnModel().getColumn(0).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(99);
		table.getColumnModel().getColumn(3).setMaxWidth(43);
		table.getColumnModel().getColumn(4).setMaxWidth(95);
		table.getColumnModel().getColumn(5).setMaxWidth(60);
		table.getColumnModel().getColumn(6).setMaxWidth(90);

		table.getColumnModel().getColumn(0).setMinWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(99);
		table.getColumnModel().getColumn(3).setMinWidth(43);
		table.getColumnModel().getColumn(4).setMinWidth(95);
		table.getColumnModel().getColumn(5).setMinWidth(60);
		table.getColumnModel().getColumn(6).setMinWidth(90);
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
	public void updateTable(final JTable table, String usrName, String playlistName) {
		String directorie = "c:\\TecaPlay\\" + usrName + "\\Musicas\\Playlist\\"+playlistName;
		System.out.println(directorie);
		System.out.println(playlistName);
		final MyTableModel tableModel = (MyTableModel) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider.loadLines(directorie);
		final Object[][] dados = new Object[fileTextProvider.numOfLines()][7];

		for (int i = 0; i < lines.size(); i++) {
			final String[] data = FileTextProvider.readData("#", lines.get(i));
			dados[i][0] = data[0];
			dados[i][1] = data[1];
			dados[i][2] = data[2];
			dados[i][3] = data[3];
			dados[i][4] = "Adicionar";
			dados[i][5] = "-X-";
			dados[i][6] = "Ouvir";
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
						caminho = data[4];
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
					//removeFile.RemoveTxtLine(table.getSelectedRow(), genero, lines.size(),directorie);
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
				ListPlaylists list = new ListPlaylists(usrName,caminho, "Musicas");
			}
		};
		
		ButtonColumn remover = new ButtonColumn(table, remove, 5);
		remover.setMnemonic(KeyEvent.VK_D);

		ButtonColumn addPlaylist = new ButtonColumn(table, addFavorite, 4);
		addPlaylist.setMnemonic(KeyEvent.VK_D);
		
		ButtonColumn openPlayer = new ButtonColumn(table, open, 6);
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
	public void reUpdateTable(final JTable table, String usrName, String playlistName) {
		// criando um objeto para nossos dados
		final Object[][] dados = null;
		paisCanBan = "Cantor/Banda";
		// chamando o método MyTableModel para adicionar a tabela ao
		// jpanel
		final MyTableModel myTableModel = new MyTableModel(dados, paisCanBan);
		table.setModel(myTableModel);
		tableInfo(table);
		updateTable(table, usrName, playlistName);
	}

	public JTable Tabela(JTable tablee) {
		return tablee;
	}
}
