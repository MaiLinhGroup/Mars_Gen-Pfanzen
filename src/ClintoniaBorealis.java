
public class ClintoniaBorealis implements IGraph {
	private int numberOfNodes;
	
	public ClintoniaBorealis(int n) {
		numberOfNodes = n;
	}
	
	@Override
	public void addNode() {
	}
	

	@Override
	public boolean addEdge(int scr, int dest) {
		int j = (scr % numberOfNodes)+1;
		return dest == j ? true : false;
	}


}
