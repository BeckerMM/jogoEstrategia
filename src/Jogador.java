import Unidades.Unidade;

import java.util.ArrayList;

public class Jogador {
    private Unidade[] listaDeUnidades = new Unidade[4];
    private String cor;
    private String nome;

    public Jogador(Unidade[] listaDeUnidades, String cor, String nome) {
        this.listaDeUnidades = listaDeUnidades;
        this.cor = cor;
        this.nome = nome;
    }

    public Unidade[] getListaDeUnidades() {
        return listaDeUnidades;
    }

    public void setListaDeUnidades(Unidade[] listaDeUnidades) {
        this.listaDeUnidades = listaDeUnidades;
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
}
