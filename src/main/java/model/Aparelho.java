package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rafael Magnago
 */
@Entity
@Table(name = "aparelho")
public class Aparelho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aparelho")
    private int id;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;
    
    @Column(name = "espeficacao", nullable = false, length = 50)
    private String espeficacao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @ManyToMany(mappedBy = "aparelhos", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

    public Aparelho() {
    }

    public Aparelho(String modelo, String fabricante, String espeficacao, Double preco) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.espeficacao = espeficacao;
        this.preco = preco;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getEspeficacao() {
        return espeficacao;
    }

    public void setEspeficacao(String espeficacao) {
        this.espeficacao = espeficacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
