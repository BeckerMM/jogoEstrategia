package Unidades;


public class Batman extends Unidade {


    public Batman(String cor) {
        super(100, 55, 25, cor);
    }

    public void iraDasTrevas(){

    }

    @Override
    public boolean verificarvantagem(Unidade unidadeAdversaria) {

        return unidadeAdversaria instanceof OptimusPrime;
    }

    @Override
    public boolean ataqueEspecial() {
        if(this.getMana()>=20){
            this.setVida(this.getVida()+2);
            this.setAtaque(this.getAtaque()+10);
            this.setDefesa(this.getDefesa()+5);
            this.setMana(this.getMana()-20);
            return true;
        }else{
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
                " 🦇";
    }
}
