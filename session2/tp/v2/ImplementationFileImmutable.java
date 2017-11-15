package session2.tp.v2;

import java.util.Iterator;

/**
 * 
 * @author Vivien Louradour, Valentin Quiedeville
 *
 * @param <E>
 * 
 *            Classe implémentant l'interface FileImmutable
 */

public class ImplementationFileImmutable<E> implements FileImmutable<E> {
	Liste<E> debut;
	Liste<E> fin;
	@SuppressWarnings("rawtypes")
	public static ImplementationFileImmutable Fabrique = new ImplementationFileImmutable<>();

	@Override
	public E premier() {

		return debut.tete();
	}

	@Override
	public ImplementationFileImmutable<E> suivants() {
		ImplementationFileImmutable<E> resul = ImplementationFileImmutable.Fabrique.creer();

		resul.debut = this.debut.reste();
		resul.fin = this.debut.miroir();
		return resul;

	}

	@Override
	public int taille() {

		return debut.taille();
	}

	@Override
	public Iterator<E> iterator() {

		return new IterateurFile(this);
	}

	@Override
	public ImplementationFileImmutable<E> creer() {
		ImplementationFileImmutable<E> resul = new ImplementationFileImmutable<>();
		resul.debut = Liste.vide();
		resul.fin = Liste.vide();
		return resul;
	}

	@Override
	public ImplementationFileImmutable<E> creer(E dernier) {
		ImplementationFileImmutable<E> resul = new ImplementationFileImmutable<>();
		resul.debut = Liste.cons(dernier, Liste.vide());
		resul.fin = Liste.cons(dernier, Liste.vide());
		return resul;
	}

	@Override
	public FileImmutable<E> creer(FileImmutable<E> file, E dernier) {
		//System.out.println("dernier : " + dernier);
		ImplementationFileImmutable<E> resul = ImplementationFileImmutable.Fabrique.creer();
		resul.debut = resul.debut.ajouter(file.premier());
		//System.out.println("resul.debut.taille : " + resul.debut.taille());
		FileImmutable<E> tmp = file.suivants();
		//System.out.println("file.suivant.taille : " + tmp.taille());
		while (!tmp.estVide()) {
			resul.debut = resul.debut.ajouter(tmp.premier());
			tmp = tmp.suivants();
		}
		resul.debut = resul.debut.ajouter(dernier);
		//System.out.println("resul.debut.taille : " + resul.debut.taille());
		resul.fin = resul.debut.miroir();

		return resul;
	}

}
