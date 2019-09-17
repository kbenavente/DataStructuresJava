package SinglyLinkedList;

public class Node<E extends Comparable<E>> {

	protected Node<E> next;
	private E data;

	public Node() {

		this.next = null;
		this.data = null;

	}

	public Node(E data) {

		this.next = null;
		this.data = data;

	}

	/** Returns the {@code Node<E>}'s data.
	 *
	 * @return the {@code Node<E>}'s data.
	 */
	public E getData() {

		return this.data;

	}

	/** Sets the {@code Node<E>}'s data.
	 *
	 */
	public void setData(E data) {

		this.data = data;

	}

}
