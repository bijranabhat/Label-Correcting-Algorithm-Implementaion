import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph 
{
	//defined values key 
	private static final String INF = "&"; 
	//private static final int infinity = 999; //giving it a large value so will have same effect as being infinity
	
	//graph variables 
	private int numVertices; 
	private int[][] adj_Matrix; 
	private BufferedReader graphInput; 
	private int [] nextVertex;
	public int edgeWeight; 
	
	//graph constructor
	public Graph (int numV)
	{
		numVertices = numV; 
		setAdj_Matrix(new int[numVertices][numVertices]); //formulates dimensions of adjacency matrix 
		
		//when we need to reset graph to clean slate
		this.resetG();	
		
		nextVertex = new int[numVertices];
		for(int i = 0; i < numVertices; i++)
		{
			nextVertex[i] = -1; //removes number of vertex by making it negative (won't go to it)
		}
			
	}
	
	//Constructor method to read in text file with details of the map
	public Graph (String filename) throws IOException
	{
		graphInput = fileInput(filename); 
		inputG(); 
		
		//every time a new graph is read in, a new next array is made and reset
		nextVertex = new int[numVertices]; 
		
		//called when we need to modify the next vertices to examine
		resetNextVertex(); 
	}
	
	private BufferedReader fileInput(String filename)
	{
		BufferedReader reader = null; 
		
		//try catch method to make sure don't get error if file DNE 
		try
		{
			reader = new BufferedReader (new FileReader(filename));
		}
		catch (FileNotFoundException fnf)
		{
			System.out.println("File was not found");
		}
		catch (IOException io)
		{
			System.out.println("File was not found: IO");
		}
		
		return reader; 
	}
	
	
	public void resetG() //initializing Graph 2D array 
	{
		//setting all adj values to infinity for each vertex in matrix 
		for(int i = 0; i < numVertices; i++) //rows of adjacency matrix
		{
			for(int j = 0; j < numVertices; j++) //columns of adjacency matrix
			{
				getAdj_Matrix()[i][j] = 999; //see definition of infinity above  
			}
			getAdj_Matrix()[i][i] = 0; //diagonals (1,1; 2,2; 3,3; etc to zero because distance to itself is zero
		}
		
	}
	
	//turns text file into adj_Matrix 
	
	public void inputG()
	{
		int i; //represent rows
		int j; //represents columns 
		String line; 
		String currentValue;
		StringTokenizer tokenizer; //breaks each value in txt file into seperate token or parsing essentially
		
		try
		{
			line = graphInput.readLine(); 
			tokenizer = new StringTokenizer(line); 
			currentValue = tokenizer.nextToken();
			numVertices = Integer.parseInt(currentValue);
			setAdj_Matrix(new int[numVertices][numVertices]); //initializing 2D array
			
			i = 0; //row value is zero 
			
			while((line = graphInput.readLine()) != null)
			{
				tokenizer = new StringTokenizer(line); 
				j = 0; //all col values are zero 
				
				while(j < numVertices && tokenizer.hasMoreTokens())
				{
					currentValue = tokenizer.nextToken(); 
					if(currentValue.compareTo(INF) == 0)
					{
						getAdj_Matrix()[i][j++] = 999;
					}
					else
					{
						getAdj_Matrix()[i][j++] = Integer.parseInt(currentValue); 
					}
				}
				
				i++; //next row (traversing and completing all of this for each row in matrix) 
			}
		}
		catch (IOException io)
		{
			System.out.println("cannot finish closing filereader");
		}
		
		finally
		{
			try
			{
				if(graphInput != null)
				{
					graphInput.close(); 
				}
			}
			catch (IOException io)
			{
				System.out.println("cannot close filereader");
			}
		}
	}
	
	
	//gets edge weight between two vertices -- i=source, j=terminus
	public int edgeWeight(int i, int j)
	{
		return getAdj_Matrix()[i][j];
	}
	
	//gets number of vertices in graph
	public int numberOfVertices()
	{
		return numVertices;
	}
	
	//method to isolate a specific row of the adjacency matrix 
	public int[]getRow (int i) //note: j represents a column
	{
		int[]row = new int[numVertices];
		for(int j = 0; j < numVertices; j++)
		{
			row[j] = getAdj_Matrix()[i][j];
		}
		
		return row;
	}
	
	public int neighbor(int v)
	{
		nextVertex[v] = nextVertex[v] + 1;
		if(nextVertex[v] < numVertices)
		{
			while( (getAdj_Matrix()[v][nextVertex[v]] == 0) && (nextVertex[v] < numVertices))
			{
				nextVertex[v] = nextVertex[v] + 1;
				if(nextVertex[v] == numVertices)
				{
					break; //get out of loop once have hit all of the neighboring vertices
				}
			}
		}
		
		if(nextVertex[v] >= numVertices)
		{
			nextVertex[v] = -1;
			edgeWeight = -1; 
		}
		else 
		{
			edgeWeight = getAdj_Matrix()[v][nextVertex[v]];
		}
		return nextVertex[v];
	}
	
	public void resetNextVertex()
	{
		for(int i = 0; i < numVertices; i++)
		{
			nextVertex[i] = -1;
		}
	} 
	
	public void printMatrix()  //May need to comment this out unless Prof. B wants original printed
	{
		System.out.println("Adjacency Matrix");
		for(int i = 0; i < numVertices; i++)
		{
			for(int j = 0; j < numVertices; j++)
			{
				/*if(getAdj_Matrix()[i][j] > infinity - 0.01 * infinity)
				{
					System.out.println("& ");
				}*/
				//else 
				{
					System.out.print("" + getAdj_Matrix()[i][j] + " ");
				} 
			}
			
			System.out.println(); //prints matrix 
		}
		System.out.println("\n"); //prints new line 
	}

	public int[][] getAdj_Matrix() {
		return adj_Matrix;
	}

	public void setAdj_Matrix(int[][] adj_Matrix) {
		this.adj_Matrix = adj_Matrix;
	} 
	
}
