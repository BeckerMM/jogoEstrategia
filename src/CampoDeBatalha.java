import Unidades.Unidade;

import java.util.Arrays;

public class CampoDeBatalha {

    private Jogador[] listaDeJogadores;
    private String vencedor;

    public CampoDeBatalha(Jogador[] listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public boolean atacar(int jogador, int unidadeDeAtaque, int unidadeDeDefesa) {
        Unidade atacada;
        Unidade ataque;
        Jogador jogadorAtaque;
        if (jogador == 1) {
            atacada = listaDeJogadores[0].getListaDeUnidades()[unidadeDeDefesa];
            jogadorAtaque = listaDeJogadores[1];
            ataque = jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque];
        } else {
            atacada = listaDeJogadores[1].getListaDeUnidades()[unidadeDeDefesa];
            jogadorAtaque = listaDeJogadores[0];
            ataque = jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque];
        }
        if (atacada != null && ataque != null) {
            jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque].
                    atacar(atacada,
                            jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque].verificarvantagem(atacada));
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarUnidade(int unidadeDeAtaque, int numeroDoJogador) {
        return listaDeJogadores[numeroDoJogador].getListaDeUnidades()[unidadeDeAtaque] == null;
    }

    public void habilidaEspecial(int jogador, int unidadeDeataque) {
        listaDeJogadores[jogador].getListaDeUnidades()[unidadeDeataque].ataqueEspecial();
    }

    public void verificarVidaDaUnidade() {
        for (int i = 0; i < 2; i++) {
            int contador = 0;
            for (Unidade unidade : listaDeJogadores[i].getListaDeUnidades()) {
                if (unidade != null) {
                    if (unidade.getVida() <= 0) {
                        listaDeJogadores[i].getListaDeUnidades()[contador] = null;
                    }

                }
                contador++;
            }
        }

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


    public Jogador[] getListaDeJogadores() {
        return listaDeJogadores;
    }

    public void setListaDeJogadores(Jogador[] listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    @Override
    public String toString() {
        return "Jogador 1 \n 0-" + listaDeJogadores[0].getListaDeUnidades()[0] +
                "\n 1-" + listaDeJogadores[0].getListaDeUnidades()[1] +
                "\n 2-" + listaDeJogadores[0].getListaDeUnidades()[2] +

                "\n\nJogador 2 \n 0-" + listaDeJogadores[1].getListaDeUnidades()[0] +
                "\n 1-" + listaDeJogadores[1].getListaDeUnidades()[1] +
                "\n 2-" + listaDeJogadores[1].getListaDeUnidades()[2];

    }
}
