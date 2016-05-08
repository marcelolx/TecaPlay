package br.edu.pii.tecaplay.util;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
	
	public MyTableModel(final Object[][] dados){
		super(dados, new String[] {"Nome", "G�nero", "Pa�s", "Ano", "Favoritos"});
	}
	
	public void setDados(final Object[][] dados){
		dataVector = super.convertToVector(dados);
	}
	
	private final Class types[] = new Class[] {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
	private final boolean[] canEdit = new boolean[] {false, false, false, false, false};
	
	public Class getColumnClass(final int columnIndex){
		return types[columnIndex];
	}
	
	public boolean isCellEditable(final int rowIndex, final int columnIndex){
		return canEdit[columnIndex];
	}
}
