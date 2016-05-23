package exercise07;

/**
 * @author Patrick Budig 5115455
 */

public class ArrayQueue<T> implements Queue<T> {

	private T[] queue;
	private int firstObject;
	private int nextEmptySlot;
	private int size;

	public ArrayQueue(int size) {
		queue = (T[]) new Object[size];
		firstObject = -1;
		nextEmptySlot = 0;
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws IllegalAccessException {
		if (firstObject == nextEmptySlot) {
			throw new IllegalAccessException("Queue voll!");
		} else {

			queue[nextEmptySlot] = element;

			nextEmptySlot = (nextEmptySlot + 1) % size;

			if (empty()) {
				firstObject = 0;
			}
		}
	}

	@Override
	public T dequeue() {
		T returnObject;
		if (empty()) {
			returnObject = null;
		} else {
			returnObject = queue[firstObject];
			queue[firstObject] = null;
			firstObject = (firstObject + 1) % size;

			if (firstObject == nextEmptySlot) {
				firstObject = -1;
				nextEmptySlot = 0;
			}
		}
		return returnObject;
	}

	@Override
	public T front() {
		T returnObject;
		if (empty()) {
			returnObject = null;
		} else {
			returnObject = queue[firstObject];
		}
		return returnObject;
	}

	@Override
	public boolean empty() {
		return (firstObject == -1);
	}

}
