package session1.demo1;

public class FabriqueNatDecimal implements IFabriqueNat{
    @Override
    public INat creerNatAvecChiffres(String chiffres) {
        return new NatDecimal(chiffres);
    }

    @Override
    public INat creerNatAvecInt(int chiffre) {
        return new NatDecimal(Integer.toString(chiffre));
    }
}
