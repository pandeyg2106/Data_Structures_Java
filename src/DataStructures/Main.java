package DataStructures;


public class Main {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.areSiblings(4,9));


        /*
        var inputList = list.createWithLoop();
        System.out.println(inputList.hasLoop());*/
 /*       list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);*/

//        System.out.println(list.printMiddle());

//        System.out.println(list.getKthElementFromLast(5));

//       list.reverseLinkedList();

        /*var array = list.toArray();
        System.out.println(Arrays.toString(array));*/

/*      System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(40));*/

/*      System.out.println(list.containsItem(10));
        System.out.println(list.containsItem(20));
        System.out.println(list.containsItem(30));
        System.out.println(list.containsItem(40));*/

//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list.getSize());
    }
}
