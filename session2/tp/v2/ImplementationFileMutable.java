package session2.tp.v2;

import java.util.Iterator;

/**
 * 
 * @author Valentin Quiedeville, Vivien Louradour
 *
 * @param <E>
 * 
 *            Classe implémentant l'interface FileMutable
 */
public class ImplementationFileMutable<E> implements FileMutable<E> {
	ListeMutable<E> liste;
	ListeMutable<E> fin;

	@SuppressWarnings("rawtypes")
	public static ImplementationFileMutable Fabrique = new ImplementationFileMutable<>();

	@Override
	public E premier() {

		return liste.tete();
	}

	@Override
	public int taille() {

		return liste.taille();
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurFile<E>(this);
	}

	@Override
	public void ajouter(E element) {
		if (liste.estVide()) {
			liste = ListeMutable.cons(element, ListeMutable.vide());
			fin = ListeMutable.cons(element, ListeMutable.vide());
		} else {
			liste.ajouter(element);//Liste.Ajouter ajoute à la fin
			fin = ListeMutable.cons(element, liste);
		}

	}

	@Override
	public void retirer() {
		if (taille() == 1) {
			liste = ListeMutable.vide();
		} else {
			liste = ListeMutable.cons(liste.reste().tete(), liste.reste().reste());
		}
		fin.reste();
	}

	@Override
	public ImplementationFileMutable<E> creer() {
		ImplementationFileMutable<E> resul = new ImplementationFileMutable<E>();
		resul.liste = ListeMutable.vide();
		resul.fin = ListeMutable.vide();
		return resul;
	}

	@Override
	public ImplementationFileMutable<E> creerCopie() {
		if (taille() == 0) {
			return creer();
		} else {
			ImplementationFileMutable<E> resul = new ImplementationFileMutable<E>();
			resul.liste = ListeMutable.cons(this.liste.tete(), this.liste.reste());
			resul.fin = ListeMutable.cons(this.fin.tete(), this.fin.reste());
			return resul;
		}

	}

	/*@Override
	public void ajouter(File<E> secondeFile) {
		// TODO Auto-generated method stub
	
	}*/

}
