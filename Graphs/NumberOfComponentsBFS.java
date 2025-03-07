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

        boolean[] visited = new boolean[n];   

        // Set up the adjacency lists
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            // since its undirected
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for (int node = 0; node < n; node++) {

            if (!visited[node]) {
                BFS(node, adjList, visited);
                count++;
            }
        }
        return count;
    }

    public void BFS(int node, List<List<Integer>> adjList, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {

            int val = q.remove();
            visited[val] = true;
            List<Integer> adj = adjList.get(val);

            for (int x : adj) {
                if (!visited[x]) {
                    q.add(x);
                }
            }
        }
    }
}
