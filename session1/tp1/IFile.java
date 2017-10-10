package session1.tp1;

public interface IFile<T> {
	public boolean isEmpty(); //Renvoie vrai si la file est vide
	public void add(T element); //Ajoute un élement à la file
	public T getAndRemove(); //Recupere le premier élement de la file et le supprime de celle-ci
	public T get(); //Recupere le premier élement de la liste sans le supprimer
	public int count(); //Renvoie le nombre d'élements de la file
}
