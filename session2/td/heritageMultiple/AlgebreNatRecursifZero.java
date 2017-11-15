package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public interface AlgebreNatRecursifZero extends Nat {
	@Override
	default public Nat zero() {
		return this.creerZero();
	}

	@Override
	default public Nat somme(Nat n) {
		return this.creerNatAvecValeur(n.val());
	}

	@Override
	default public Nat un() {
		return this.un();
	}

	default public Nat produit(Nat n) {
		return zero();
	}

	default public Nat modulo(Nat n) {
		return this.creerNatAvecValeur(val() % n.val());
	}

	default public Nat div(Nat n) {
		return this.creerNatAvecValeur(val() / n.val());
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
