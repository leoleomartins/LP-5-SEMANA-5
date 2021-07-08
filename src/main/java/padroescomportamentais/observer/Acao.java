package padroescomportamentais.observer;

import java.util.Observable;

public class Acao extends Observable implements Cloneable {
    private Long id;
    private String codigo;
    private Empresa empresa;
    private Double cotacao;
    private Integer quantidade;

    public Acao(Long id, String codigo, Empresa empresa, Double cotacao, Integer quantidade) {
        this.id = id;
        this.codigo = codigo;
        this.empresa = empresa;
        this.cotacao = cotacao;
        this.quantidade = quantidade;
    }

    public void setCotacao(Double cotacao) {
        this.cotacao = cotacao;
        setChanged();
        notifyObservers();
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        setChanged();
        notifyObservers();
    }

    public Double getCotacao() {
        return cotacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }



    @Override
    public Acao clone() throws CloneNotSupportedException {
        Acao acaoClone = (Acao) super.clone();
        acaoClone.empresa = (Empresa)acaoClone.empresa.clone();
        return acaoClone;
    }

    @Override
    public String toString() {
        return "Acao{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", cotacao=" + cotacao +
                '}';
    }
}
