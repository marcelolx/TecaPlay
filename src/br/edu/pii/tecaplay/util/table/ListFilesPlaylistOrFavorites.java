package br.edu.pii.tecaplay.util.table;

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

import br.edu.pii.tecaplay.player.MusicPlayer;
import br.edu.pii.tecaplay.player.VLCjPlayer;
import br.edu.pii.tecaplay.ui.ListPlaylists;
import br.edu.pii.tecaplay.util.FileTextProvider;
import br.edu.pii.tecaplay.util.RemoveFile;

/**
 * Classe que trabalha com listagem e configura��es da tabela que exibe as
 * informa��es dos v�deos/m�sicas nas telas de Favoritos ou Playlists.
 * 
 * @author Marcelo
 *
 */

public class ListFilesPlaylistOrFavorites {
	private String paisCanBan;

	/**
	 * @param table
	 *            passa a tabela por par�metro e a partir da mesma seta algumas
	 *            configura��es a ela.
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
	 * Popula a tabela atrav�s das informa��es do arquivo .txt X, que �
	 * recuperado atrav�s dos parametros passados pelo m�todo.
	 * 
	 * @param table
	 *            Passa a tabela por par�metro para setar as informa��es do
	 *            arquivo .txt na mesma.
	 * @param usrName
	 *            Necess�rio para saber qual � o usu�rio que est� logado.
	 * @param genero
	 *            Necess�rio para saber em qual g�nero o usu�rio est� para
	 *            listar os filmes.
	 */
	public void updateTable(final JTable table, String usrName, String playlistName, String favORplay) {
		String directorie;
		if (favORplay.equals("Playlist")) {
			directorie = "c:\\TecaPlay\\" + usrName + "\\Musicas\\Playlist\\" + playlistName;
		} else {
			directorie = "c:\\TecaPlay\\" + usrName + "\\Videos\\Favoritos\\" + playlistName;
		}
		final MyTableModel tableModel = (MyTableModel) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider.loadLines(directorie);
		final Object[][] dados = new Object[fileTextProvider.numOfLines()][7];
		String[] mediapath = new String[fileTextProvider.numOfLines()];
		for (int i = 0; i < lines.size(); i++) {
			final String[] data = FileTextProvider.readData("#", lines.get(i));
			dados[i][0] = data[0];
			dados[i][1] = data[1];
			dados[i][2] = data[2];
			dados[i][3] = data[3];
			mediapath[i] = data[4];
			dados[i][4] = "Adicionar";
			dados[i][5] = "-X-";
			dados[i][6] = "Ouvir";
		}
		//
		// A��o dos bot�es assistir
		MusicPlayer.playAll(mediapath);
		Action open = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[4];
					}
				}
				new VLCjPlayer(caminho);
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
				int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse filme?", "Excluir",
						JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
					RemoveFile removeFile = new RemoveFile();
					// removeFile.RemoveTxtLine(table.getSelectedRow(), genero,
					// lines.size(),directorie);
					removeFile.fileRemove(caminho);
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
				String caminho = null;
				for (int i = 0; i < lines.size(); i++) {
					final String[] data = FileTextProvider.readData("#", lines.get(i));
					if (i == table.getSelectedRow()) {
						caminho = data[0] + "#" + data[1] + "#" + data[2] + "#" + data[3] + "#" + data[4];
					}
				}
				new ListPlaylists(usrName, caminho, "Musicas");
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
		// notifica o componente de que houve altera��o, para que ele atualize
		// considerando agora os novos dados
		table.updateUI();
	}

	/**
	 * M�todo chamado toda vez que o usu�rio voltar para um JPanel anterior, ele
	 * atualiza o JTable.
	 * 
	 * @param table
	 * @param usrName
	 * @param genero
	 */
	public void reUpdateTable(final JTable table, String usrName, String playlistName, String favORplay) {
		// criando um objeto para nossos dados
		final Object[][] dados = null;
		paisCanBan = "Cantor/Banda";
		// chamando o m�todo MyTableModel para adicionar a tabela ao
		// jpanel
		final MyTableModel myTableModel = new MyTableModel(dados, paisCanBan);
		table.setModel(myTableModel);
		tableInfo(table);
		updateTable(table, usrName, playlistName, favORplay);
	}

}
