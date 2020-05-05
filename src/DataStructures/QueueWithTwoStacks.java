package DataStructures;

import java.util.Stack;
public class QueueWithTwoStacks {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    //O(1)
    public void enQueue(int item){
            stackA.push(item);
    }

    //O(n)
    public int deQueue(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStacks();
        return stackB.pop();
    }

    public boolean isEmpty(){
        return stackA.isEmpty() && stackB.isEmpty();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStacks();
        return stackB.peek();
    }

    private void moveStacks() {
        if (stackB.isEmpty())
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
    }

}
