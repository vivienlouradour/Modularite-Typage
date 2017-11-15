package session2.tp.v2;

import java.util.Iterator;

/**
 * 
 * @author valentin Quiedeville, Vivien Louradour
 * 
 *         Cette classe décrit le comportement d'une liste mutable
 * 
 * @param <E>
 */
public interface ListeMutable<E> extends Liste<E> {

	/*
	 * Accesseurs.
	 */
	/**
	 * @return le reste de la liste passée en paramètre
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Change le reste de la liste courante
	 * 
	 * @param reste
	 *            le nouveau reste de la liste
	 */
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Change la tete de la liste courante
	 * 
	 * @param tete
	 *            la nouvelle tete de la liste
	 */
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	/**
	 * 
	 * @return la liste inversée {1,2,3} ===> {3,2,1}
	 */
	default ListeMutable<E> miroir() {
		ListeMutable<E> resul = vide();
		Iterator i = this.iterator();
		while (i.hasNext()) {
			E tmp = (E) i.next();
			resul = ListeMutable.cons(tmp, resul);
		}
		if (!this.estVide()) {
			this.changerTete(resul.tete());
			this.changerReste(resul.reste());
		}
		return resul;// Pourquoi la methode miroir d'une liste mutable n'est pas void ?
	}

	/**
	 * 
	 * @param t
	 *            la tete de la nouvelle liste
	 * @param r
	 *            le reste de la nouvelle liste
	 * @return une nouvelle liste ayant t pour tête et r pour reste
	 */

	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {
		return new ListeMutable<E>() {
			E tete = t;
			ListeMutable<E> reste = r;

			@Override
			public boolean casCons() {
				return Boolean.TRUE;
			}

			@Override
			public E tete() {
				return tete;
			}

			@Override
			public ListeMutable<E> reste() {
				return reste;
			}

			@Override
			public void changerTete(E t) {
				this.tete = t;
			}

			@Override
			public void changerReste(ListeMutable<E> r) {
				this.reste = r;
			}

			@Override
			public int taille() {
				return 1 + this.reste.taille();
			}

			@Override
			public ListeMutable<E> ajouter(E element) {
				ListeMutable<E> tmp = this.reste();
				tmp = reste.miroir();
				tmp = ListeMutable.cons(element, tmp);
				tmp.miroir();
				this.changerReste(tmp);
				return this;
			}
		};
	}

	/**
	 * 
	 * @return une Liste<E> vide
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			E tete;
			ListeMutable<E> reste;

			@Override
			public boolean casVide() {
				return Boolean.TRUE;
			}

			@Override
			public int taille() {
				return 0;
			}
		};
	}

}
