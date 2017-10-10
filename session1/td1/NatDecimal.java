package session1.td1;

public class NatDecimal implements INat {
    //Attributs
    private String chiffres;

    //Constructeur
    public NatDecimal(String rep){
        this.chiffres = rep;
    }

    //Fabrique
    @Override
    public NatDecimal creerNatAvecValeur(int val) {
        return new NatDecimal(Integer.toString(val));
    }

    @Override
    public NatDecimal creerZero() {
        return new NatDecimal("0");
    }

    @Override
    public NatDecimal creerSuccesseur(INat predecesseur) {
        return creerNatAvecValeur(predecesseur().val() + 1);
    }

    @Override
    public NatDecimal creerNatAvecRepresentation(String repDecimale) {
        return new NatDecimal(repDecimale);
    }

    //Services
    @Override
    public int val() {
        return Integer.parseInt(this.chiffres);
    }

    @Override
    public boolean estNul() {
        return this.val() == 0;
    }

    @Override
    public NatDecimal predecesseur() throws UnsupportedOperationException {
        if(this.estNul())
            throw new UnsupportedOperationException();
        return this.creerNatAvecValeur(this.val() - 1);
    }

    @Override
    public int taille() {
        return this.chiffres.length();
    }

    @Override
    public int chiffre(int i) {
        if(i >= this.taille())
            return 0;
        return Character.getNumericValue(this.chiffres.charAt(this.taille() - 1 - i));
    }

    @Override
    public NatDecimal modulo(INat x) {
        return this.creerNatAvecValeur(this.val() % x.val());
    }

    @Override
    public NatDecimal div(INat x) {
        return this.creerNatAvecValeur(this.val() / x.val());
    }

    @Override
    public NatDecimal somme(INat x) {
        int t = this.taille() < x.taille() ? x.taille() : this.taille();
        StringBuilder rep = new StringBuilder();
        int retenue = 0;
        for(int i = 0; i < t; i++){
            int chiffre = this.chiffre(i) + x.chiffre(i) + retenue;
            if(chiffre > 9){
                chiffre = chiffre - 10;
                retenue = 1;
            }else{
                retenue = 0;
            }
            rep.append(Integer.toString(chiffre));
        }
        rep = retenue == 0 ? rep : rep.append(1);
        return new NatDecimal(rep.reverse().toString());
    }

    @Override
    public NatDecimal produit(INat x) {
        return this.creerNatAvecValeur(this.val() * x.val());
    }

    @Override
    public NatDecimal zero() {
        return this.creerZero();
    }

    @Override
    public NatDecimal un() {
        return this.creerNatAvecValeur(1);
    }

    @Override
    public String toString(){
        return this.chiffres;
    }

    @Override
    public boolean equals(Object o){
        return this.val() == ((INat)o).val();
    }


}
