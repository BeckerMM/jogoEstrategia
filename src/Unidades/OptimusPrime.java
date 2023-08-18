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
        if (this.getMana() >= 25) {
            this.setVida(this.getVida() + 10);
            this.setDefesa(this.getDefesa() + 1);
            this.setMana(this.getMana() - 25);
            return true;
        }
            return false;

    }

    @Override
    public String toString() {
        return
                "Life: "+ this.getVida() +
                        " Mana: "+this.getMana()+
                        " Ataque: "+this.getAtaque()+
                        " cor: "+ this.getCor()+
                        " Defesa"+ this.getDefesa()+
                        " 🤖";
    }
}
