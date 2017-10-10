package session1.td1;

import hierarchie.SemiAnneauUnitaireEuclidien;

public interface INat extends SemiAnneauUnitaireEuclidien<INat>, IFabriqueNat{
    //Accesseurs
    public int val();
    public boolean estNul();
    public INat predecesseur()throws UnsupportedOperationException;
    public int taille();
    public int chiffre(int i);
}
