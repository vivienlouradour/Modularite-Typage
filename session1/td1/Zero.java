package session1.td1;

public class Zero implements INat {
    //Constructeur
    public Zero(){
    }

    //Fabrique
    @Override
    public INat creerNatAvecValeur(int val) {
        if(val == 0)
            return this.creerZero();
        return this.creerSuccesseur(this.creerNatAvecValeur(val - 1));
    }

    @Override
    public INat creerZero() {
        return this;
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
        return 0;
    }

    @Override
    public boolean estNul() {
        return true;
    }

    @Override
    public Zero predecesseur(){
        throw new UnsupportedOperationException();
    }

    @Override
    public int taille() {
        return 1;
    }

    @Override
    public int chiffre(int i) {
        return 0;
    }

    @Override
    public Zero modulo(INat x) {
        return this;
    }

    @Override
    public Zero div(INat x) {
        return this;
    }

    @Override
    public INat somme(INat x) {
        return x;
    }

    @Override
    public INat produit(INat x) {
        return this;
    }

    @Override
    public INat zero() {
        return this;
    }

    @Override
    public INat un() {
        return this.creerNatAvecValeur(1);
    }

    @Override
    public String toString(){
        return "0";
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
