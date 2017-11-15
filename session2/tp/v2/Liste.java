package session2.tp.v2;

import java.util.Iterator;

/**
 * 
 * @author valentin Quiedeville, Vivien Louradour
 * 
 *         Cette classe décrit le comportement d'une liste immutable
 * 
 * @param <E>
 */

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	/**
	 * 
	 * @return true si la liste est vide
	 */
	default boolean casVide() {
		return Boolean.FALSE;
	}

	/**
	 * 
	 * @return le premier element de la liste
	 * 
	 */
	default E tete() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return le reste de la liste
	 */
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return true si la liste n'est pas vide
	 */
	default boolean casCons() {
		return Boolean.FALSE;
	}

	/**
	 * 
	 * @return la taille de la liste
	 */
	default public int taille() {
		return 0;
	}

	/**
	 * 
	 * @return true si la liste est vide
	 */
	default public boolean estVide() {
		return this.taille() == 0;
	}

	/**
	 * 
	 * @return une nouvelle liste contenant les éléments de la liste appelante
	 *         ainsi que l'élément passé en paramètre ajouté à la fin
	 */
	default public Liste<E> ajouter(E elementAAjouter) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return une nouvelle liste contenant les éléments de la liste appelante
	 *         ainsi que ajouter tous les éléments de la liste passée en
	 *         paramètre
	 */
	default public Liste<E> ajouter(Liste<E> AAjouter) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	default Iterator<E> iterator() {
		return new IterateurListe<E>(this) {
		}; // Compléter puis utiliser IterateurListe.
	}

	/**
	 * 
	 * @return la liste inversée {1,2,3} ===> {3,2,1}
	 */

	default Liste<E> miroir() {
		Liste<E> resul = Liste.vide();
		Iterator i = this.iterator();
		while (i.hasNext()) {
			E tmp = (E)i.next();
			resul = Liste.cons(tmp, resul);
		}
		return resul;
	}

	/*
	 * Fabriques (statiques)
	 */

	/**
	 * 
	 * @return une Liste<E> vide
	 */
	public static <E> Liste<E> vide() {
		return new Liste<E>() {
			@Override
			public boolean casVide() {
				return true;
			}

			@Override
			public boolean estVide() {
				return true;
			}

			@Override
			public Liste<E> reste() {
				return Liste.vide();
			}

			@Override
			public Liste<E> ajouter(E element) {
				return Liste.cons(element, Liste.vide());
			}
		};
	}

	/**
	 * 
	 * @param t
	 *            la tete de la nouvelle liste
	 * @param r
	 *            le reste de la nouvelle liste
	 * @return une nouvelle liste ayant t pour tête et r pour reste
	 */

	public static <E> Liste<E> cons(E t, Liste<E> r) {
		return new Liste<E>() {
			@Override
			public E tete() {
				return t;
			}

			@Override
			public Liste<E> reste() {
				return r;
			}

			@Override
			public boolean casCons() {
				return true;
			}

			@Override
			public int taille() {
				return 1 + r.taille();
			}

			@Override
			public Liste<E> ajouter(E element) {
				Liste<E> resul = vide();
				resul = this.miroir();
				resul = cons(element, resul);
				resul = resul.miroir();
				return resul;
			}

			@Override
			public Liste<E> ajouter(Liste<E> liste) {
				Liste<E> resul = vide();
				resul = this.miroir();
				Iterator i = liste.iterator();
				while (i.hasNext()) {
					resul = cons((E) i.next(), resul);
				}
				resul = resul.miroir();
				return resul;
			}

			// TODO Définir les méthodes utiles.
		};
	}

}
