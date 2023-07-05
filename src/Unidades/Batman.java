package Unidades;


public class Batman extends Unidade {


    public Batman(String cor) {
        super(100, 55, 25, cor);
    }

    public void iraDasTrevas(){

    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof OptimusPrime) {
            return true;
        }
        return false;
    }

    @Override
    boolean ataqueEspecial() {
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

}