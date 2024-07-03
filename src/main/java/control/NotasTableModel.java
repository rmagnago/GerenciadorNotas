package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Nota;

/**
 *
 * @author Rafael Magnago
 */
public class NotasTableModel extends AbstractTableModel {

    private List<Nota> lista = new ArrayList();

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
        Nota nota = lista.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                nota.getVenda().getPrestacoesPagas();
            case 1 ->
                nota.getVenda().getCliente().getNome();
            case 2 ->
                nota.getValor();
            case 3 ->
                nota.getVencimento();
            case 4 ->
                nota.getStatus();
            default ->
                "";
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                "Prestação";
            case 1 ->
                "Cliente";
            case 2 ->
                "Valor";
            case 3 ->
                "Vencimento";
            case 4 ->
                "Paga";
            default ->
                "";
        };
    }

    public void adicionar(Nota c) {
        lista.add(c);
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void remover(int row) {
        lista.remove(row);
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void removeAll() {
        lista.clear();
        fireTableRowsDeleted(lista.size() - 1, lista.size() - 1);
    }

    public void setList(List<Nota> novaLista) {
        lista = novaLista;
        fireTableRowsInserted(0, lista.size() - 1);
    }

    public Nota getNota(int row) {
        return lista.get(row);
    }

    public List<Nota> getList() {
        return lista;
    }
}
