package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public interface AlgebreNatRecursifSuccesseur extends Nat {
	@Override
	default public Nat somme(Nat n) {
		return this.creerNatAvecValeur(this.val() + n.val());
	}

	default public Nat zero() {
		return this.creerZero();
	}

	@Override
	default public Nat un() {
		return this.creerNatAvecValeur(1);
	}

	@Override
	default public Nat produit(Nat x) {
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	@Override
	default Nat modulo(Nat x) {
		return this.creerNatAvecValeur(this.val() % x.val());
	}

	@Override
	default Nat div(Nat x) {
		return this.creerNatAvecValeur(this.val() / x.val());
	}

	default String representer() {
		return Integer.toString(this.val());
	}

	default boolean estEgal(Object obj) {
		if (!(obj instanceof Nat))
			return false;
		Nat x = (Nat) obj;
		return this.val() == x.val();
	}

}
