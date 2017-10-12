package session1.td_corrige;

public interface FabriqueNaturels<T> {
	T creerNatAvecValeur(int val);
	T creerZero();
	T creerSuccesseur(T predecesseur);
	T creerNatAvecRepresentation(String repDecimale);
}
