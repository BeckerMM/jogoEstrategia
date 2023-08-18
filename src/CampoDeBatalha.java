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


    public boolean verificarUnidade(int unidadeDeAtaque, int numeroDoJogador) {
        return listaDeJogadores[numeroDoJogador].getListaDeUnidades()[unidadeDeAtaque] == null;
    }

    public Jogador getJogadorAtivo(){
        return listaDeJogadores.get(rodada%2);
    }

    public Jogador getJogadorAdversario(){
        return listaDeJogadores.get((rodada+1)%2);
    }


    public Jogador verificarVencedor() {
        int contadorJogador1 = 0;
        int contadorJogador2 = 0;

        for (Unidade unidade : listaDeJogadores[0].getListaDeUnidades()) {
            if (unidade == null) {
                contadorJogador1++;
            }
        }
        for (Unidade unidade : listaDeJogadores[1].getListaDeUnidades()) {
            if (unidade == null) {
                contadorJogador2++;
            }
        }
        if (contadorJogador1 == 3) {
            vencedor = listaDeJogadores[1].getNome();
            return listaDeJogadores[1];
        } else if (contadorJogador2 == 3) {
            vencedor = listaDeJogadores[0].getNome();
            return listaDeJogadores[0];
        } else {
            return null;
        }
    }


    public ArrayList<Jogador> getListaDeJogadores() {
        return listaDeJogadores;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    @Override
    public String toString() {
        String texto = "";
        for (Jogador jogador : listaDeJogadores) {
            texto += jogador.getNome();
            for (int i = 0; i <3 ; i++) {
                texto +="\n"+i+"- "+ jogador.getListaDeUnidades().get(i);
            }
            texto +="\n";
        }
        return texto;
    }
}
