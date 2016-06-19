package br.edu.pii.tecaplay.util.table;

import javax.swing.table.DefaultTableModel;

/**
 * Classe que cria a tabela para a categoria Séries, que precisa de um modelo
 * diferente das demais.
 * 
 * @author Marcelo
 */
public class TableModelSeries extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableModelSeries(final Object[][] dados) {
		super(dados, new String[] { "Temporada", "Episódio", "Série", "Nome do Episódio", "Tempo", "Favoritos",
				"Excluir", "Assistir" });
	}

	public void setDados(final Object[][] dados) {
		dataVector = super.convertToVector(dados);
	}

	private final Class<?> types[] = new Class[] { java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class };
	private final boolean[] canEdit = new boolean[] { false, false, false, false, false, true, true, true };

	public Class<?> getColumnClass(final int columnIndex) {
		return types[columnIndex];
	}

	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return canEdit[columnIndex];
	}
}
