package DataStructures;

import java.util.NoSuchElementException;

/**
 * The type Linked list.
 */
public class LinkedList {
    private class Node{
        private int value;
        private Node next;

        /**
         * Instantiates a new Node.
         *
         * @param value the value
         */
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    /**
     * Add last.
     *
     * @param item the item
     */
    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Add first.
     *
     * @param item the item
     */
    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty()){
            first = last = node;
        }
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    /**
     * Index of int.
     *
     * @param item the item
     * @return the int
     */
    public int indexOf(int item){
        //traverse the list from beginning to end.
        int index = 0;
        var current = first;
        while(current!= null){
            if(current.value == item) return index;
            current = current.next;
            index ++;
        }
        return -1;
    }

    /**
     * Contains item boolean.
     *
     * @param item the item
     * @return the boolean
     */
    public boolean containsItem(int item){
        return indexOf(item) !=-1;
    }

    /**
     * Remove first.
     */
    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    /**
     * Remove last.
     */
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last)
            first = last = null;
        else{
            Node previous = getPreviousNode(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    /**
     * To array int [ ].
     *
     * @return the int [ ]
     */
    public int[] toArray(){
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    /**
     * Reverse linked list.
     */
    public void reverseLinkedList(){
        //[10 <- 20 -> 30 -> 40]
        //[40--> 30--> 20--> 10]
        //1.set the head as tail.
        //2. Point the next node to previous node.
        if(isEmpty()) return;
        Node previous = first;
        Node current = first.next;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    /**
     * Get kth element from last int.
     *
     * @param k the k
     * @return the int
     */
    public int  getKthElementFromLast(int k){
        //[10 -> 20 -> 30 -> 40 -> 50]
        if(isEmpty())
            throw  new IllegalStateException();
        var  a = first;
        var b = first;
        for(int i = 0; i < k-1; i++){
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }
        while(b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    /**
     * Has loop boolean.
     *
     * @return the boolean
     */
    public boolean hasLoop(){
        //[10 -> 20 -> 30 -> 40 -> 50]
        Node a = first;
        Node b = first;
        while(b!=null && b.next != null){
            a = a.next;
            b = b.next.next;
            if(a == b)
                return true;
        }
        return false;
    }


    public String printMiddle(){
        //[10 -> 20 -> 30 -> 40 -> 50 -> 60]
        Node a = first;
        Node b = first;
        while(b != last && b.next != last){
            a = a.next;
            b = b.next.next;
        }
        if(b == last) return Integer.toString(a.value);
        else{
            return a.value + "," + a.next.value;
        }
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    /**
     * Get size int.
     *
     * @return the int
     */
    public int getSize(){
        return size;
    }

    private boolean isEmpty(){
        return first == null;
    }
}
