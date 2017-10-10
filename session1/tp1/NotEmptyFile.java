package session1.tp1;

public class NotEmptyFile<T> implements IFile<T> {
    private T head;
    private IFile<T> next;

    public NotEmptyFile(T element){
        this.head = element;
        this.next = new EmptyFile<T>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(T element) {
        t
    }

    @Override
    public T getAndRemove() {
        return null;
    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
