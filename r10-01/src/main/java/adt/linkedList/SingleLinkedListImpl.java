package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return(head.isNIL());
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode auxHead = this.head;
		while(!auxHead.isNIL()){
			auxHead = auxHead.getNext();
			size++;
		}
		return size;
	}

	@Override
	public T search(T element) {
		T node = null;
		if (element != null){
			SingleLinkedListNode<T> aux = this.head;

			while(!aux.isNIL()){
				if (aux.getData().equals(element)) {
					node = aux.getData();
				}
				aux = aux.getNext();
			}
		}
		return node;

	}

	@Override
	public void insert(T element) {
		if(element != null){
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL()) {
				aux = aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element != null){
			SingleLinkedListNode<T> aux = this.head;
			if (head.getData().equals(element)){
				this.head = this.head.getNext();
			}
			else {
				//SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
				boolean removed = false;
				while (!aux.isNIL() && !removed){
					if(aux.getData().equals(element)){
						aux.setNext(aux.getNext().getNext());
						removed = true;
					}
					aux = aux.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		int size = size();
		T[] array = (T[]) new Object[size];
		SingleLinkedListNode<T> aux = head;
		int index = 0;

		while(!aux.isNIL()){
			array[index] = aux.getData();
			aux = aux.getNext();
			index++;
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
