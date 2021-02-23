/**
 * Interface for fix-sized Hash tables. Collisions may be resolved in
 * different ways depending on the implementation.
 *
 * @author Kip Lim
 * @apiNote interface is implemented by the HashProbe and HashChain classes.
 * @version 1.2
 */
public interface Hash {
	/**
	 * Inserts a value into the hash table.
	 * 
	 * @param value the integer to be inserted in the table
	 * @return whether the value was successfully stored
	 */
	boolean insert(int value);

	/**
	 * Finds whether a value exists in the hash table.
	 * 
	 * @param value the integer being searched for
	 * @return true if the value was in the hash table
	 */
	boolean find(int value);

	/**
	 * Removes a value from the hash table.
	 * 
	 * @param value the integer being removed
	 * @return true if the value was removed from the hash table
	 */
	boolean delete(int value);

	/**
	 * Specifies string representation of the hash table.
	 *
	 * @return a string where every line contains the index of the element and
	 * the value (or a dash if no value is present)
	 */
	String toString();
}