package padroescomportamentais.observer;


import java.util.Observable;
import java.util.Observer;

public class Conta implements Observer {

    private Double montanteTotal;
    private String investidor;
    private Carteira carteira;

    public Conta(String investidor, Carteira carteira) {
        this.investidor = investidor;
        this.carteira = carteira;
        matricular();
    }

    public void matricular(){
        for (Acao acao:carteira){
            acao.addObserver(this);
        }
    }

    @Override
    public void update(Observable acao, Object arg) {
        calcularMontante();
    }

    public Double calcularMontante(){
        montanteTotal = 0d;
        for (Acao acao:carteira){
           montanteTotal = montanteTotal + (acao.getCotacao()*acao.getQuantidade());
        }
        return montanteTotal;
    }

    public Double getMontanteTotal() {
        return montanteTotal;
    }

    public void setMontanteTotal(Double montanteTotal) {
        this.montanteTotal = montanteTotal;
    }

    public String getInvestidor() {
        return investidor;
    }

    public void setInvestidor(String investidor) {
        this.investidor = investidor;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        matricular();
        this.carteira = carteira;
    }


}
