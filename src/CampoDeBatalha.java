import Unidades.Unidade;

import java.util.Arrays;

public class CampoDeBatalha {

    private Jogador[] listaDeJogadores;
    private String vencedor;

    public CampoDeBatalha(Jogador[] listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public void atacar(int jogador,int unidadeDeAtaque, int unidadeDeDefesa){
        Unidade atacada;
        Jogador jogadorAtaque;
    if(jogador == 1){
        atacada = listaDeJogadores[1].getListaDeUnidades()[unidadeDeDefesa];
        jogadorAtaque=
                listaDeJogadores[1];
    }else{
        atacada = listaDeJogadores[0].getListaDeUnidades()[unidadeDeDefesa];
       jogadorAtaque=
                listaDeJogadores[0];
    }
                jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque].
                        atacar(atacada,
                                jogadorAtaque.getListaDeUnidades()[unidadeDeAtaque].verificarvantagem(atacada));

    }

    public void habilidaEspecial(int jogador,int unidadeDeataque){
        listaDeJogadores[jogador].getListaDeUnidades()[unidadeDeataque].ataqueEspecial();
    }

    public Jogador verificarVencedor(){
       int contadorJogador1 = 0;
       int contadorJogador2 = 0;

        for (Unidade unidade: listaDeJogadores[0].getListaDeUnidades()) {
            if(unidade.getVida()==0){
                contadorJogador1++;
            }
        }
        for (Unidade unidade: listaDeJogadores[1].getListaDeUnidades()) {
            if(unidade.getVida()==0){
                contadorJogador2++;
            }
        }
        if (contadorJogador1== 3){
            vencedor = listaDeJogadores[1].getNome();
            return listaDeJogadores[1];
        }else if (contadorJogador2 == 3) {
            vencedor = listaDeJogadores[0].getNome();
            return listaDeJogadores[0];
        }else{
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
        return "Jogador 1 \n0-"+listaDeJogadores[0].getListaDeUnidades()[0] +
                "\n 1-" + listaDeJogadores[0].getListaDeUnidades()[1]+
                "\n 2-" + listaDeJogadores[0].getListaDeUnidades()[2]+

                "\n\n Jogador 2 \n0-"+ listaDeJogadores[1].getListaDeUnidades()[0]+
                "\n 1-"+ listaDeJogadores[1].getListaDeUnidades()[1] +
                "\n 2-" + listaDeJogadores[1].getListaDeUnidades()[2];

    }
}
