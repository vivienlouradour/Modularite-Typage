package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class ZeroParInt extends EtatZero implements AlgebreNatParInt{

    @Override
    public Nat creerZero() {
        return this;
    }

    @Override
    public Nat creerSuccesseur(Nat predecesseur) {
        return new SuccParInt(predecesseur);
    }

    @Override
    public String toString(){
        return "0";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Nat))
            return false;
        Nat x = (Nat)obj;
        return this.val() == x.val();
    }
}
