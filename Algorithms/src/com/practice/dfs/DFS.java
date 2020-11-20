package com.practice.dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    LinkedList<Integer> adj[];
    int value;

    public DFS(int v) {
        value = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[value];
        runDFS(v, visited);
    }

    private void runDFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");
        Iterator it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = (int) it.next();
            if (!visited[n]) {
                runDFS(n, visited);
            }
        }
    }

    public static void main(String[] args) {

        DFS g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(1);

    }

}
