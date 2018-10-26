/*
* Date: 10/24/2018
* Type: LinkedList
* 数据结构: Queue, Adjancency List
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        ArrayList[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] <= 1) {
                queue.add(i);
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                res.add(node);
                for (int k = 0; k < graph[node].size(); k++) {
                    int next = (int)graph[node].get(k);
                    degree[next]--;
                    if (degree[next] == 1) {
                        queue.add(next);
                    }
                }
            }
        }
        return res;
    }
}