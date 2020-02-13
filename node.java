package node;

public class node {
	public String Tou;
	public int D;
	public boolean visit;
	public String V;

	
	public void Node(String parent, int distance, boolean visited, String vertice){
		V = vertice; 
		Tou = parent;
		D = distance;
	    visit = visited;
		
	}
	                       
}



