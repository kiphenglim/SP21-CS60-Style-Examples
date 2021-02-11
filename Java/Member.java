public class Member {
	private int parent;
	private int rank;

	public Member(int value) {
		parent = value;
		rank = 0;
	}

	public int getParent() { return parent; }
	public int getRank() { return rank; }
	public void setParent(int rep) { parent = rep; }
	public void incrementRank() { rank++; }
}