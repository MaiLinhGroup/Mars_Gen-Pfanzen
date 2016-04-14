
public class ClintoniaUdensis implements IGraph {
	private int numberOfNodes;
	
	public ClintoniaUdensis(int n) {
		numberOfNodes = n;
	}
	
	@Override
	public void addNode() {
	}

	@Override
	public boolean addEdge(int scr, int dest) {
		int j1 = (scr % numberOfNodes)+1;
		int j2 = (scr+numberOfNodes/2);
		return (dest == j1 || dest == j2) ? true : false;
	}

}
