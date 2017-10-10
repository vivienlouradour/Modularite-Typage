package session1.demo1;

public class FabriqueNatParInt implements IFabriqueNat{

    @Override
    public INat creerNatAvecChiffres(String chiffres) {
        return new NatParInt(Integer.parseInt(chiffres));
    }

    @Override
    public INat creerNatAvecInt(int chiffre) {
        return new NatParInt(chiffre);
    }
}
