/**
 * An implementation of the Hash interface. A fixed-size hash class that
 * resolves hash collisions by utilising adjacent spaces.
 * 
 * @author Kip Lim
 * @version 1.4
 */
public class HashProbe implements Hash {
  // Meta note: all of these instance variables are not seen outside the
  // class, so they are private.
	private final int CAPACITY = 11;
	private final int PROBE = 1;
	private final int IN_USE = 2;
	private final int FORMERLY_IN_USE = 1;
	private final int NEVER_USED = 0;
	private int probe;
	private int capacity;
	private int size;
	private int [] hash;
	private int [] state;

  /**
   * Default constructor for a HashProbe
   */
	public HashProbe() {
		probe = PROBE;
		init();
	}

  /**
   * Parametrised constructor which allows the user to define the size of the
   * probe. 
   * @param probe the new size of the probe. 
   * @implNote Assumes probe > 0. Does not error handle.
   */
	public HashProbe(int probe) {
		this.probe = probe;
		init();
	}

  /**
   * Inserts a value into the hash table if possible.
   * 
   * @param value the value being inserted in the table.
   * @return true if the value was successfully inserted, false otherwise.
   */
	public boolean insert(int value) {
		if(size == capacity) {
      return false;
    } else {
			int location = hashmod(value);

			while(state[location] == IN_USE) {
        // Use mod arithmetic to wrap around to the beginning of the hash
        // table if needed
				location = (location + probe) % capacity;
			}

			hash[location] = value;
			state[location] = IN_USE;
			size++;
		}

		return true;
	}

  /**
   * Finds a value in the hash table.
   * 
   * @param value the value to look for
   * @return true if value was in the table, false otherwise.
   */
	public boolean find(int value) {
    for (int index = hashmod(value), // start at expected location
        num_lookups = 1; 
        state[index] != NEVER_USED 
        && num_lookups <= capacity; // prevent infinite lookups 
        index = (index + probe) % capacity, num_lookups++) {
      
      if (hash[index] == value && state[index] == IN_USE) {
        return true;
      }
		}

		return false;
	}

  /**
   * Removes a value from the hash table.
   * 
   * @param value
   * @return true if value was removed, false otherwise
   */
	public boolean delete(int value) {
		if(find(value)) {
      for (int index = hashmod(value); 
      state[index] != NEVER_USED ; index = (index + probe) % capacity) {
				if(state[index] == IN_USE && hash[index] == value) {
					state[index] = FORMERLY_IN_USE;
					size--;
					return true;
				}
			}
		}
		return false;
	}

	/** @Override
	 * Returns a string representation of the hash table.
	 * 
	 * @return a string where every line contains the index of the element and
	 * the value (or a dash if no value is present)
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < capacity; i++) {
			str += i + "     ";
			str += state[i] == IN_USE ? hash[i] : "-";
			str += "\n";
		}
		return str;
	}

	/**
	 * Initialises all the arrays of the class
	 */
	private void init() {
		capacity = CAPACITY;
		hash = new int [capacity];
		state = new int [capacity];
		size = 0;

		for(int i = 0; i < capacity; i++) {
			state[i] = NEVER_USED;
		}
	}

	/**
	 * A hashing function that determines the location of an integer by
	 * computing the mod.
	 * 
	 * @param value the value we want to place in the hash table
	 * @return the index to place the value
	 * @implNote this function does not resolve collisions
	 */
	private int hashmod(int value) {
		return value % CAPACITY;
	}
}
