package Unidades;


public class OptimusPrime extends Unidade {
    public OptimusPrime(String cor) {
        super(250, 75, 40, cor);
    }


    @Override
    public boolean verificarvantagem(Unidade unidadeAdversaria) {

        return unidadeAdversaria instanceof Naruto;
    }
    @Override
    public boolean ataqueEspecial() {
        if (this.getMana() >= 10) {
            this.setVida(this.getVida() + 10);
            this.setDefesa(this.getDefesa() + 1);
            this.setMana(this.getMana() - 10);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "Life: "+ this.getVida() +
                        " Mana: "+getMana()+
                        " Ataque: "+getAtaque()+
                        " cor: "+ getCor()+
                        " Defesa"+ getDefesa()+
                        " 🤖";
    }
}
