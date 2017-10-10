package session1.td1;

public interface IFabriqueNat {
    public INat creerNatAvecValeur(int val);
    public INat creerZero();
    public INat creerSuccesseur(INat predecesseur);
    public INat creerNatAvecRepresentation(String repDecimale);
}
