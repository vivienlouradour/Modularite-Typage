package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class NatDecimalParInt extends NombreDecimal implements AlgebreNatParInt{

    public NatDecimalParInt(String rep){
        super(rep);
    }

    @Override
    public Nat creerNatAvecRepresentation(String repDecimale) {
        StringBuilder repMutable = new StringBuilder(repDecimale);
        nettoyer(repMutable);
        repDecimale = new String(repMutable);
        if(repDecimale.equals("")){
            repDecimale = "0";
        }
        char min = Character.forDigit(0, 10);
        char max = Character.forDigit(9, 10);
        for(int i = 0; i < repDecimale.length(); i++){
            char c = repDecimale.charAt(i);
            if(c < min)	throw new IllegalArgumentException();
            if(c > max) throw new IllegalArgumentException();
        }
        return new NatDecimalParInt(repDecimale);
    }

    private static void nettoyer(StringBuilder s){
        int debut = 0;
        int fin = 0;
        while((fin < s.length()) && Character.getNumericValue(s.charAt(fin)) == 0){
            fin++;
        }
        s.delete(debut, fin);
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
