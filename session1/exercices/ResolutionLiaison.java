package session1.exercices;

class A {}

class B extends A {}

class C extends B {}

class X {
	void f(A a){
		System.out.println("X.f(A)"); //Pas exécutée car type A moins proche de C que B
	}
	void f(B b){
		System.out.println("X.f(B)"); //Méthode exécutée
	}
	/*
	void f(C c) {
		System.out.println("X.f(C)");
	}
	 */
}

class Y extends X {
	void f(C c){
		System.out.println("Y.f(C)");
	}
}

public class ResolutionLiaison {
	public static void main(String[] args) {
		Y y = new Y();
		C c = new C();
		y.f(c);
		X x = y; //Execute la méthode f(B b) de la classe X. Sauf si la méthode X.f(C c) est décommentée. Dans ce cas là la méthode redéfinie (Y.f(C)) est choisie lors de l'exécution
		x.f(c);;
	}
}
