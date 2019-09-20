package DoublyLinkedList;

public class LinkedList<E extends Comparable<E>> {

	private Node<E> head;
	private int size;

	public LinkedList() {

		this.head = null;
		this.size = 0;

	}

	/** Returns the data inside the first {@code Node<E>}.
	 *
	 * @return the data inside the first {@code Node<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public E first() {

		if(this.isEmpty())
			throw new IllegalStateException();

		return this.head.getData();


	}

	/** Returns the data inside the last {@code Node<E>}.
	 *
	 * @return the data inside the last {@code Node<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public E last() {

		if(this.isEmpty())
			throw new IllegalStateException();

		Node<E> current = this.head;

		while(current.right != null)
			current = current.right;

		return current.getData();

	}

	/** Adds a new {@code Node<E>}, which contains the provided data, to the front of the {@code LinkedList<E>}.
	 *
	 * @param data the data which is to be added to the front of the {@code LinkedList<E>}.
	 */
	public void addFirst(E data) {

		Node<E> newNode = new Node<>(data);

		newNode.right = this.head;

		this.head = newNode;

		this.size++;

	}

	/** Adds a new {@code Node<E>}, which contains the provided data, to the end of the {@code LinkedList<E>}.
	 *
	 * @param data the data which is to be added to the end of the {@code LinkedList<E>}.
	 */
	public void addLast(E data) {

		if(this.isEmpty()) {

			this.addFirst(data);

		} else {

			Node<E> current = this.head;

			while(current.right != null)
				current = current.right;

			Node<E> newNode = new Node<>(data);

			current.right = newNode;
			newNode.left = current;

			this.size++;

		}

	}

	/** Adds a new {@code Node<E>}, which contains the provided data, to the designated index.
	 *
	 * @param data the data which is to be added to the {@code LinkedList<E>}.
	 *
	 * @param index the index where the new {@code Node<E>} should be added.
	 *
	 * @throws IndexOutOfBoundsException if the {@code LinkedList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than to the current size of the {@code LinkedList<E>}.
	 */
	public void add(int index, E data) {

		if(this.isEmpty() || index < 0 || index > this.size)
			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		Node<E> current = this.head;

		int counter = 0;

		while(counter < index - 1) {

			current = current.right;
			counter++;

		}

		Node<E> newNode = new Node<>(data);

		newNode.right = current.right;
		newNode.right.left = newNode;
		current.right = newNode;
		newNode.left = current;

		this.size++;

	}

	/** Removes the first {@code Node<E>} in the {@code LinkedList<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public void removeFirst() {

		if(this.isEmpty())
			throw new IllegalStateException();

		this.head = this.head.right;
		this.head.left = null;

		this.size--;

	}

	/** Removes the last {@code Node<E>} in the {@code LinkedList<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public void removeLast() {

		if(this.isEmpty())
			throw new IllegalStateException();

		Node<E> current = this.head;

		while(current.right.right != null)
			current = current.right;

		current.right = null;

		this.size--;

	}

	/** Removes the {@code Node<E>} at the designated index.
	 *
	 * @param index the index of the {@code Node<E>} that should be removed.
	 *
	 * @throws IndexOutOfBoundsException if the {@code LinkedList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than or equal to the current size of the {@code LinkedList<E>}.
	 */
	public void remove(int index) {

		if(this.isEmpty() || index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		Node<E> current = this.head;

		int counter = 0;

		while(counter < index - 1) {

			current = current.right;

			counter++;

		}

		current.right = current.right.right;
		current.right.left = current;

		this.size--;

	}

	/** Returns {@code true} if the {@code LinkedList<E>} is empty and {@code false} if it is not.
	 *
	 * @return {@code true} if the {@code LinkedList<E>} is empty and {@code false} if it is not.
	 */
	public boolean isEmpty() {

		return this.size == 0;

	}

	/** Returns the current size of the {@code LinkedList<T>}.
	 *
	 * @return the current size of the {@code LinkedList<T>}.
	 */
	public int size() {

		return this.size;

	}

	/** Formats a {@code String} representation of the {@code ArrayList<E>}.
	 *
	 * @return a {@code String} representation of the {@code ArrayList<E>}.
	 */
	@Override
	public String toString() {

		String result = "";

		Node<E> current = this.head;

		while(current != null) {

			result += "" + current.getData() + " <----> ";
			current = current.right;

		}

		result += "NULL";

		return result;

	}

}
