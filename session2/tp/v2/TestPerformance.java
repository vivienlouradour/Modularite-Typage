package session2.tp.v2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 
 * @author Vivien Louradour, Valentin Quiedeville
 * 
 *         Classe de test comparant les performances entre la fileMutable et la
 *         fileImmutable
 *
 */
public class TestPerformance {
	private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
	private static long diviseur = 1000000;

	public static void main(String[] args) {
		System.out.println("****************************");
		System.out.println("***Comparaison Performace***");
		System.out.println("****************************");
		int limite = 100;
		System.out.println("Pour tester nos implémentations nous allons créer une file dans laquelle nous allons"
				+ " ajouter tous les entiers de 0 à " + (limite - 1) + " puis les retirer");

		System.out.println("FILE IMMUTABLE");
		long temps = threadBean.getCurrentThreadCpuTime();
		ImplementationFileImmutable<Integer> immut = ImplementationFileImmutable.Fabrique.creer();

		for (int i = 0; i < limite; i++) {
			immut = (ImplementationFileImmutable<Integer>) immut.ajout(i);
			//if (i % 100 == 0)
			//System.out.println(immut.representation());
		}
		for (int i = 0; i < limite; i++) {
			immut = (ImplementationFileImmutable<Integer>) immut.retrait();
		}

		temps = threadBean.getCurrentThreadCpuTime() - temps;
		System.out.println(immut.getClass() + " - ajout/retrait: " + (temps / diviseur));

		System.out.println("FILE MUTABLE");
		temps = threadBean.getCurrentThreadCpuTime();
		ImplementationFileMutable<Integer> mut = ImplementationFileMutable.Fabrique.creer();
		for (int i = 0; i < limite; i++) {
			mut = (ImplementationFileMutable<Integer>) mut.ajout(i);
			//if (i % 100 == 0)
			//System.out.println(mut.representation());
		}
		for (int i = 0; i < limite; i++) {
			mut = (ImplementationFileMutable<Integer>) mut.retrait();
		}

		temps = threadBean.getCurrentThreadCpuTime() - temps;
		System.out.println(mut.getClass() + " - ajout/retrait: " + (temps / diviseur));

	}

}
