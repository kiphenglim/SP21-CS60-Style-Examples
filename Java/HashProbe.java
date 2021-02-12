public class HashProbe implements Hash
{
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

	public HashProbe() {
		probe = PROBE;
		init();
	}

	public HashProbe(int probe) {
		this.probe = probe;
		init();
	}

	public boolean insert(int value) {
		if(size == capacity) {
      return false;
    } else {
			int location = hashmod(value);

			while(state[location] == IN_USE) {
				location = (location + probe) % capacity;
			}

			hash[location] = value;
			state[location] = IN_USE;
			size++;
		}

		return true;
	}

	public boolean find(int value) {
		int counter = 1;
		for(int index = hashmod(value) ; state[index] != NEVER_USED && counter <= capacity; index = (index + probe) % capacity) {
			counter++;
			if(hash[index] == value && state[index] == IN_USE) return true;
		}

		return false;
	}

	public boolean delete(int value) {
		if(find(value)) {
			for(int index = hashmod(value) ; state[index] != NEVER_USED ; index = (index + probe) % capacity) {
				if(state[index] == IN_USE && hash[index] == value) {
					state[index] = FORMERLY_IN_USE;
					size--;
					return true;
				}
			}
		}
		return false;
	}

	public void print() {
		for(int i = 0 ; i < capacity ; i++) {
			if(i < 10) System.out.print(i + "     ");
			else System.out.print(i + "    ");

			if(state[i] == IN_USE) System.out.println(hash[i]);
			else System.out.println("-");
		}
	}

	private void init() {
		capacity = CAPACITY;
		hash = new int [capacity];
		state = new int [capacity];
		size = 0;

		for(int i = 0; i < capacity; i++)
		{
			state[i] = NEVER_USED;
		}
	}

	private int hashmod(int value) {
		return value % CAPACITY;
	}
}
