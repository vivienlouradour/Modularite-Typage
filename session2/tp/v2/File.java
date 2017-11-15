package session2.tp.v2;

/**
 * 
 * @author Vivien Louradour, Valentin Quiedeville
 * 
 *         Interface fournissant les services d'une file
 * @param <E>
 */
public interface File<E> extends Iterable<E> {

	/*
	 * Accesseurs
	 */
	/**
	 * 
	 * @return Le premier element de la file
	 */
	E premier();

	/**
	 * 
	 * @return Une file repr�sentant le file priv�e de son premier �l�ment
	 */
	File<E> suivants();

	/**
	 * 
	 * @return true si la file est vide
	 */
	default boolean estVide() {
		return this.taille() == 0;
	}

	/**
	 * 
	 * @return la taille de la file
	 */
	int taille();

	/*
	 * Fabriques
	 */
	/**
	 * 
	 * @return une nouvelle file vide
	 */
	File<E> creer();

	/*
	 * Services
	 */
	/**
	 * 
	 * @param dernierDansFile
	 *            élément ajouter en fin de file
	 * @return une nouvelle file avec dernier dans file � la fin
	 */
	File<E> ajout(E dernierDansFile);

	/**
	 * 
	 * @return Une nouvelle file égale à la file courante privée de son premier
	 *         élément
	 */
	File<E> retrait();

	/**
	 * 
	 * @param secondeFile
	 *            File a ajouter en fin de la file courante
	 * @return Une nouvelle file reprenant la file courante � laquelle est
	 *         ajout�e la file pass� en param�tre
	 */
	File<E> ajout(File<E> secondeFile);

	/**
	 * 
	 * @return toString
	 */
	default String representation() {

		String resul = "";
		if (!this.estVide()) {
			resul += this.premier().toString();
			File<E> tmp = this.suivants();
			while (!tmp.estVide()) {
				resul += " " + tmp.premier().toString();
				tmp = tmp.suivants();
			}
		}
		return resul;
	}

	/**
	 * 
	 * @param file
	 * @return equals
	 */
	default boolean estEgal(File<E> file) {

		boolean result = false;
		if (this.taille() == file.taille()) {

			result = this.premier().equals(file.premier());
			File<E> tmp1 = this.suivants();
			File<E> tmp2 = file.suivants();
			while (result && !tmp1.estVide()) {
				result = tmp1.premier().equals(tmp2.premier());
			}
		}
		return result;
	}

}