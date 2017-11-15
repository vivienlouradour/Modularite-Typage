package session2.tp.v2;

import java.util.Iterator;

public class TestListe {

	public static void main(String[] args) {
		System.out.println("*******************");
		System.out.println("**Liste Immutable**");
		System.out.println("*******************");

		System.out.println("----Liste Vide----");
		Liste<Integer> l0 = Liste.vide();
		System.out.println("taille 0 ? " + l0.taille());
		System.out.println("estVide true ? " + l0.estVide());

		System.out.println("\n----Liste a un élément----");
		Liste<Integer> l1 = Liste.cons(2, Liste.vide());
		System.out.println("taille 1 ? " + l1.taille());
		System.out.println("estVide false ? " + l1.estVide());

		System.out.println("\n----Liste a deux éléments----");
		Liste<Integer> l2 = Liste.cons(1, Liste.cons(2, Liste.vide()));
		System.out.println("taille 2 ? " + l2.taille());
		System.out.println("estVide false ? " + l2.estVide());
		Iterator i = l2.iterator();
		System.out.println("parcours de la liste à deux éléments 1 2 ?");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Miroir 2 1 ?");
		Liste<Integer> l2reverse = l2.miroir();
		i = l2reverse.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("On ajoute 3 à la liste");
		Liste<Integer> l2AjoutElement = l2.ajouter(3);
		System.out.println("parcours de la liste 1 2 3?");
		i = l2AjoutElement.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		Liste<Integer> l2FileAAjouter = Liste.cons(4, Liste.cons(5, Liste.vide()));
		System.out.println("On ajoute a liste (4,5) à la liste (1,2,3)");
		Liste<Integer> l2Finale = l2AjoutElement.ajouter(l2FileAAjouter);
		System.out.println("Parcours de la liste 1 2 3 4 5 ?");
		i = l2Finale.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("On vérifie que la liste initiale n'a pas été modifiée 1 2 ?");
		i = l2.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		System.out.println("\n\n*******************");
		System.out.println("***Liste mutable***");
		System.out.println("*******************");

		System.out.println("\n----Liste Vide----");
		ListeMutable<Integer> l3 = ListeMutable.vide();
		System.out.println("casVide true ? " + l3.casVide());
		System.out.println("casCons false ? " + l3.casCons());

		System.out.println("\n----Liste a deux éléments----");
		ListeMutable<Integer> l4 = ListeMutable.cons(1, ListeMutable.cons(2, l3));
		System.out.println("casVide false ?" + l4.casVide());
		System.out.println("casCons true ? " + l3.casCons());

		System.out.println("\n----Liste a trois éléments----");
		l4 = ListeMutable.cons(0, l4);
		System.out.println("Parcours de la liste 0 1 2 ?");
		i = l4.iterator();
		while (i.hasNext())
			System.out.println(i.next());

		System.out.println("On inverse la liste 2 1 0 ?");
		l4.miroir();
		i = l4.iterator();
		while (i.hasNext())
			System.out.println(i.next());

		System.out.println("On remet la liste dans l'ordre et on y ajoute 3");
		l4.miroir();
		l4.ajouter(3);
		System.out.println("Parcours de la liste 0 1 2 3 ?");
		i = l4.iterator();
		while (i.hasNext())
			System.out.println(i.next());

		System.out.println("\n\n*******************");
		System.out.println("***File mutable***");
		System.out.println("*******************");

		System.out.println("Creation d'une file mutable vide");
		ImplementationFileMutable<Integer> FileM1 = ImplementationFileMutable.Fabrique.creer();
		System.out.println("Affichage \"\" ?" + FileM1.representation());

		System.out.println("On ajoute 1 dans cette file");
		FileM1.ajout(1);
		System.out.println("Representation 1 ? " + FileM1.representation());
		System.out.println("Taille de cette file 1 ? " + FileM1.taille());
		System.out.println("Taille de cette file.suivants() 0 ? " + FileM1.suivants().taille());
		System.out.println("Taille de cette file.copie() 1 ? " + FileM1.creerCopie().taille());
		System.out.println("Taille de cette file.copie().suivants() 0 ? " + FileM1.creerCopie().suivants().taille());

		System.out.println("On ajoute 2 dans cette file");
		FileM1.ajout(2);
		System.out.println("Taille de cette file 2 ? " + FileM1.taille());
		System.out.println("Taille de cette file.suivants() 1 ? " + FileM1.suivants().taille());
		System.out.println("Representation : " + FileM1.representation());

		System.out.println("Creation d'une file contenant les entiers de 3 a 10");
		ImplementationFileMutable<Integer> FileM2 = ImplementationFileMutable.Fabrique.creer();
		for (int index = 3; index <= 10; index++) {
			FileM2.ajout(index);
		}
		System.out.println("Représentation 3 4 5 6 7 8 9 10 ? " + FileM2.representation());

		System.out.println("retrait du premier element de cette liste");
		FileM2.retrait();
		System.out.println("Représentation 4 5 6 7 8 9 10 ? " + FileM2.representation());

		System.out.println("Fusion des deux liste précédement créées ");
		FileM1.ajout(FileM2);
		System.out.println("Representation 1 2 4 5 6 7 8 9 10 ? " + FileM1.representation());

		System.out.println("\n\n*******************");
		System.out.println("***File Immutable***");
		System.out.println("*******************");

		System.out.println("Creation d'une file immutable vide");
		FileImmutable<Integer> fileIm1 = ImplementationFileImmutable.Fabrique.creer();

		System.out.println("Affichage \"\" ?" + fileIm1.representation());

		System.out.println("On ajoute 1 dans cette file");
		fileIm1 = fileIm1.ajout(1);
		System.out.println("Representation 1 ? " + fileIm1.representation());
		System.out.println("Taille de cette file 1 ? " + fileIm1.taille());
		System.out.println("Taille de cette file.suivants() 0 ? " + fileIm1.suivants().taille());

		System.out.println("On ajoute 2 dans cette file");
		fileIm1 = fileIm1.ajout(2);
		System.out.println("Taille de cette file 2 ? " + fileIm1.taille());
		System.out.println("Taille de cette file.suivants() 1 ? " + fileIm1.suivants().taille());
		System.out.println("Representation : " + fileIm1.representation());

		System.out.println("Creation d'une file contenant les entiers de 3 a 10");
		FileImmutable<Integer> fileIm2 = ImplementationFileImmutable.Fabrique.creer();
		for (int index = 3; index <= 10; index++) {
			fileIm2 = fileIm2.ajout(index);
		}
		System.out.println("Représentation 3 4 5 6 7 8 9 10 ? " + fileIm2.representation());

		System.out.println("retrait du premier element de cette liste");
		fileIm2.retrait();
		System.out.println("Représentation 4 5 6 7 8 9 10 ? " + fileIm2.representation());

		System.out.println("Fusion des deux liste précédement créées ");
		fileIm1 = fileIm1.ajout(fileIm2);
		System.out.println("Representation 1 2 4 5 6 7 8 9 10 ? " + fileIm1.representation());

	}

}
