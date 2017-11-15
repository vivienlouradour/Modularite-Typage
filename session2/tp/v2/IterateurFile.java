package session2.tp.v2;

import java.util.Iterator;

public class IterateurFile<E> implements Iterator<E> {
	File<E> file;

	public IterateurFile(File<E> f) {
		file = f;
	}

	@Override
	public boolean hasNext() {
		return !file.estVide();
	}

	@Override
	public E next() {
		E resul = file.premier();
		file = file.suivants();
		return resul;
	}
}
