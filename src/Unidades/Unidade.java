package Unidades;

public abstract class Unidade {

    // Atributos comuns
    private double vida;
    private double ataque;
    private double defesa;
    private String cor;

    // Construtor Super
    public Unidade(double vida, double ataque, double defesa, String cor) {
        this.vida = vida;
        this.ataque= ataque;
        this.defesa= defesa;
        this.cor = cor;
    }

    //Implementação do metódo de ataque, onde caso a unidade Adversária tenha fraqueza em relação a unidade que chamou, a mesma irá perder 25% a mais de vida
    public boolean atacar(Unidade unidadeAdversaria, boolean vantagem){
        if (vantagem){
            unidadeAdversaria.vida-=(this.ataque* 1.25);
        }else{
            if (this.ataque> unidadeAdversaria.defesa){
                unidadeAdversaria.vida-=(this.ataque-unidadeAdversaria.defesa);
            }

        }
        return true;
    }

    //Metódo abstrato para verificar se a unidade Aversária possui desvantagem em relação a unidade que chamou a função
    abstract boolean verificarvantagem(Unidade unidadeAdversaria);

    //Getters e Setters
    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


}
