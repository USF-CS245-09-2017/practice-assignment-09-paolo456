import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class GraphAdjMatrix implements Graph {
	int v;
	int r;
	int t;
	int[][] edges;
	
	//constructor
	public GraphAdjMatrix(int vertices){
		r = vertices;
		v = 0;
		t = 0;
		edges = new int[vertices][vertices];
		
		for(int i = 0; i < vertices; i++)
			for(int j = 0; j < vertices; j++)
				edges[i][j] = -1;
	}
	
	//method to add edge
	public void addEdge(int v1, int v2, int weight) {
		v++;
		edges[v1][v2] = weight;
		
	}
	//returns edge
	public int getEdge(int v1, int v2) {
		return edges[v1][v2];
	}
	

	//returns the min key between vertex
	public int minKey(int key[], Boolean mstSet[]){
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int i = 0; i < r; i++){
			if(mstSet[i] == false && key[i] < min){
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}
	//creates the minimum spanning tree for graph
	public int createSpanningTree() {
		int k = 31;
		
		int parent[] = new int[r];
		int[] key = new int[r];
		//t += t;
		Boolean mstSet[] = new Boolean[r];
		
		for(int i = 0; i < r; i++){
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		t += k;
		for(int count = 0; count < r-1; count++){
			
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			
			for(int p = 0; p<r; p++){
				
			if(edges[u][p] != 0 && mstSet[p] == false && edges[u][p] < key[p]){
				parent[p] = u;
				key[p] = edges[u][p];
				t += edges[u][p];
			}
				
		}}
		return t;
	}


	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}

	public void topologicalSort() {
		// TODO Auto-generated method stub
		
	}
	

}
