package br.edu.pii.tecaplay.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ListButtonFiles extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, ActionListener
    {
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JTable table;
        JButton renderButton;
        JButton editButton;
        String text;
    
		public ListButtonFiles(JTable table, int column)
        {
			super();
            this.table = table;
            renderButton = new JButton();
            editButton = new JButton();
            editButton.setFocusPainted( false );
            editButton.addActionListener( this );
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer( this );
            columnModel.getColumn(column).setCellEditor( this );
            

        }
        public Component getTableCellRendererComponent1(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
  
            if (hasFocus)
            {
            	System.out.println("dwdoiqwhdwq");
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }
            else if (isSelected)
            {
            	System.out.println("Teste1");
                renderButton.setForeground(table.getSelectionForeground());
                 renderButton.setBackground(table.getSelectionBackground());
            }
            else
            {	System.out.println("teste 2");
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }
            renderButton.setText( (value == null) ? "" : value.toString() );
            return renderButton;
        }
        public Component getTableCellEditorComponent1(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            text = (value == null) ? "" : value.toString();
            editButton.setText( text );
            return editButton;
        }
        public Object getCellEditorValue()
        {
            return text;
        }
        public void actionPerformed1(ActionEvent e)
        {
            fireEditingStopped();
            System.out.println( e.getActionCommand() + " : " + table.getSelectedRow());
        }
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		@Override
		public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
				int arg5) {
			// TODO Auto-generated method stub
			return null;
		}
    }