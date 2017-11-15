package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class NatDecimal extends NombreDecimal implements AlgebreNatDecimal{

    public NatDecimal(String s) {
        super(s);
    }
    
    @Override
    public boolean equals(Object x){
            if(!(x instanceof Nat)) return false;
            Nat n = (Nat)x;
            return this.toString().equals(n.toString());
    }
    
    public Nat creerNatAvecRepresentation(String repDEcimale) {
        StringBuilder repMutable = new StringBuilder(repDEcimale);
        repDEcimale = new String(repMutable);
        if(repDEcimale.equals("")){
                repDEcimale = "0";
        }
        char min = Character.forDigit(0, 10);
        char max = Character.forDigit(9, 10);
        for(int i = 0; i < repDEcimale.length(); i++){
                char c = repDEcimale.charAt(i);
                if(c < min)	throw new IllegalArgumentException();
                if(c > max) throw new IllegalArgumentException();
        }
        return new NatDecimal(repDEcimale);
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.val());
    }
}
