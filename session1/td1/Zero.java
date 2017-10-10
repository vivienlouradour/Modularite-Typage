package session1.td1;

public class Zero implements INat {
    public Zero(){
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
        return 0;
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
