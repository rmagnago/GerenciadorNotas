package dao;

import java.util.List;
import model.Cliente;
/**
 *
 * @author Rafael Magnago
 */
public class ClienteDAO extends GenericDAO{
    
    private List<Cliente> pesquisar(String pesq, int tipo)  {        

        return listar(Cliente.class);
    }
    
    public List<Cliente> pesquisarNome(String pesq)  {        
        return pesquisar(pesq,1);
    }
    
    public List<Cliente> pesquisarCPF(String pesq)  {        
        return pesquisar(pesq,2);
    }
    
}
