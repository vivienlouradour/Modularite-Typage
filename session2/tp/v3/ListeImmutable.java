package session2.tp.v3;

public interface ListeImmutable<E> extends ListeGenerique<E> {

    static <E> ListeGenerique<E> cons(E tete, ListeGenerique<E> reste){
        return new ListeImmutable<E>() {
            @Override
            public ListeGenerique<E> reste() {
                return reste;
            }

            @Override
            public int taille() {
                return 1 + reste.taille();
            }
        };
    }
}
