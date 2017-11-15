package session2.tp.v2;

/**
 * 
 * @author Vivien Louradour, Valentin Quiedeville
 * 
 *         Interface fournissant les services d'une file immutable
 * @param <E>
 */
public interface FileImmutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */
	@Override
	FileImmutable<E> suivants();

	/*
	 * Fabriques
	 */
	@Override
	FileImmutable<E> creer();

	/**
	 * 
	 * @param dernier
	 * @return une nouvelle File avec dernier comme seul element
	 */
	FileImmutable<E> creer(E dernier);

	/**
	 * 
	 * @param file
	 * @param dernier
	 * @return une nouvelle file qui est la concatenation de file et de dernier
	 *         Une fabrique de ce type était fourni dans liste, nous ne voyons
	 *         pas comment implémenter ajout sans elle
	 */
	FileImmutable<E> creer(FileImmutable<E> file, E dernier);

	/*
	 * Services
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {

		if (estVide()) {
			return creer(dernierDansFile);
		}
		FileImmutable<E> resul = creer(this.premier());
		FileImmutable<E> tmp = this.suivants();
		while (!tmp.estVide()) {
			resul = creer(resul, tmp.premier());
			tmp = tmp.suivants();
		}
		resul = creer(resul, dernierDansFile);
		return resul;
	}

	@Override
	default FileImmutable<E> retrait() {

		return this.suivants();
	}

	// Complexité O(|secondeFile|)
	@Override
	default FileImmutable<E> ajout(File<E> secondeFile) {
		FileImmutable<E> r = this;
		for (E e : secondeFile) {
			r = r.ajout(e);
		}
		return r;
	}

}
