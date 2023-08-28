import Unidades.Unidade;

import java.util.ArrayList;
import java.util.Arrays;

public class CampoDeBatalha {

    private ArrayList<Jogador> listaDeJogadores;
    private Jogador vencedor;
    private int rodada=0;

    public CampoDeBatalha(ArrayList<Jogador> listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }


    public Jogador getJogadorAtivo(){
        return listaDeJogadores.get(rodada%2);
    }

    public Jogador getJogadorAdversario(){
        return listaDeJogadores.get((rodada+1)%2);
    }

    public void proximaRodada(){
        for (Jogador jogador : listaDeJogadores) {
            for (Unidade unidade: jogador.getListaDeUnidades()) {
                if ( unidade.getMana() <=95){
                    unidade.setMana(unidade.getMana()+5);
                }
            }
        }
        rodada++;
    }


    public Boolean verificarVencedor() {
        for (Jogador jogador : listaDeJogadores) {
            if (jogador.getListaDeUnidades().size()== 0){
                vencedor = jogador;
                return true;
            }
        }
        return false;
    }


    public Jogador getVencedor() {
        return vencedor;
    }

    @Override
    public String toString() {
        String texto = "";
        for (Jogador jogador : listaDeJogadores) {
            texto += jogador.getNome();
            for (int i = 0; i <jogador.getListaDeUnidades().size() ; i++) {
                texto +="\n"+i+"- "+ jogador.getListaDeUnidades().get(i);
            }
            texto +="\n";
        }
        return texto;
    }
}
