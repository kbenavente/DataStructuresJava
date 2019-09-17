package ArrayList;

public class ArrayList<E> {

	private E[] data;
	private int size;

	public ArrayList() {

		this.data = (E[]) new Object[8]; // Initialize underlying Array with a capacity of 8.
		this.size = 0;

	}

	public ArrayList(int initial_size) {

		this.data = (E[]) new Object[initial_size];
		this.size = 0;

	}

	/** Returns the current {@code ArrayList<E>} size.
	 *
	 * @return the current {@code ArrayList<E>} size.
	 */
	public int size() {

		return this.size;

	}

	/** Returns {@code true} if the {@code ArrayList<E>} is empty and {@code false} if it is not.
	 *
	 * @return {@code true} if the {@code ArrayList<E>} is empty and {@code false} if it is not.
	 */
	public boolean isEmpty() {

		return this.size == 0;

	}

	/** Returns the {@code Object} at the given index.
	 *
	 * @param index the index of the {@code Object}.
	 *
	 * @return the {@code Object} at the given index.
	 *
	 * @throws IndexOutOfBoundsException if {@code ArrayList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than or equal to the current size of the {@code ArrayList<E>}.
	 */
	public E get(int index) {

		if(this.isEmpty() || index < 0 || index >= this.size) {

			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		} else {

			return this.data[index];
		}

	}

	/** Sets the element at the designated index with the provided item.
	 *
	 * @param index the index which is to be set.
	 *
	 * @param item the item that will set the element at the given index.
	 *
	 * @throws IndexOutOfBoundsException if {@code ArrayList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than or equal to the current size of the {@code ArrayList<E>}.
	 */
	public void set(int index, E item) {

		if(this.isEmpty() || index < 0 || index >= this.size) {

			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		} else {

			this.data[index] = item;
		}

	}

	/** Adds the specified item at the designated index.
	 *
	 * @param index the index which is to be used for adding the item.
	 *
	 * @param item the item that will set the element at the given index.
	 *
	 * @throws IndexOutOfBoundsException if {@code ArrayList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than or equal to the current size of the {@code ArrayList<E>}.
	 */
	public void add(int index, E item) {

		if(this.isEmpty() || index < 0 || index >= this.size) {

			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		} else if(this.size == this.data.length) {

			this.resize();

		} else {

			for(int i = this.size - 1; i >= index; i--) // Shift Array items to the right.
				this.data[i + 1] = this.data[i];

			this.data[index] = item;
			this.size++;

		}

	}

	/** Adds the specified item at the designated index.
	 *
	 * @param item the item that will set the element at the end of the {@code ArrayList<E>}.
	 */
	public void add(E item) {

		if(this.size == this.data.length) {

			this.resize();

		} else {

			this.data[this.size] = item;
			this.size++;

		}

	}

	/** Resizes the capacity of the {@code ArrayList<E>} by 2 * [current_capacity].
	 *
	 */
	private void resize() {

		E[] newList = (E[]) new Object[this.data.length * 2];

		for(int i = 0; i < this.size; i++)
			newList[i] = this.data[i];

		this.data = newList;

	}

	/** Removes the current item at the designated index.
	 *
	 * @param index index of item which is to be removed.
	 *
	 * @throws IndexOutOfBoundsException if {@code ArrayList<E>} is empty, {@code index} is less than 0, or {@code index} is greater than or equal to the current size of the {@code ArrayList<E>}.
	 */
	public void remove(int index) {

		if(this.isEmpty() || index < 0 || index >= this.size) {

			throw new IndexOutOfBoundsException("Index is out of bounds: " + index);

		} else {

			for(int i = index; i < this.size - 1; i++)
				this.data[i] = this.data[i + 1];

			this.data[this.size - 1] = null;
			this.size--;

		}

	}

	/** Formats a {@code String} representation of the {@code ArrayList<E>}.
	 *
	 * @return a {@code String} representation of the {@code ArrayList<E>}.
	 */
	@Override
	public String toString() {

		String result = "{";

		for(int i = 0; i < this.size; i++) {

			if(i == 0)
				result += "" + this.data[i];
			else
				result += ", " + this.data[i];

		}

		result += "}";

		return result;

	}

}
