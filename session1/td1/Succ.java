package session1.td1;

public class Succ implements INat {
    //Attributs
    private INat predecesseur;

    //Constructeur
    public Succ(INat predecesseur){
        this.predecesseur = predecesseur;
    }

    //Fabrique
    @Override
    public INat creerNatAvecValeur(int val) {
        if(val == 0)
            return new Zero();
        return this.creerSuccesseur(this.creerNatAvecValeur(val - 1));
    }

    @Override
    public INat creerZero() {
        return new Zero();
    }

    @Override
    public INat creerSuccesseur(INat predecesseur) {
        return new Succ(predecesseur);
    }

    @Override
    public INat creerNatAvecRepresentation(String repDecimale) {
        return this.creerNatAvecValeur(Integer.parseInt(repDecimale));
    }

    //Services
    @Override
    public int val() {
        return 1 + this.predecesseur().val();
    }

    @Override
    public boolean estNul() {
        return false;
    }

    @Override
    public INat predecesseur() throws UnsupportedOperationException {
        return this.predecesseur;
    }

    @Override
    public int taille() {
        return Integer.toString(this.val()).length();
    }

    @Override
    public int chiffre(int i) {
        if(i >= this.taille())
            return 0;
        return Character.getNumericValue(this.toString().charAt(this.taille() - 1 - i));
    }

    @Override
    public INat modulo(INat x) {
        return this.creerNatAvecValeur(this.val() % x.val());
    }

    @Override
    public INat div(INat x) {
        return this.creerNatAvecValeur(this.val() / x.val());
    }

    @Override
    public INat somme(INat x) {
        return this.creerNatAvecValeur(this.val() + x.val());
    }

    @Override
    public INat produit(INat x) {
        return this.creerNatAvecValeur(this.val() * x.val());
    }

    @Override
    public INat zero() {
        return new Zero();
    }

    @Override
    public INat un() {
        return this.creerNatAvecValeur(1);
    }

    @Override
    public String toString(){
        return Integer.toString(this.val());
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
