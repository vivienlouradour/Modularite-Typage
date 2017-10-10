package session1.demo1;

public class Test {
    public static void main(String args[]){
        NatDecimal x = new NatDecimal("75");
        System.out.println("x = " + x);
        
        NatParInt y = new NatParInt(85);
        System.out.println("y = " + y);

        System.out.println("Somme : " + x.somme(y));

        try{
            NatParInt z = new NatParInt(-1200);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        tester(new FabriqueNatDecimal());
        tester(new FabriqueNatParInt());
    }

    private static void tester(IFabriqueNat fab){
        INat x = fab.creerNatAvecChiffres("75");
        System.out.println("75 ? " + x.val());

        INat y = fab.creerNatAvecInt(75);
        System.out.println("75 ? " + y);

        System.out.println("75 + 75 ? " + x.somme(y));
    }
}
