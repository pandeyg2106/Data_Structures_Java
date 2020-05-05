package DataStructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {

    //Initialize two queues.
    //Push and pop should happen only at one side of the queue.
    //Push operation: Add new item to the queue from the tail O(1).
    //Add every new item  added also to a new queue.
    //Pop operation: dequeue the new queue will pop the latest  item added.

    private static Queue<Integer> queue1 = new ArrayDeque<>();
    private static Queue<Integer> queue2 = new ArrayDeque<>();
    private int count = 0;

    public void push(int item){
        queue1.add(item);
        count++;
    }

    public int pop(){
        if(queue1.isEmpty())
            throw new IllegalStateException();
        while(queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        var temp = queue1;
        queue1 = queue2;
        queue2 =  temp;

        count--;
        return queue2.remove();
    }

    public int size(){
        return count;
    }

    public static void main(String[] args){
        StackUsingTwoQueues obj = new StackUsingTwoQueues();
        obj.push(10);
        System.out.println(queue1.toString());
        obj.push(20);
        System.out.println(queue1.toString());
        obj.push(30);
        System.out.println(queue1.toString());
        System.out.println(obj.pop()); ;
        System.out.println(queue1.toString());
        System.out.println(obj.size());


    }
}
