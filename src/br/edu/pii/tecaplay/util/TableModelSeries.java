package br.edu.pii.tecaplay.util;

import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Marcelo
 *	
 *	Classe que cria a tabela para cada categoria.
 */
public class TableModelSeries extends DefaultTableModel{
	
	public TableModelSeries(final Object[][] dados){
		super(dados, new String[] {"Temporada", "Epis�dio", "S�rie",   "Nome do Epis�dio",   "Tempo", "Favoritos","Excluir","Assistir"});
	}
	
	public void setDados(final Object[][] dados){
		dataVector = super.convertToVector(dados);
	}
	
	private final Class types[] = new Class[] {java.lang.String.class, java.lang.String.class,java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class};
	private final boolean[] canEdit = new boolean[] {false, false, false,false, false, true,true ,true};
	
	public Class getColumnClass(final int columnIndex){
		return types[columnIndex];
	}
	
	public boolean isCellEditable(final int rowIndex, final int columnIndex){
		return canEdit[columnIndex];
	}
}
