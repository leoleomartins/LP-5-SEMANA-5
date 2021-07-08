package padroescomportamentais.observer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Carteira implements Iterable<Acao>{

    private List<Acao> acoes;
    public Carteira(Acao... acoes){ this.acoes = Arrays.asList(acoes);}

    @Override
    public Iterator<Acao> iterator() {
        return acoes.iterator();
    }
}
