/* McKenzie Allaben and Bijay Ranabhat
 * Algorithmic Graph Theory 
 * Shortest path algorithms programming assignment
 */
import java.io.IOException;
import java.util.ArrayList;	

public class Label
{
	public static void label(Graph G, int source) throws IOException //int source = index of source vertex
    {                  					
    	int numVertices; 
    	int [] dist;
    	int [] predecessor;
    	
        numVertices = G.numberOfVertices(); // gets number of vertices of graph 
        
        dist = new int[numVertices];       //length of # vertices read in 
        predecessor = new int[numVertices];

    	System.out.println("Generic Label Correcting Algorithm");
    	System.out.println("\n");

        System.out.println("Initialization:");
        System.out.println("----------------------------------");
        
        
        //prints graph vertices
        System.out.print("V:");
        for(int i=0; i < numVertices; i++)
        {
        	System.out.print((i) + " ");
        }
        System.out.println("\n");
        
        
        
        //distance array initialization 
        for(int n = 0; n < numVertices; n++) 			
        {
        	dist[n]=999; 		// same as infinity in code		
        }
       
        //distance from a source node to itself = zero
        dist[source] = 0;

      //prints distances
        System.out.print("D:");
        for(int i=0; i < dist.length; i++)
        {
        	System.out.print(dist[i] + " ");
        }
        
        System.out.println("\n");
        
        
       
        //predecessor array initialization 
        for(int n = 0; n < numVertices; n++) 			
        {
        	predecessor[n] = 0; //all predecessors initialized to 0 
        }
        
        //predecessor from a source node to itself = zero
        predecessor[source] = 0; 
        
        //prints predecessors 
        System.out.print("P:");
        for(int i=0; i < predecessor.length; i++)
        {
        	System.out.print(predecessor[i] + " ");
        }
        
        System.out.println("\n");

        
        int adjMatrix[][] = G.getAdj_Matrix(); //gets adjacency matrix of Cij values
        int iteration = 1;
        
        for(int i = 0; i < numVertices; i++)
        {
        	for(int j = 1; j < numVertices; j++)
        	{
        		if(adjMatrix[i][j] != 999)
        		{
        			while(dist[j] > dist[i] + adjMatrix[i][j])
        			{
        				dist[j] = dist[i] + adjMatrix[i][j];
        				predecessor[j] = (i); 
        			}
        		}
        	}
        	
        	System.out.println("Iteration:" + iteration);
            System.out.println("----------------------------------");

            System.out.print("V:");
            for(int m = 0; m < numVertices; m++)
    		{
    			System.out.print((m) + " ");
        		//System.out.println("\n");
    		}
    		System.out.println("\n");
        	
        	//System.out.println("Distance Array");
    		System.out.print("D:");
    		for(int m = 0; m < numVertices; m++)
    		{
    			System.out.print(dist[m] + " ");
        		//System.out.println("\n");
    		}
    		System.out.println("\n");
    		
        	//System.out.println("Predecessor Array");
    		System.out.print("P:");
    		for(int m = 0; m < numVertices; m++)
    		{
    			System.out.print(predecessor[m] + " ");
        		//System.out.println("\n");
    		}
    		System.out.println("\n");
    		System.out.println("\n");
    		
    		iteration++;
        }
     }
          
     
	 
   public static void main(String[] args) throws IOException //main execution method/runs the entire program
   {
	   //creates a graph object G using adjacency matrix that was read into the program 
       Graph G = new Graph("Network2.txt");
       G.printMatrix(); //prints adj. matrix
       // calls algorithm on graph G, with the source vertex starting at index 0
       label(G,0); //index of source vertex is zero 
    } 
}


