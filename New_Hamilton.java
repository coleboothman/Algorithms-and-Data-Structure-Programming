

/*
  Cole Boothman
  St.ID V00808231

*/



public class New_Hamilton
{
/* 
   CSC 320: Summer 2017.

   These first two routines are of type int and return
   0 if there is no Hamilton path/cycle and
   1 if there is a Hamilton path/cycle 
   It would be more common in Java to use a Boolean variable
   instead but I wanted the code to work the same way as the
   C code handed out so all students would be on a common footing.

   The new_hamilton_path routine can make a polynomial number
   of calls to hamilton_cycle. The syntax:
   int answer;
   answer= Hamilton.hamilton_cycle(G);

   The new_hamilton_cycle routine can make a polynomial number
   of calls to hamilton_path. The syntax:
   int answer;
   answer= Hamilton.hamilton_path(G);

   IMPORTANT NOTE:
   The adjacency matrix of the graph must be symmetric.
   If you want to add an edge (u, v) you should use the
   TWO statements:
  
   G[u][v]= 1;
   G[v][u]= 1;
  
*/



  /*
    New Hamilton Path. This function creates a new graph by creating a copy of the current graph
    and adding a vertice which is conncted to all other vertices in the current graph.

    If the new graph has a Hamilton Cycle in the new graph, there is a Hamilton Path in the current graph.

  */


   public static int new_hamilton_path(Graph G)
   {
       
      //Create a new Graph with number of nodes = G.n+1
      
      int answer;
      Graph new_graph = new Graph();
      new_graph.Adj = new int[G.n+1][G.n+1];
      new_graph.n = G.n+1;

      //Base case: return 1 if G.n is 1, since if the size of the graph is 1,
      // we will always have a Hamiltonian path or cycle.

      if(G.n == 1) 
      {
        return 1;
      } 

      
      //System.out.println("Num vertices: " + G.n);

      
      //Copy over the old adj matrix to the new one.
      for(int i=0; i<G.n; i++) {
          for(int j=0; j<G.n; j++) {
              new_graph.Adj[i][j] = G.Adj[i][j];
              
          }
      }

      //Add the new vertice to the adj list.
      for(int k=0; k<new_graph.n; k++) {
          new_graph.Adj[k][G.n] = 1;
          new_graph.Adj[G.n][k] = 1;


      }
      
      //check whether the new Graph has a cycle and return the answer.
      answer = Hamilton.hamilton_cycle(new_graph);

      return(answer);
   }

   
  /*
      The new Hamilton Cycle function chooses a vertice v in the current Graph G,
      and creates a new graph to test Hamilton Path on.
      
      It creates a copy of the current Graph G with three new vertices:

      v', a vertice which is connected to the same neighbours as v in the current Graph.

      s, a vertice which is connected ONLY to v'.

      t, a vertice which is connected ONLY to v.

      If our new graph with the new vertices has a Hamilton path, then s and t have to be the endpoints
      the path because they are connected only to v and v'. In this case, our original Graph G will have
      a hamilton cycle as well.
  
  */
  
  public static int new_hamilton_cycle(Graph G)
   {
      
      //initialization of new Graph
      int answer;
      Graph new_graph = new Graph();
      new_graph.Adj = new int[G.n+3][G.n+3];
      new_graph.n = G.n+3;

      
      
      // our chosen vertice to use, "v". NOTE: you could change this to be any vertice in the graph. 
      int vertice = 0;
     
      
      //Base case: if G.n is less or equal to 2, there is no hamiltonian cycle in the graph
      if(G.n <= 2) 
        return 0; 

      //Copy over the old adj matrix to the new graph
      for(int i=0; i<G.n; i++) {
        for(int j=0; j<G.n; j++) {
            new_graph.Adj[i][j] = G.Adj[i][j];
        }
      }

      //copy v' neighbours to be same as v neighbours in original graph
      for(int k=0; k<G.n; k++) {
           
        if(G.Adj[vertice][k] != 0) {
          new_graph.Adj[G.n][k] = 1;
          new_graph.Adj[k][G.n] = 1;
        }
      }

      //Connect t to our chosen vertice from the original graph
      new_graph.Adj[G.n+1][vertice] = 1;
      new_graph.Adj[vertice][G.n+1] = 1;

      
      //Connect s to v' 
      new_graph.Adj[G.n][G.n+2] = 1;
      new_graph.Adj[G.n+2][G.n] = 1;

      
      //TESTS BELOW

      //System.out.println();
      //System.out.println("new graph");

      //new_graph.print_graph();



      answer = Hamilton.hamilton_path(new_graph);
      return answer;


   }

}
