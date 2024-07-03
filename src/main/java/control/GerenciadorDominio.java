package control;

import dao.*;
import java.util.Date;
import java.util.List;
import model.*;
import org.hibernate.HibernateException;

/**
 *
 * @author Rafael Magnago
 */
public class GerenciadorDominio {

    private GenericDAO genericDAO;
    private ClienteDAO clienteDAO;
    private AparelhoDAO aparelhoDAO;
    private VendaDAO vendaDAO;
    private NotaDAO notaDAO;

    public GerenciadorDominio() throws HibernateException {
        ConexaoHibernate.getSessionFactory().openSession();
        genericDAO = new GenericDAO();
        clienteDAO = new ClienteDAO();
        aparelhoDAO = new AparelhoDAO();
        vendaDAO = new VendaDAO();
        notaDAO = new NotaDAO();
    }

    public List listar(Class classe) throws HibernateException {
        return genericDAO.listar(classe);
    }

    public void excluir(Object obj) throws HibernateException {
        genericDAO.excluir(obj);
    }

    //  Cliente
    public int inserirCliente(String cpf, String nome, String contato, String endereco) throws HibernateException {
        Cliente novoCliente = new Cliente(cpf, nome, contato, endereco);
        clienteDAO.inserir(novoCliente);
        return novoCliente.getId();
    }

    /*    public int alterarCliente(Cliente cliente, String cpf, String nome, String contato, String endereco) throws HibernateException {
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setContato(contato);
        cliente.setEndereco(endereco);

        clienteDAO.alterar(cliente);
        return Integer.parseInt(cliente.getCpf());
    }   */
    
    //  Aparelho
    public int inserirAparelho(String modelo, String fabricante, String espec, double preco) throws HibernateException {

        Aparelho novoAparelho = new Aparelho(modelo, fabricante, espec, preco);
        aparelhoDAO.inserir(novoAparelho);
        return novoAparelho.getId();
    }

    /*    public int alterarAparelho(Aparelho novoAparelho, String modelo, double preco, String fabricante, String espec) throws HibernateException {

        a.setModelo(modelo);
        a.setPreco(preco);
        a.setFabricante(fabricante);
        a.setEspeficacao(espec);

        aparelhoDAO.alterar(a);

        return a.getId();
    }   */
    
    //  Venda
    public int inserirVenda(Cliente cliente, List<Nota> notas, List<Aparelho> aparelhos, Date dataVenda, Double total, int prestacoes) throws HibernateException {

        Venda novaVenda = new Venda(cliente, notas, aparelhos, dataVenda, total, prestacoes);
        genericDAO.inserir(novaVenda);
        return novaVenda.getId();
    }

}
