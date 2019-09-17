package SinglyLinkedList;

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

		while(current.next != null)
			current = current.next;

		return current.getData();

	}

	/** Adds a new {@code Node<E>}, which contains the provided data, to the front of the {@code LinkedList<E>}.
	 *
	 * @param data the data which is to be added to the front of the {@code LinkedList<E>}.
	 */
	public void addFirst(E data) {

		Node<E> newNode = new Node<>(data);

		newNode.next = this.head;
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

			while(current.next != null)
				current = current.next;

			current.next = new Node<E>(data);

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

		if(index == this.size) {

			this.addLast(data);

		} else if(index == 0) {

			this.addFirst(data);

		} else {

			int counter = 0;

			Node<E> current = this.head;

			while (counter < index - 1) {

				current = current.next;

				counter++;

			}

			Node<E> newNode = new Node<>(data);

			newNode.next = current.next;
			current.next = newNode;

			this.size++;

		}

	}

	/** Removes the first {@code Node<E>} in the {@code LinkedList<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public void removeFirst() {

		if(this.isEmpty())
			throw new IllegalStateException();

		this.head = this.head.next;

		this.size--;

	}

	/** Removes the last {@code Node<E>} in the {@code LinkedList<E>}.
	 *
	 * @throws IllegalStateException if the {@code LinkedList<E>} is empty.
	 */
	public void removeLast() {

		if(this.isEmpty())
			throw new IllegalStateException();

		if(this.size == 1) {

			this.removeFirst();

		} else {

			Node<E> current = this.head;

			while(current.next.next != null)
				current = current.next;

			current.next = null;

			this.size--;

		}

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

		if(index == this.size - 1) {

			this.removeLast();

		} else if(index == 0) {

			System.out.println("HELLO");
			this.removeFirst();

		} else {

			int counter = 0;

			Node<E> current = this.head;

			while(counter < index - 1) {

				current = current.next;

				counter++;

			}

			current.next = current.next.next;

			this.size--;

		}

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

			result += "" + current.getData() + " ----> ";
			current = current.next;

		}

		result += "NULL";

		return result;

	}

}
