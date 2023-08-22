import Unidades.Unidade;

import java.util.ArrayList;

public class Jogador {
    private final ArrayList<Unidade> listaDeUnidades;
    private String cor;
    private String nome;

    public Jogador(ArrayList<Unidade> listaDeUnidades, String cor, String nome){
        this.listaDeUnidades = listaDeUnidades;
        this.cor = cor;
        this.nome = nome;
    }

    public boolean habilidaEspecial(Unidade unidadeDeAtaque) {
        return unidadeDeAtaque.ataqueEspecial();
    }

    public void atacar(Jogador adversario,Unidade unidadeDeAtaque, Unidade unidadeDeDefesa) {
            unidadeDeAtaque.atacar(unidadeDeDefesa);
            if(unidadeDeDefesa.getVida() <= 0){
                adversario.listaDeUnidades.remove(unidadeDeDefesa);
            }
    }

    public ArrayList<Unidade> getListaDeUnidades() {
        return listaDeUnidades;
    }

    public String getNome() {
        return nome;
    }

    public Unidade getUnidade(int unidadeDeAtaque) {
        return this.listaDeUnidades.get(unidadeDeAtaque);
    }
}
