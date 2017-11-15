package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public abstract class NombreDecimal implements Nat {
    private String chiffres;

    public NombreDecimal(String chiffres){
        this.chiffres = chiffres;
    }

    @Override
    public int chiffre(int i){
        if(i < this.taille())
            return Character.getNumericValue(chiffres.charAt(chiffres.length() -1 -i));
        return 0;
    }

    public int taille(){
        return this.chiffres.length();
    }

    @Override
    public int val() {
        return Integer.parseInt(this.chiffres);
    }

    @Override
    public boolean estNul() {
        // Peut être simplifié du fait du nettoyage ("0" pour zéro)
        for(int i = 0; i < this.taille(); i++){
            if(this.chiffre(i) != 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Nat predecesseur() {
        if(this.estNul()){
            throw new UnsupportedOperationException();
        }
        int t = this.taille();
        StringBuilder rep = new StringBuilder();
        int retenue = -1;
        for(int i = 0; i < t; i++){
            int chiffre = this.chiffre(i) + retenue;
            if(chiffre == -1){
                chiffre = 9;
                retenue = -1;
            }else{
                retenue = 0;
            }
            rep.append(Integer.toString(chiffre));
        }
        return this.creerNatAvecRepresentation(rep.reverse().toString());
    }

    @Override
    public Nat creerNatAvecValeur(int x) {
        return this.creerNatAvecRepresentation(Integer.toString(x));
    }

    @Override
    public Nat creerZero(){
        return this.creerZero();
    }

    @Override
    public Nat creerSuccesseur(Nat predecesseur){
        int t = predecesseur.taille();
        StringBuilder rep = new StringBuilder();
        int retenue = 1;
        for(int i = 0; i < t; i++){
            int chiffre = predecesseur.chiffre(i) + retenue;
            if(chiffre > 9){
                chiffre = chiffre - 10;
                retenue = 1;
            }else{
                retenue = 0;
            }
            rep.append(Integer.toString(chiffre));
        }
        rep = retenue == 0 ? rep : rep.append(1);
        return this.creerNatAvecRepresentation(rep.reverse().toString());
    }
}
