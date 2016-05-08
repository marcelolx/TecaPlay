package br.edu.pii.tecaplay.util;

import java.awt.Color;
import java.util.List;

import javax.swing.JTable;

public class ListFiles {
	
	public void tableInfo(JTable table){
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.setBackground(new Color(192,192,192));
		table.getTableHeader().setBackground(new Color(192,192,192));
	}
	
	public void updateTable(final JTable table, String usrName){
		final MyTableModel tableModel = (MyTableModel) table.getModel();
		FileTextProvider fileTextProvider = new FileTextProvider();
		final List<String> lines = FileTextProvider.loadLines("c:\\TecaPlay\\" + usrName + "\\Videos\\filme\\ação.txt");
		final Object[][] dados  = new Object[fileTextProvider.numOfLines()][5];
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
}
