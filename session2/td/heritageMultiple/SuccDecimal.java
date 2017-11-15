package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class SuccDecimal extends EtatSucc implements AlgebreNatDecimal {

    public SuccDecimal(Nat predecesseur) {
        super(predecesseur);
    }

    @Override
    public Nat creerZero() {
        return new ZeroDecimal();
    }

    @Override
    public Nat creerSuccesseur(Nat predecesseur) {
        return new SuccDecimal(predecesseur);
    }

    @Override
    public String toString() {
        return Integer.toString(this.val());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Nat))
            return false;
        Nat x = (Nat) obj;
        return this.val() == x.val();
    }
}
