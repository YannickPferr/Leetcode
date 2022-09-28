package other.easy;

import utils.linkedlist.Node;
import utils.linkedlist.ListNode;
import utils.trees.TreeNode;
import utils.graphs.Node;

    /**
    * Problem: 1971. Find if Path Exists in Graph
    * Difficulty: Easy
    * Link: https://leetcode.com/problemsfind-if-path-exists-in-graph
    */
    public class FindIfPathExistsInGraph {
    boolean found = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            HashSet<Integer> hs = graph.getOrDefault(edge[0], new HashSet<>());
            hs.add(edge[1]);
            graph.put(edge[0], hs);
            
            hs = graph.getOrDefault(edge[1], new HashSet<>());
            hs.add(edge[0]);
            graph.put(edge[1], hs);
        }
        
        dfs(graph, new HashSet<>(), source, destination);
        return found;
    }
    
    public void dfs(HashMap<Integer, HashSet<Integer>> graph, HashSet<Integer> visited, int source, int destination){
        if(!found){
            if(graph.get(source).contains(destination)){
                found = true;
                return;
            }
        
            visited.add(source);
            for(int neighbor : graph.get(source))
                if(!visited.contains(neighbor))
                    dfs(graph, visited, neighbor, destination);
        }
    }
}