package session2.tp.v3;
import java.util.Iterator;

public interface ListeGenerique<E> extends Iterable<E>{

    ListeGenerique<E> reste();

    int taille();

    default public boolean estVide(){
        return this.taille() == 0;
    }

    default public boolean casCons(){
        return this.taille() > 0;
    }

    default E tete() {
        throw new UnsupportedOperationException();
    }

    default ListeGenerique<E> miroir(){
        ListeGenerique<E> result = ListeGenerique.vide();
        Iterator iterator = this.iterator();
        while (iterator.hasNext()){
            E tmp = (E) iterator.next();
            //result = ListeGenerique.cons(tmp, result);
        }
        return result;
    }

    default ListeGenerique<E> ajout(E element){
        ListeGenerique<E> result = vide();
        result = this.miroir();
        //result = cons(element, result);
        result = result.miroir();
        return result;
    }

    @Override
    default Iterator<E> iterator(){
        return new IterateurListe<E>(this);
    }

    static <E> ListeGenerique<E> vide(){
        return new ListeGenerique<E>() {
            @Override
            public ListeGenerique<E> reste() {
                return ListeGenerique.vide();
            }

            @Override
            public int taille() {
                return 0;
            }
        };
    }
}