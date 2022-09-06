package advancedgraphs.hard;

import java.util.*;

/**
 * Problem: 332. Reconstruct Itinerary
 * Difficulty: Hard
 * Link: https://leetcode.com/problemsreconstruct-itinerary
 */
public class ReconstructItinerary {
    int flights = 0;
    List<String> output;
    HashSet<String> visitedEdges;

    public List<String> findItinerary(List<List<String>> tickets) {
        flights = tickets.size();
        HashMap<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> cities = graph.getOrDefault(ticket.get(0), new LinkedList<>());
            cities.add(ticket.get(1));
            graph.put(ticket.get(0), cities);
        }

        for (List<String> route : graph.values())
            Collections.sort(route);

        output = new ArrayList<>();
        visitedEdges = new HashSet<>();
        dfs(graph, "JFK");
        Collections.reverse(output);
        return output;
    }

    public void dfs(HashMap<String, List<String>> graph, String city) {
        LinkedList<String> neighbors = (LinkedList) graph.getOrDefault(city, new LinkedList<>());
        while (!neighbors.isEmpty()) {
            String neighbor = neighbors.pollFirst();
            dfs(graph, neighbor);
        }
        output.add(city);
    }
}