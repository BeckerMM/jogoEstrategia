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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Unidade getUnidade(int unidadeDeAtaque) {
        return this.listaDeUnidades.get(unidadeDeAtaque);
    }
}
