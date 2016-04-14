
public interface IGraph {
		/**
		 * Add a new node v to a Graph g
		 */
		public void addNode();
		/**
		 * Add a new edge of Graph g between source node v and destination node u. 
		 * @param scr source node 
		 * @param dest destination node
		 * @return true if new edge could be added successfully
		 */
		public boolean addEdge(int scr, int dest);

}
