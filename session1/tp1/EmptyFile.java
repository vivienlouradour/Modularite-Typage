package session1.tp1;

public class EmptyFile<T> implements IFile<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void add(T element) {

    }

    @Override
    public Object getAndRemove() {
        return null;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
