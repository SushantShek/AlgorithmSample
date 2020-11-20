package com.practice.kosaraju;

import com.practice.Graph.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class SSCGraph {

    /*private class Node<T extends Comparable<T>>{
        int value, edge, time;
        public Node(int V, int E){
            this.value = V;
            this.edge = E;
        }
        public void setTime(int t){
            this.time = t;
        }
    }*/
    private int V;
    private LinkedList<Integer> adj[];

    SSCGraph(int v){
        this.V = v;
        adj = new LinkedList[v];

        for(int i =0; i< adj.length; ++i){
            adj[i] = new LinkedList<>();

        }
    }

    public void addEdge(int v, int edge){
        adj[v].add(edge);
    }

    public void performDFS(int v, boolean[] isVisited){

        int n;
        isVisited[v] = true;
        System.out.println( v + " ");

        Iterator itr = adj[v].iterator();

        while(itr.hasNext()){
            n = (int) itr.next();
            if(!isVisited[n]) {
                performDFS(n,isVisited);
            }
        }
    }

    SSCGraph transpose(){
        SSCGraph g = new SSCGraph(V);
        for(int v=0; v< V ; ++V){
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    public static void main(String []s){
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSCCs();
    }
}
