
public class LobeliaColumnaris implements IGraph {
	private int m;
	
	public LobeliaColumnaris(int m) {
		this.m = m;
	}

	@Override
	public void addNode() {
	}
	
	@Override
	public boolean addEdge(int scr, int dest) {
		/*
		 * case1: {(i+km,i+1+km)|for i = 1 to m-1 && k = 0 to m-1}
		 */
		for (int i1 = 1; i1 <= (m-1); i1++) {
			for (int k1 = 0; k1 <= (m-1); k1++) {
				if ((scr == (i1+k1*m)) && (dest == (i1+1+k1*m))) {
					return true;
				} 
			}
		}
		
		/*
		 * case2: {(i+km,i+m+km)|for i = 1 to m && k = 0 to m-2}
		 */
		for (int i2 = 1; i2 <= m; i2++) {
			for (int k2 = 0; k2 <= (m-1); k2++) {
				if ((scr == (i2+k2*m)) && (dest == (i2+m+k2*m))) {
					return true;
				} 
			}
		}
		
		//if no cases are matched then return false :(
		return false;
	}

	
}
