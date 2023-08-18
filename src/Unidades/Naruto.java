package Unidades;


public class Naruto extends Unidade {
    public Naruto(String cor) {
        super(50, 75, 10, cor);
    }

    @Override
    public boolean verificarvantagem(Unidade unidadeAdversaria) {

        return unidadeAdversaria instanceof Dragao;
    }

    @Override
    public boolean ataqueEspecial() {
        if (this.getMana()>=15){
            this.setVida(this.getVida()+5);
            this.setDefesa(this.getDefesa()+2);
            this.setMana(this.getMana()-15);
            return true;
        }else {
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
                " 👨";
    }
}
