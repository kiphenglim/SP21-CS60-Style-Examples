/**
 * @author Kip Lim
 * @version 1.2
 *
 * A simple fixed-size int min-heap class implemented using arrays.
 *
 * Since heaps (also known as priority queues) are out of the scope of CS60,
 * here is a brief explanation for those who have never encountered them. In
 * short, min heaps are ordered data structures that contain elements with the
 * property that "parent" elements are smaller than all "children" elements.
 * Thus as one adds/removes elements, the structure must reorder itself in
 * order to maintain this property. This is commonly known as "heapify."
 * 
 * An in-depth understanding of heaps are not necessary; this file simply
 * serves as an example of coding conventions we expect in CS60.
 * 
 * Disclaimer: This code will not run because it doesn't have a main function.
 */
public class Heap {
	private int heap []; // Elements live in indices 1 to N
	private int capacity;
	private int size;

	/**
	 * Default Heap constructor. Constructs a heap with capacity 10.
	 */
	public Heap() {
		capacity = 10;
		size = 0;
		heap = new int[capacity + 1];
	}

	/**
	 * Parametrised Heap constructor.
	 * @param capacity The size of the heap.
	 */
	public Heap(int capacity) {
		this.capacity = capacity;
		size = 0;
		heap = new int[capacity + 1];
	}

	/**
	 * Getter for size instance variable.
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds an element to the heap, if possible, and heapify.
	 * @param element The element to be inserted.
	 * @return True if the element could be successfully inserted, False otherwise.
	 */
	public boolean insert(int element) {
		if(this.getSize() == capacity) {
			return false;
		} else if(this.getSize() == 0) {
			heap[1] = element;
		} else {
			// META NOTE: I would ordinarily write the code in a more readable
			// manner, but I did it this way to justify using in-line comments. That
			// being said, prefer more readable code over in-line comments. >:(
				
				int hole = this.getSize() + 1;
				
				// Bubble up the new element as long as it is smaller than its parents
				// Use a for loop to advance our new element's spot
				for (; element < heap[hole / 2] && hole != 1; hole = hole / 2) {
					heap[hole] = heap[hole / 2];
				}
				
				// Works because hole is defined outside the for loop
				heap[hole] = element;
			}
			
		size++;
		return true;
	}

	/**
	 * Removes the smallest element from the heap, then heapify.
	 * @return the former smallest integer in the heap
	 */
	public int remove() {
		int root = heap [1];
		int hole = 1;
		int rightmost = heap[size];
		size--;

		// Start at the top of the heap and move smaller elements up
		while (2 * hole + 1 <= size && 
				(heap[2 * hole] < rightmost || heap[2 * hole + 1] < rightmost)) {
			if (heap[2 * hole] < heap[hole * 2 + 1]) {
				heap[hole] = heap[hole * 2];
				hole = hole * 2;
			} else {
				heap[hole] = heap[hole * 2 + 1];
				hole = hole * 2 + 1;
			}
		}

		heap[hole] = rightmost;
		return root;
	}

	/**
	 * Represents the heap on the console in the form "Index: # - Value"
	 */
	public void print() {
		if (this.size == 0) {
			return;
		}

		for (int i = 1; i <= this.getSize(); ++i) {
			System.out.println("Index: " + i + " - " + heap[i]);
		}
	}
}