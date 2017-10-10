package session1.tp1;

public  class File<T> implements IFile<T> {
	private T head;
	private File<T> next;

	//Constructeurs :

	/**
	 * Construit une file vide
	 */
	protected File(){
		head = null;
		next = null;
		System.out.println("head = " + head);		
	}

	/**
	 * Construit une file avec un élement
	 * @param element Element à ajouter à la file
	 */
	protected File(T element) {
		head = element;
		next = null;
	}

	//Accesseurs :

	/**
	 *
	 * @return la tête de la liste
	 * Complexité constante o(1)
	 */
	private T getHead() {
		return head;
	}

	/**
	 *
	 * @return le prochain élement de la file
	 * Complexité constante o(1)
	 */
	private File<T> getNext() {
		return  next;
	}

	/**
	 *
	 * @param nextListe file à ajouter
	 * Complexité constante o(1)
	 */
	private void setNext(File<T> nextListe) {
		next = nextListe;
	}

	/**
	 *
	 * @param head Nouvelle tête de liste
	 * Complexité constante
	 */
	private void setHead(T head) {
		this.head = head;
	}


	//Services :

	/**
	 *
	 * @return Retourne la tête de la file et le supprime de celle-ci
	 * Complexité constante o(1)
	 */
	@Override
	public T getAndRemove(){
		T headToReturn = this.getHead();
		//Si la file contient d'autres élements, on écrase celui là avec le prochain
		if(this.getNext() != null) {
			this.setHead(this.getNext().getHead());
			this.setNext(this.getNext().getNext());

		}
		//Sinon, on supprime la tête
		else
			this.setHead(null);
		return headToReturn;
	}

	/**
	 *
	 * @return le premier élement de la liste sans le supprimer
	 * Complexité constante
	 */
	@Override
	public T get(){
		return this.getHead();
	}

	/**
	 *
	 * @return le nombre d'élements contenu dans la file
	 * Complexité linéaire o(n)
	 */
	@Override
	public int count(){
		if(this.isEmpty())
			return 0;
		else if(this.getNext() == null)
			return 1;
		else
			return 1 + this.getNext().count();
	}

	/**
	 *
	 * @param element Element à ajouter en tête de file
	 * Complexité constante o(1)
	 */
	@Override
	public void add(T element) {
		File<T> listeToAppend = new File(element);
		if(this.getHead() == null)
			this.setHead(element);
		else if (this.next == null) {
			this.setNext(listeToAppend);
		}
		else {
			this.getNext().add(element);
		}
	}


	/**
	 *
	 * @return vrai si la liste est vide
	 * Complexité constante o(1)
	 */
	@Override
	public boolean isEmpty() {
		return this.getHead()==null && this.getNext()==null;
	}
}
