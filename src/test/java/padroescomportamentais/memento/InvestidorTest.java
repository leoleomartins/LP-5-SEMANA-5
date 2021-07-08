package padroescomportamentais.memento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Memento: Investidor")
class InvestidorTest {

    @Test
    @DisplayName("Deve lançar excessão por valor invalido")
    void deveLancarExcecaoValorInvalido(){
        Investidor investidor = new Investidor();

        assertThrows(IllegalArgumentException.class, ()->investidor.restauraEstado(-1));
    }

    @Test
    @DisplayName("Deve armazenar estados")
    void deveArmazenarEstados(){
        Investidor investidor = new Investidor();
        investidor.setInvestidorEstado(InvestidorEstadoAtivo.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoBloqueado.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoAtivo.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoTransferido.getInstance());

        assertEquals(4, investidor.getMemento().size());
    }

    @Test
    @DisplayName("Deve retornar para estado informado no Indice")
    void deveRetornarParaEstadoAnterior(){
        Investidor investidor = new Investidor();
        investidor.setInvestidorEstado(InvestidorEstadoAtivo.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoBloqueado.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoAtivo.getInstance());
        investidor.setInvestidorEstado(InvestidorEstadoTransferido.getInstance());
        investidor.restauraEstado(1);
        assertEquals(InvestidorEstadoBloqueado.getInstance(), investidor.getInvestidorEstado());
    }
}
