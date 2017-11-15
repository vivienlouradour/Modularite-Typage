package session2.tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	Liste<E> list;

	public IterateurListe(Liste<E> l) {
		list = l;
	}

	@Override
	public boolean hasNext() {
		return !list.estVide();
	}

	@Override
	public E next() {
		E resul = list.tete();
		list = list.reste();
		return resul;
	}

}
