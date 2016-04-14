import java.util.ArrayList;

public class EdgeListGraph implements IGraph {

	//first element of header is total number of nodes
	private final int numberOfNodes = 0;
	//second element of header is total number of edges
	private final int numberOfEdges = 1;
	//header contains only total number of nodes and edges of EdgeListGraph
	private int[] header;
	//ArrayList contains edges of EdgeListGraph, each is a pair of source node and destination node
	ArrayList<Edge> edgeList;

	public EdgeListGraph() {
		header = new int[]{0,0};
		edgeList = new ArrayList<Edge>();
	}

	//nested inner class 
	public class Edge {
		private int sourceNode;
		private int destinationNode;

		public Edge(int srcNode, int destNode){
			sourceNode = srcNode;
			destinationNode = destNode;
		}

		public int getSourceNode(){
			return sourceNode;
		}
		public int getDestinationNode(){
			return destinationNode;
		}

		@Override
		public String toString() {
			return "("+getSourceNode()+","+getDestinationNode()+")";
		}
	}

	/**
	 * Increase the total number of nodes of EdgeListGraph
	 */
	@Override
	public void addNode() {
		++header[numberOfNodes];
	}

	/**
	 * Add a new edge to edgeList of EdgeListGraph if and only if the incident nodes
	 * exist and the edgeList does not contain the new edge, 
	 * then increase the total number of edges of EdgeListGraph. 
	 */
	@Override
	public boolean addEdge(int scrNode, int destNode) {
//		System.out.println("Add ("+scrNode+","+destNode+")");
		//case : source or destination node does not exist 
		if (scrNode > header[0] || destNode > header[0] || scrNode < 1 || destNode < 1) {
			System.out.println("Incident nodes do not exist.");
			return false;
		}
		//case : edge already exist
		if (!edgeList.isEmpty()){ 
			for (Edge edge : edgeList) {
				if (scrNode == edge.getSourceNode() & destNode == edge.getDestinationNode()) {
					System.out.println("Edge "+edge +" already exist.");
					return false;
				}
			}
		}
		edgeList.add(new Edge(scrNode, destNode));
		++header[numberOfEdges];
//		System.out.println("successful");
		return true;
	}

	public void getEdgeList() {
		for (Edge edge : edgeList) {
			System.out.print(edge);
		}
	}

}