package dao;

import java.util.List;
import model.Aparelho;

/**
 *
 * @author Rafael Magnago
 */
public class AparelhoDAO extends GenericDAO{
    
    private List<Aparelho> pesquisar(String pesq, int tipo) {
        
        return listar(Aparelho.class);
    }

    public List<Aparelho> pesquisarNome(String pesq) {
        return pesquisar(pesq, 1);
    }

    public List<Aparelho> pesquisarFabricante(String pesq) {
        return pesquisar(pesq, 2);
    }

}
