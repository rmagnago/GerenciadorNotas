package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<Nota> notas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "venda_aparelho", joinColumns = @JoinColumn(name = "id_venda"), inverseJoinColumns = @JoinColumn(name = "id_aparelho"))
    private List<Aparelho> aparelhos = new ArrayList<>();

    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "prestacoes", nullable = false)
    private int prestacoes;

    @Column(name = "prestacoes_pagas", nullable = false)
    private int prestacoesPagas;

    @Column(name = "status", nullable = false)
    private boolean status;

    public Venda() {
    }

    public Venda(Cliente cliente, List<Nota> notas, List<Aparelho> aparelhos, Date dataVenda, Double total, int prestacoes) {
        this.cliente = cliente;
        this.notas = notas;
        this.aparelhos = aparelhos;
        this.dataVenda = dataVenda;
        this.total = total;
        this.prestacoes = prestacoes;
        this.prestacoesPagas = 0;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Aparelho> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(List<Aparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getPrestacoes() {
        return prestacoes;
    }

    public void setPrestacoes(int prestacoes) {
        this.prestacoes = prestacoes;
    }

    public int getPrestacoesPagas() {
        return prestacoesPagas;
    }

    public void setPrestacoesPagas(int prestacoesPagas) {
        this.prestacoesPagas = prestacoesPagas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
