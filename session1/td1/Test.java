package session1.td1;

public class Test {
    public static void main(String[] args){
        System.out.println("Test NatParInt : ");
        test(new NatParInt(0));
        System.out.println("Test NatDecimal");
        test(new NatDecimal("0"));
    }

    private static void test(IFabriqueNat fabrique){
        INat zero = fabrique.creerZero();
        System.out.println("0 ? " + zero);
        System.out.println("true ? " + zero.equals(zero.zero()));

        INat un = fabrique.creerNatAvecValeur(1);
        System.out.println("1 ? " + un);
        System.out.println("true ? " + un.equals(un.un()));

        INat cinq = fabrique.creerNatAvecRepresentation("5");
        System.out.println("5 ? " + cinq);
        System.out.println("4 ? " + cinq.predecesseur());

        INat six = fabrique.creerNatAvecValeur(6);
        System.out.println("11 ? " + cinq.somme(six));
        System.out.println("30 ? " + cinq.produit(six));
        INat trentetrois = fabrique.creerNatAvecValeur(33);
        System.out.println("5 3 ?" + trentetrois.div(six) + " " + trentetrois.modulo(six));

        try{
            INat invalid = fabrique.creerNatAvecRepresentation("2_000_000_000");
            System.out.println(invalid.somme(invalid));
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
