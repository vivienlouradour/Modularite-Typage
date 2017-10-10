package session1.td1;

public class Succ implements INat {
    //Attributs
    private INat predecesseur;

    //Constructeur
    public Succ(INat predecesseur){
        this.predecesseur = predecesseur;
    }

    //Services
    @Override
    public int val() {
        return 0;
    }

    @Override
    public boolean estNul() {
        return false;
    }

    @Override
    public INat predecesseur() throws UnsupportedOperationException {
        return null;
    }

    @Override
    public int taille() {
        return 0;
    }

    @Override
    public int chiffre(int i) {
        return 0;
    }

    @Override
    public INat modulo(INat x) {
        return null;
    }

    @Override
    public INat div(INat x) {
        return null;
    }

    @Override
    public INat somme(INat x) {
        return null;
    }

    @Override
    public INat produit(INat x) {
        return null;
    }

    @Override
    public INat zero() {
        return null;
    }

    @Override
    public INat un() {
        return null;
    }

    @Override
    public INat creerNatAvecValeur(int val) {
        return null;
    }

    @Override
    public INat creerZero() {
        return null;
    }

    @Override
    public INat creerSuccesseur(INat predecesseur) {
        return null;
    }

    @Override
    public INat creerNatAvecRepresentation(String repDecimale) {
        return null;
    }
}
