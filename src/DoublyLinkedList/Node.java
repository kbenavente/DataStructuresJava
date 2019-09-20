package DoublyLinkedList;

public class Node<E extends Comparable<E>> {

	private E data;
	protected Node<E> left;
	protected Node<E> right;

	public Node() {

		this.data = null;
		this.left = null;
		this.right = null;

	}

	public Node(E data) {

		this.data = data;
		this.left = null;
		this.right = null;

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
