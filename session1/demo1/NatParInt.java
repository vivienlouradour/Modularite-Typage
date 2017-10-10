package session1.demo1;

public class NatParInt implements INat{
    //Attribut, ou état
    private int n; //Invariant : n>=0

    //Constructeur
    public NatParInt(int n) throws IllegalArgumentException{
        super();
        if(n<0){
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    //Accesseur
    public int val(){
        return this.n;
    }

    //Service
    public INat somme(INat p){
        return new NatParInt(this.val() + p.val());
    }

    public int taille(){
        return this.toString().length();
    }

    public int getChiffre(int i){
        if(i >= this.taille())
            return 0;
        return Character.getNumericValue(this.toString().charAt(this.taille() - 1 - i));
    }

    public String toString(){
        return Integer.toString(this.val());
    }
}
