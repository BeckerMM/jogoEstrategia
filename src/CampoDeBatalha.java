import Unidades.Unidade;

public class CampoDeBatalha {

    private Jogador[] listaDeJogadores;


    public CampoDeBatalha(Jogador[] listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }

    public Jogador[] getListaDeJogadores() {
        return listaDeJogadores;
    }

    public void setListaDeJogadores(Jogador[] listaDeJogadores) {
        this.listaDeJogadores = listaDeJogadores;
    }


}
