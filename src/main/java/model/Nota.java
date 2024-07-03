package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rafael Magnago
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private int id;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "prestacao", nullable = false)
    private String prestacao;

    @Column(name = "vencimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vencimento;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public Nota() {
    }

    public Nota(Double valor, String prestacao, Date vencimento) {
        this.valor = valor;
        this.prestacao = prestacao;
        this.vencimento = vencimento;
        this.status = false;
    }

    public String getPrestacao() {
        return prestacao;
    }

    public void setPrestacao(String prestacao) {
        this.prestacao = prestacao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
