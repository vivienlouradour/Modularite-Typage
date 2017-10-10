package session1.demo1;

public interface INat {
    //Accesseurs
    int val();
    int getChiffre(int i);

    //Services
    int taille();
    INat somme(INat x);
}
