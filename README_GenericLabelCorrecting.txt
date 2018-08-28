McKenzie Allaben and Bijay Ranabhat
README FILE 
Algorithmic Graph Theory

Generic Label Correcting Algorihtm 

PROGRAM INPUT: 
*****************************************************************
This program is ideally run in the open source program, Eclipse-Java version.

The program reads in a txt file containing the graph network via the Graph.java class. The first line of the txt file specifies the number of vertices in the network and the adjacency matrix of the network is listed below. 

Note: In order to account for paths with a length of zero, 999 was used as a placeholder in the adjacency matrix to indicate that there was no path between two vertices. 

The network is read in as a two-dimensional array. 

In order to change the input of the program, the code "Network1.txt" in the Label.java class, must be changed to the title of your txt file before running the program: 

public static void main(String[] args) throws IOException 
    {
    	//creates a graph object G using adjacency matrix that was read 		into the program 
    	
	Graph G = new Graph("Network2.txt");
    	G.printMatrix(); //prints adj. matrix
    	
	// calls algorithm on graph G, with the source vertex starting at 		index 0
    	
	algorithm(G,0); //index of source vertex is zero 
    } 
*****************************************************************



Reading the console output: 
*****************************************************************
The format of the console output is the following: 
V: Vertex
D: Distance 
P: Predecessor 

The initialized output is printed first. 999 is the distance value for infinity.

Each iteration is then printed with the current state of the distance matrix and predecessor matrix that are each updated as the algorithm continues to traverse through the rows and columns of the adjacency matrix. 

The source vertex is labeled as vertex 0. The other vertices in the given networks are then labeled as 1, 2, 3, 4, etc. 

The last iteration completed shows the optimum distances and predecessors for the network--showing the shortest path from the source vertex to every other vertex in the network. 
*****************************************************************











