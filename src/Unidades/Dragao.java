package Unidades;


public class Dragao extends Unidade {

    public Dragao(String cor) {
        super(500, 35, 45, cor);
    }


    @Override
   public boolean verificarvantagem(Unidade unidadeAdversaria) {

        return unidadeAdversaria instanceof Hulk;
    }

    @Override
    public boolean ataqueEspecial() {
        if (this.getMana() >= 25) {
            this.setAtaque(this.getAtaque() + 10);
            this.setDefesa(this.getDefesa() + 10);
            this.setMana(this.getMana()-25);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return   "Life: "+ this.getVida() +
                " Mana: "+getMana()+
                " Ataque: "+getAtaque()+
                " cor: "+ getCor()+
                " Defesa"+ getDefesa()+
                " 🐉";
    }
}
