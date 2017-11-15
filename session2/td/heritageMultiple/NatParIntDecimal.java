package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class NatParIntDecimal extends IntPositif implements AlgebreNatDecimal{

    public NatParIntDecimal(int val){
        super(val);
    }

    @Override
    public Nat creerNatAvecValeur(int val) {
        return new NatParIntDecimal(val);
    }

    @Override
    public boolean equals(Object x){
        if(!(x instanceof Nat)) return false;
        Nat n = (Nat)x;
        return this.toString().equals(n.toString());
    }

    @Override
    public String toString() {
        return Integer.toString(this.val());
    }
}
