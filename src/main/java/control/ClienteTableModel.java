package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author Rafael Magnago
 */
public class ClienteTableModel extends AbstractTableModel{

    private List<Cliente> lista = new ArrayList();
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getNome();
            case 1 -> cliente.getCpf();
            case 2 -> cliente.getEndereco();
            case 3 -> cliente.getContato();
            default -> "";
        };         
    }
    
    
    @Override
    public String getColumnName(int columnIndex ) {
        return switch (columnIndex) {
            case 0 -> "Nome";
            case 1 -> "CPF";
            case 2 -> "Endereço";
            case 3 -> "Contato";
            default -> "";
        };        
    }
    
    
    public void adicionar(Cliente c) {
        lista.add(c);
        fireTableRowsInserted( lista.size() - 1 , lista.size() - 1);
    }
    
    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1 , lista.size() - 1);
    }
    
    public void removeAll() {
        lista.clear();
        fireTableRowsDeleted(lista.size() - 1 , lista.size() - 1);
    }
        
    public void setList(List<Cliente> novaLista) {
        lista = novaLista;
        fireTableRowsInserted( 0 , lista.size() - 1);
    }
    
    public Cliente getCliente(int row) {
        return lista.get(row);
    }
    
    public List<Cliente> getList() {
        return lista;
    }    
}
