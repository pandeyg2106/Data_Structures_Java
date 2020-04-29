import java.util.ArrayList;
import java.util.LinkedList;

public class QueueUsingLinkedList {

    private class Node{
        private int value;
        private Node next;

        //Default constructor will create a Node with a value.
        public Node(int value){
            this.value =  value;
        }
    }
    private Node head;
    private Node tail;
    private int count;

    //O(1)
    public void enqueue(int item){
        //To enqueue we will create a new node, and set the tail pointing to null
        // to point this new node. Finally, we will set this node to point to null.
        Node newNode = new Node(item);
        if(head == null)
            head = tail = null;
        else{
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    //O(1)
    public int dequeue(){
        //To dequeue we will create a  new node. If head is null, we will return
        //an IllegalStateException.If head and tail are equal (one element queue)
        //then we will first copy the value of head to an int variable, and then set
        //head and tail to point to null.
        //If head != tail, then we will first:
        //1. Create a new node named second.
        //2. Copy the value of head to an int variable.
        //3. Set head.next as the new head.
        //4. Set the head to point to null.
        //5. Return the value of int variable.
        //6. Decrement the count  by 1.

        int value;
        if(head ==  null)
            throw new IllegalStateException();
        if(head == tail){
            value = head.value;
            head = tail = null;
        }
        else{
            value = head.value;
            Node second =  head.next;
            head = second.next;
        }
        count--;
        return value;
    }

    public int peek(){
        if(head == null)
            throw new IllegalStateException();
        return head.value;
    }

    public int size(){
        return count;
    }

    public String toString(){
        ArrayList<Integer> list = new ArrayList<>();

        Node current = head;
        while(current != null){
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }
}
