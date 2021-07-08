package padroescomportamentais.observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Observer: Conta Test")
class ContaTest {
    @Test
    @DisplayName("Deve re-calcular montante ao atualizar variavel acao ")
    void acaoDeveNotificarConta(){
        Acao acao = new Acao(1L, "PETR4", new Empresa(1L, "PETROBRAS","123"),
                13.87,100);
        Conta conta = new Conta("João", new Carteira(acao));
        acao.setCotacao(14d);

        assertEquals(1400d, conta.getMontanteTotal());
    }

    @Test
    @DisplayName("Deve re-calcular montante ao atualizar variavel quantidade ")
    void quantidadeDeveNotificarConta(){
        Acao acao = new Acao(1L, "PETR4", new Empresa(1L, "PETROBRAS","123"),
                15d,100);
        Conta conta = new Conta("João", new Carteira(acao));
        acao.setQuantidade(200);

        assertEquals(3000d, conta.getMontanteTotal());
    }

}
