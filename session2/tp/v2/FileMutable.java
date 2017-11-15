package session2.tp.v2;

/**
 * 
 * @author Vivien Louradour, Valentin Quiedeville
 * 
 *         Interface fournissant les services d'une file mutable
 * @param <E>
 */
public interface FileMutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */
	@Override
	default FileMutable<E> suivants() {
		FileMutable<E> resul = this.creerCopie();
		resul.retirer();
		return resul;
	}

	void ajouter(E element);

	void retirer();

	/*
	 * Fabriques
	 */
	FileMutable<E> creer();

	FileMutable<E> creerCopie();

	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		this.ajouter(dernierDansFile);
		return this;
	}

	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}

	// Complexité O(|secondeFile|)
	@Override
	default FileMutable<E> ajout(File<E> secondeFile) {
		for (E element : secondeFile) {
			this.ajouter(element);
		}
		return this;
	}

	// Complexité en O(1).
	//void ajouter(File<E> secondeFile);

}
