package session1.demo1;

public class NatDecimal implements INat{
    private String chiffres;

    public NatDecimal(String chiffres) {
        super();
        this.chiffres = chiffres;
    }

    public int getChiffre(int i){
        if(i >= this.taille())
            return 0;
        return Character.getNumericValue(this.chiffres.charAt(this.taille() - 1 - i));
    }

    public int taille(){
        return this.chiffres.length();
    }

    public INat somme(INat n){
        int t = this.taille() < n.taille() ? n.taille() : this.taille();
        int retenu = 0;
        String resultat = "";
        for(int i = 0 ; i < t ; i++){
            int c = this.getChiffre(i) + n.getChiffre(i) + retenu;
            if(c > 9){
                c -= 10;
                retenu = 1;
            }
            else{
                retenu = 0;
            }
            resultat = c + resultat;
        }
        if(retenu == 1){
            resultat = "1" + resultat;
        }
        return new NatDecimal(resultat);
    }

    public int val(){
        return Integer.parseInt(this.chiffres);
    }

    public String toString(){
        return this.chiffres;
    }
}
