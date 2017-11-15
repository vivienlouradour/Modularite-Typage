package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public interface AlgebreNatRecursif extends AlgebreNatRecursifSuccesseur, AlgebreNatRecursifZero {

	@Override
	default Nat produit(Nat x) {

		return AlgebreNatRecursifSuccesseur.super.produit(x);
	}

	@Override
	default Nat modulo(Nat x) {

		return AlgebreNatRecursifSuccesseur.super.modulo(x);
	}

	@Override
	default boolean estEgal(Object obj) {

		return AlgebreNatRecursifSuccesseur.super.estEgal(obj);
	}

	@Override
	default Nat zero() {

		return AlgebreNatRecursifSuccesseur.super.zero();
	}

	@Override
	default String representer() {

		return AlgebreNatRecursifSuccesseur.super.representer();
	}

	@Override
	default Nat div(Nat x) {

		return AlgebreNatRecursifSuccesseur.super.div(x);
	}

	@Override
	default Nat somme(Nat n) {

		return AlgebreNatRecursifSuccesseur.super.somme(n);
	}

	@Override
	default Nat un() {

		return AlgebreNatRecursifSuccesseur.super.un();
	}

}
