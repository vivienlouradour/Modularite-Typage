package session2.tp.v3;

import session2.tp.v2.Liste;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	ListeGenerique<E> list;

	public IterateurListe(ListeGenerique<E> l) {
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
