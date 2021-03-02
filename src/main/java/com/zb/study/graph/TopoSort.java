package com.zb.study.graph;

import java.util.LinkedList;

/**
 * @author Zhang Bo
 * @date 2021/3/2 15:51
 */
public class TopoSort {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(3,1);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        topoSortByKahn(graph);
        System.out.println("----------------");
        topoSortByDfs(graph);
    }

   static class Graph{
        private int v;
        private LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int i, int j) {
            adj[i].add(j);
        }
    }

    public static void topoSortByKahn(Graph g) {
        int[] inDegree = new int[g.v];
        for (int i = 0; i < g.v; i++) {
            for (int j = 0; j < g.adj[i].size(); j++) {
                Integer k = g.adj[i].get(j);
                inDegree[k]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer r = queue.remove();
            System.out.println("顶点->"+r);
            for (int i = 0; i < g.adj[r].size(); i++) {
                Integer k = g.adj[r].get(i);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }

    public static void topoSortByDfs(Graph g) {
        int v = g.v;
        LinkedList<Integer>[] adj = g.adj;
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, visited, inverseAdj);
            }
        }
    }

    private static void dfs(int i, boolean[] visited, LinkedList<Integer>[] inverseAdj) {
        for (int j = 0; j < inverseAdj[i].size(); j++) {
            Integer w = inverseAdj[i].get(j);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, visited, inverseAdj);
        }
        System.out.println("顶点->"+i);
    }
}
