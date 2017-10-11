package session1.td1;

import session1.demo1.NatDecimal;

public class NatParInt implements INat {
    //Attributs
    private int val;

    //Constructeur
    public NatParInt(int val) throws IllegalArgumentException{
        if(val<0)
            throw new IllegalArgumentException();
        this.val = val;
    }

    //Accesseurs
    @Override
    public int val() {
        return this.val;
    }

    //Fabrique
    @Override
    public NatParInt creerNatAvecValeur(int val) {
        return new NatParInt(val);
    }

    @Override
    public NatParInt creerZero() {
        return new NatParInt(0);
    }

    @Override
    public NatParInt creerSuccesseur(INat predecesseur) {
        return new NatParInt(predecesseur.val() + 1);
    }

    @Override
    public NatParInt creerNatAvecRepresentation(String repDecimale) {
        return new NatParInt(Integer.parseInt(repDecimale));
    }


    //Services
    @Override
    public boolean estNul() {
        return val == 0;
    }

    @Override
    public NatParInt predecesseur(){
        if(this.val() == 0)
            throw new UnsupportedOperationException();
        return new NatParInt(this.val() - 1);
    }

    @Override
    public int taille() {
        return this.toString().length();
    }

    @Override
    public int chiffre(int i) {
        if(i >= this.taille())
            return 0;
        return Character.getNumericValue(this.toString().charAt(this.taille() - 1 - i));
    }

    @Override
    public String toString(){
        return Integer.toString(this.val());
    }


    @Override
    public NatParInt modulo(INat x) {
        return this.creerNatAvecValeur(this.val() % x.val());
    }

    @Override
    public NatParInt div(INat x) {
        return this.creerNatAvecValeur(this.val() / x.val());

    }

    @Override
    public NatParInt somme(INat x) {
        return this.creerNatAvecValeur(this.val() + x.val());

    }

    @Override
    public NatParInt produit(INat x) {
        return this.creerNatAvecValeur(this.val() * x.val());

    }

    @Override
    public NatParInt zero() {
        return this.creerZero();
    }

    @Override
    public NatParInt un() {
        return this.creerNatAvecValeur(1);
    }

    @Override
    public boolean equals(Object o){
        boolean retour;
        try{
            retour = this.val() == ((INat)o).val();
        }
        catch (Exception ex){
            retour = false;
        }
        return retour;
    }
}
