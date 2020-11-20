package com.practice.bfs;

import java.util.*;

public class BFS<T> {

    public <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

    private class Tree<T> {

        private T value;
        private List<Tree<T>> children;

        private Tree(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public <T> Tree<T> of(T value) {
            return new Tree<>(value);
        }

        public T getValue() {
            return value;
        }

        public List<Tree<T>> getChildren() {
            return Collections.unmodifiableList(children);
        }

        public Tree<T> addChild(T value) {
            Tree<T> newChild = new Tree<>(value);
            children.add(newChild);
            return newChild;
        }
    }


}
