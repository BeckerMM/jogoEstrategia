package Unidades;



public class Hulk extends Unidade {

    public Hulk (String cor){
        super(900,50,50,cor);

    }

    @Override
    boolean verificarvantagem(Unidade unidadeAdversaria) {

        if (unidadeAdversaria instanceof Batman){
            return true;
        }
        return false;
    }

    @Override
    boolean ataqueEspecial() {
        if(this.getVida()>=750 && this.getMana() >=20){
            this.setAtaque(this.getAtaque()+5);
            this.setMana(this.getMana()-20);
            return true;
        }else{
            return false;
        }

    }

}
