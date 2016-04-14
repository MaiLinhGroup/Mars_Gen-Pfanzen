import java.util.Scanner;

public class Geninizer3000 {

	public enum GraphType {
		CBOREALIS, CUDENSIS, LCOLUMNARIS;
		
		@Override
		 public String toString() {
		    switch(this) {
		      case CBOREALIS: return "Clintonia Borealis";
		      case CUDENSIS: return "Clintonia Udensis";
		      case LCOLUMNARIS : return "Lobelia Columnaris";
		      default: throw new IllegalArgumentException();
		    }
		  }
	}
	/**
	 * Use Scanner class to read in 2 parameters, after checking the parameters,
	 * print out edge list depending on input graph type
	 * @param args
	 */
	public static void main(String[] args) {
		/*1st args is type of graph aka plant*/
		String graph;
		/*2nd args is total number of nodes*/
		int n;
		
		System.out.println("First enter the type of plant and then the total number of nodes.");
		
		try (Scanner input = new Scanner(System.in)) {/*try-with-resources statement ensures that each resource is closed at the end of the statement*/
			
			graph = input.next();
			GraphType graphType = GraphType.valueOf(graph);	//check whether graph type is legal
			
			n = input.nextInt();
			if(n%2 != 0) {
				System.err.println("Total number of nodes must be even!");
				return;
			}
			
			switch (graphType) {
			case CBOREALIS:
				System.out.println(GraphType.CBOREALIS.toString()+" has "+n+" nodes, its edge list is: ");
				ClintoniaBorealis cb = new ClintoniaBorealis(n);
				createEdgeList(n, cb);
				break;
			case CUDENSIS:
				System.out.println(GraphType.CUDENSIS.toString()+" has "+n+" nodes, its edge list is ");
				ClintoniaUdensis cu = new ClintoniaUdensis(n);
				createEdgeList(n, cu);
				break;
			case LCOLUMNARIS:
				double m = Math.sqrt(n);
				if ((m%2)!=0) {
					System.err.println("Number of nodes must be: sqrt(n) = m, for m is even");
					return;
				}
				System.out.println(GraphType.LCOLUMNARIS.toString()+" has "+n+" nodes, its edge list is ");
				LobeliaColumnaris lc = new LobeliaColumnaris((int)m);
				createEdgeList(n, lc);
				break;
			default:
				break;
			}
		}

	}
	
	/**
	 * Creating an edge list depending on graph type and printing it on console.
	 * @param n	total number of nodes of input graph
	 * @param graph type of input graph
	 */
	public static void createEdgeList(int n, IGraph graph) {
		EdgeListGraph graphEdgeList = new EdgeListGraph();
		
		for (int i = 0; i < n; i++) {
			graphEdgeList.addNode();
		}
		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= n; k++) {
				if(graph.addEdge(j, k)) {
					graphEdgeList.addEdge(j, k);
				}
				else{
					continue;
				}
			}
		}
		
		graphEdgeList.getEdgeList();
	}
}
