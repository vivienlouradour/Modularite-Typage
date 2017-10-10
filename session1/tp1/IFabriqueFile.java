package session1.tp1;

public interface IFabriqueFile<T> {
	IFile<T> creerFile();
	IFile<T> creerFile(T element);
}
