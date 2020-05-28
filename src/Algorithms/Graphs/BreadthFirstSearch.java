package Algorithms.Graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static class Node{
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name){
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array){
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(this);
            while(!queue.isEmpty()){
                Node current = queue.poll();
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    @Test
    public void testCase(){
        BreadthFirstSearch.Node graph = new BreadthFirstSearch.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        List<String> inputArray = new ArrayList<String>();
        Assert.assertTrue(compare(graph.breadthFirstSearch(inputArray), expected));
    }

    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
