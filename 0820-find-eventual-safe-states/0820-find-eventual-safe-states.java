
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int node = 0; node < n; node++) {
            for (int neighbor : graph[node]) {
                reverseGraph.get(neighbor).add(node);
                outdegree[node]++;
            }
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                bfsQueue.add(i);
            }
        }

        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            for (int prev : reverseGraph.get(current)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    bfsQueue.add(prev);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                safeNodes.add(i);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
