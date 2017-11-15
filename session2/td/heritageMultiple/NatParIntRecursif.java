package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public class NatParIntRecursif extends IntPositif implements AlgebreNatRecursif {
	public NatParIntRecursif(int i) {
		super(i);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParIntRecursif(val);
	}

	@Override
	public String toString() {
		return Integer.toString(this.val());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Nat))
			return false;
		Nat x = (Nat) obj;
		return this.val() == x.val();
	}

}
