public class DisjointSet
{
	private int capacity;
	private Member member [];

	public DisjointSet(int cap) {
		capacity = cap;
		member = new Member[capacity];

		for(int value = 0; value < capacity; value++) {
			makeSet(value);
		}
	}

	public void makeSet(int value) {
		member[value] = new Member(value);
	}

	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}

	private void link(int x, int y) {
		if(member[x].getRank() > member[y].getRank()) {
			member[y].setParent(x);
		} else {
			member[x].setParent(y);

			if(member[x].getRank() == member[y].getRank()) {
				member[y].incrementRank();
			}
		}
	}

	public int findSet(int x) {
		if(member[x].getParent() != x) {
			member[x].setParent(findSet(member[x].getParent()));
		}
		return member[x].getParent();
	}

	private int depth(int x) {
		int d = 0;

		while(x != member[x].getParent()) {
			x = member[x].getParent();
			d++;
		}

		return d;
	}

	public void print() {
		for(int value = 0; value < capacity; value++) {
			if(value == member[value].getParent()) {
				System.out.println("New set");
				System.out.println(value);
				int level = 1;
				boolean found = true;

				while(found) {
					found = false;

					for(int v = 0; v < capacity; v++) {
						if(findPrint(value) == findPrint(v) && depth(v) == level) {
							System.out.print(v + " ");
							found = true;
						}
					}

					System.out.println();
					level++;
				}
			}
		}

		printMembers();
	}

	public void printMembers() {
		for(int value = 0; value < capacity; value++) {
			System.out.println(value
				+ " " + member[value].getParent()
				+ " " + member[value].getRank());
		}
	}

	private int findPrint(int x) {
		int rep = x;

		while(rep != member[rep].getParent()) {
			rep = member[rep].getParent();
		}

		return rep;
	}
}
