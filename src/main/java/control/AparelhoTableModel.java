package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aparelho;

/**
 *
 * @author Rafael Magnago
 */
public class AparelhoTableModel extends AbstractTableModel{

    private List<Aparelho> lista = new ArrayList();
    
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
        Aparelho a = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> a.getModelo();
            case 1 -> a.getFabricante();
            case 2 -> a.getEspeficacao();
            case 3 -> a.getPreco();
            default -> "";
        };         
    }
    
    
    @Override
    public String getColumnName(int columnIndex ) {
        return switch (columnIndex) {
            case 0 -> "Modelo";
            case 1 -> "Fabricante";
            case 2 -> "Espeficacao";
            case 3 -> "Preco";
            default -> "";
        };        
    }
    
    
    public void adicionar(Aparelho c) {
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
        
    public void setList(List<Aparelho> novaLista) {
        lista = novaLista;
        fireTableRowsInserted( 0 , lista.size() - 1);
    }
    
    public Aparelho getAparelho(int row) {
        return lista.get(row);
    }
    
    public List<Aparelho> getList() {
        return lista;
    }    
}
