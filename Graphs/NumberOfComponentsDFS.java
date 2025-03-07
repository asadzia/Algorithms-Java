/*

There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

The nodes are numbered from 0 to n - 1.

Return the total number of connected components in that graph.

Example 1:

Input:
n=3
edges=[[0,1], [0,2]]

Output:
1
Example 2:

Input:
n=6
edges=[[0,1], [1,2], [2,3], [4,5]]

Output:
2
Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2

*/

class Solution {
    public int countComponents(int n, int[][] edges) {

        // This can be solved by using both DFS and BFS
        // Both have the same time complexity.
        
        // Visited Array initialized with False
        boolean[] visited = new boolean[n];

        // Construct the adjacency list for all nodes
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            adjList.put(i, new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] x : edges) {

            List<Integer> temp = adjList.get(x[0]);
            temp.add(x[1]);
            adjList.put(x[0], temp);

            temp = adjList.get(x[1]);
            temp.add(x[0]);
            adjList.put(x[1], temp);
        }

        // now perform DFS from the root node
        int count = 0;

        for (int node = 0; node < n; node++) {

            if (!visited[node]) {
                DFS(node, adjList, visited);
                count++;
            }
        }
        return count;
    }

    public void DFS(int node, Map<Integer, List<Integer>> adjList, boolean[] visited) {

        List<Integer> adj = adjList.get(node);
        visited[node] = true;

        for (int val : adj) {

            if (!visited[val]) {
                DFS(val, adjList, visited);
            }
        }
    }
}
