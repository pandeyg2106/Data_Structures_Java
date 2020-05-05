package DataStructures;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsOfQueue {

    public static void reverse(Queue<Integer> queue, int k){

        if(k < 0 || k > queue.size())
            throw new IllegalArgumentException("k should be greater than 0 and less than or equal to queue size.");

        Stack<Integer> stack = new Stack<>();

        //Dequeue the first k elements in the queue, and push it to stack.

        for(int i = 0; i<k; i++){
            stack.push(queue.remove());
        }

        //Enqueue the content of the stack to the back of the queue.
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

/*        for(int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());*/
    }


    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        System.out.println(queue.toString());
        reverse(queue,3);
        System.out.println(queue.toString());
    }
}
