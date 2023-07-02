package Graph;
import java.util.*;
import java.util.ArrayList;
public class Main {
    static class Edge{
        int src;
        int dest;
        int wt;

        // constructor
        public Edge(int src, int dest, int w){
            this.src = src;
            this.dest = dest;
            this.wt = w;
        }
    }
    // A function to create Graph
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }
    // BFS algorithm

    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);  // Source node

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){ // visit once
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[], boolean[] visited, int curr){
        // visit 
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){ 
                dfs(graph, visited,e.dest);
            }
        }
    }

    // has path
    /*1-> src == dest = true
     * 2-> if(!visted) && hasPath(neighbors, dest){
     * true}
     * 3-> return false;
     */


     public static boolean hasPath( ArrayList<Edge> []graph, int src, int dest, boolean visited[] ){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(int i =0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }

            
        }
        return false;
     }

    //  for connnectedGraph
    
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph, new boolean[v], 0);
        System.out.println();
        System.out.println(hasPath(graph, 0,5, new boolean[v]));
        
    }
}
