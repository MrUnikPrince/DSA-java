package Graph;

import java.util.ArrayList;

public class CycleInGraphs {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean  detectCycle(ArrayList<Edge>graph[]) {
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                if(detectCycleUtil(graph, visited,i, -1)){
                    return true;
                }
            }
        }   
        return false; 
    }
    private static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int current, int parents){
        visited[current] = true;

        for(int i=0; i< graph[current].size(); i++){
            Edge e  = graph[current].get(i);
            // case 3 
            if(!visited[e.dest]){
                if(detectCycleUtil(graph, visited, e.dest, current)){
                    return true;
                }
            }else if(visited[e.dest] && e.dest != parents){    // case 1
                return true;
            }
                // case 2 says do nothing here just keep watching what's going on 
            }
        return false;
    }
     public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        // graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
        // graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }


}