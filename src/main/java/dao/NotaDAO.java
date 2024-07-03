package dao;

import java.util.List;
import model.Nota;

/**
 *
 * @author Rafael Magnago
 */
public class NotaDAO extends GenericDAO{
    private List<Nota> pesquisar(String pesq, int tipo) {
        return listar(Nota.class);
    }

    public List<Nota> pesquisarIdCliente(String pesq) {
        return pesquisar(pesq, 1);
    }
}
