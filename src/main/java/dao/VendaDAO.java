package dao;

import java.util.List;
import model.Venda;

/**
 *
 * @author Rafael Magnago
 */
public class VendaDAO extends GenericDAO{
    
    private List<Venda> pesquisar(String pesq, int tipo) {
        return listar(Venda.class);
    }

    public List<Venda> pesquisarIdCliente(String pesq) {
        return pesquisar(pesq, 1);
    }
}
