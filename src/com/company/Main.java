package com.company;


import java.lang.reflect.Array;
import java.util.*;
import java.math.*;


class Node {
    int data;
    Node next;

    Node(int d, Node n){
        data = d;
        next = n;
    }
}

class Nod2 {
    char data;
    Nod2(char data){
        this.data = data;
    }
}

class Student {
    Integer id;
    Integer priority;
    Student(Integer id, Integer priority){
        this.id = id;
        this.priority = priority;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2){
        return -1*Integer.compare(st1.priority, st2.priority);
    }
}
public class Main {

    private static <T> void print(T t){
        System.out.println(t);
    }

    private static void printList(Node head){
        print("~~~~ Printing LinkedList ~~~~");
        Node current = head;

        while(current != null){
            print(current.data);
            current = current.next;
        }

    }

    private static void removeNthNode(Node head, int index){
        print("~~~~ Removing nth node, given an index ~~~~");
        if(head == null)return;
        Node prev = head;
        Node current = head;
        int count = 1;

        while(current != null){
            if(count == index){
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
            count++;
        }
    }

    private static void addNode(Node head, int value, int target){
        print("~~~~ Inserting a Node to a Linked List, given an index~~~~");
        if(head == null) return;

        Node current = head;
        Node prev  = head;
        int count = 1;
        while(current.next != null){
            if(count == target){
                Node new_node = new Node(value, current);
                prev.next = new_node;
                break;
            }
            count++;
            prev = current;
            current = current.next;
        }
    }
    private static int countNodes(Node head){
        print("~~~~ Counting Nodes in a LinkedList ~~~~");
        int count = 0;
        Node current = head;

        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    private static void revertList(Node previous, Node current){
        if(current == null) return;
        revertList(current, current.next);
        current.next = previous;

    }

    private static void printArrayList(List<Node> list){
        print("~~~~ Print ArrayList Using Iterator ~~~~");
        Iterator it = list.iterator();

        while(it.hasNext()){
            Integer data = ((Node) it.next()).data;
            print(data);
        }
    }

    private static void VectorUsage(){
        print("~~~~ Vector Usage ~~~~");
        Vector<Integer> vector = new Vector<>(Arrays.asList(new Integer[] {3,4,5,8,1,0,88,77}));
        Collections.sort(vector);
        System.out.println(vector);
    }

    private static void HashSetUsage(){
        print("~~~~ HashSet Usage ~~~~");
        Set<Integer> myset = new HashSet<>(Arrays.asList( new Integer [] {3,4,5,6}));
        System.out.println(myset.contains(10));
        myset.add(11);
        myset.remove(3);
        System.out.println("Size: "+ myset.size());
        System.out.println(myset);
    }

    private static void TreeSetUsage(){
        print("~~~~ TreeSet Usage ~~~~");
        System.out.println("=======");
        Set<Integer> myset2 = new TreeSet<>(Arrays.asList(new Integer[] {8,7,5,4}));
        System.out.println(myset2);
    }

    private static void StackUsage(){
        print("~~~~ Stack Usage ~~~~");
        Stack<Integer> myStack = new Stack<>();
        myStack.push(6);
        myStack.push(8);
        print("==Pushing==");
        System.out.println(myStack);
        print("==Peeking==");
        System.out.println(myStack.peek());
        print("==Poping==");
        System.out.println(myStack);
    }

    private static void HashMapUsage(){
        print("~~~~ HashMap Usage ~~~~");
        Vector<Integer> vector = new Vector<>(Arrays.asList(new Integer[] {4,5,6,7,8}));

        Map<Integer,String> myMap = new HashMap<>();

        for(Integer num: vector){
            myMap.put(num, ((Integer)(num+10)).toString());
        }

        print(myMap);
        print(myMap.entrySet());

    }

    private static void HashTableUsage(){
        print("~~~~ HashTable Usage ~~~~");
        Vector<Integer> vector = new Vector<>(Arrays.asList(new Integer[] {4,5,6,7,8}));
        Map<Integer,String> hashtable = new Hashtable<>();

        for(Integer num: vector){
            hashtable.put(num, ((Integer)(num+10)).toString());
        }

        print("Contains key=5 ? " + hashtable.containsKey(5));
        print("Contains value=15 ? "+ hashtable.containsValue("15"));
        print(hashtable);
        print("Removing key =5");
        hashtable.remove(5);
        print(hashtable);
        print("Printing individual values by iteration");
        for(Integer key: hashtable.keySet()){
            String value = hashtable.get(key);
            print(value + " ");
        }
    }

    private static void QueueUsage(){
        print("~~~~ Queue Usage with LinkedList implementation ~~~~");
        Integer [] array = {4,5,8,2,10};
        Queue<Integer> myqueue = new LinkedList<Integer>(Arrays.asList(array));

        print(myqueue);
        print("Peeking first element: " + myqueue.peek());
        print("Poping first element (poll) : " + myqueue.poll());
        print(myqueue);
        print("Enqueueing");
        myqueue.add(888);
        print(myqueue);

    }



    private static void CustomPriorityQueueUsage(){
        print("~~~~ Custom Priority Queue Usage ~~~~");

        Comparator<Student> comparator = new StudentComparator();
        Queue<Student> students = new PriorityQueue<>(comparator);

        Student st1 = new Student(1, 15);
        Student st2 = new Student(2, 20);

        students.add(st1);
        students.add(st2);

        print(students.peek().id);
    }

    private  static void PriorityQueueUsage(){
        print("~~~~ Priority Queue Usage Using reverse Order~~~~");
        Queue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        pq.add(10);
        pq.add(20);
        print("Peeking, should return 20: " + pq.peek());
    }


    private static int HeighTree(TreeNode root){
        if(root == null) return 0;

        return Math.max(HeighTree(root.left), HeighTree(root.right)) + 1;
    }

    /**         10
          5           15
       3    8      13    20

     **/

    private static TreeNode createBalancedTree(){
        BinaryTree tree = new BinaryTree(10);

        TreeNode root = tree.root;

        tree.AddTreeNode(root,5,"left");
        tree.AddTreeNode(root.left,3,"left");
        tree.AddTreeNode(root.left,8,"right");

        tree.AddTreeNode(root,15,"right");
        tree.AddTreeNode(root.right,13,"left");
        tree.AddTreeNode(root.right,20,"right");

        return root;
    }
    /**             10
                5        null
            3      8
        1     4
     **/
    private static TreeNode createUnbalancedTree(){
        BinaryTree tree = new BinaryTree(10);

        TreeNode root = tree.root;

        tree.AddTreeNode(root,5,"left");
        tree.AddTreeNode(root.left,3,"left");
            tree.AddTreeNode(root.left.left, 1, "left");
            tree.AddTreeNode(root.left.left,4, "right");
        tree.AddTreeNode(root.left,8,"right");

        return root;
    }

    private static int isTreebalanced(TreeNode root){
        if(root == null) return 0;

        int left_height = isTreebalanced(root.left);

        if(left_height == -1) return -1;

        int right_height = isTreebalanced(root.right);

        if(right_height == -1) return -1;

        int diff = Math.abs(left_height - right_height);

        if(diff > 1) return -1;

        return Math.max(left_height,right_height) + 1;

    }

    // --> assuming that is not a binary search tree
    private static boolean searchTree(TreeNode root, int value){
        if(root == null) return false;

        if(root.data == value) return true;

        return (searchTree(root.left, value) || searchTree(root.right, value));
    }
    private static void BinaryTreeUsage(){
        print("~~~~ Binary Tree Usage ~~~~");

        TreeNode balanced_root = createBalancedTree();
        print("Printing Height of Tree: " + HeighTree(balanced_root));
        print("Is Balanced Tree balanced: " + isTreebalanced(balanced_root));

        TreeNode unbalanced_root = createUnbalancedTree();
        print("Is Unbalanced Tree balanced: " + isTreebalanced(unbalanced_root));

        print("Is the value 20 found in the balanced_tree (true): " + searchTree(balanced_root,20));
        print("Is the value -1 found in the balanced_tree (false): " + searchTree(balanced_root,-1));
        print("Is the value 4 found in the Unbalanced_tree (true): " + searchTree(unbalanced_root,4));
        print("Is the value 9 found in the Ubalanced_tree (false): " + searchTree(unbalanced_root,9));

    }

    /**
        Given a set of Chars, return all possible subsets that can be formes
          []   -> []
         [A]  -> [A]
         [A, B]  -> {{A}, {B}, {AB}}
        [A, B, C]-> {{A}, {B}, {AB},{C}, {AC}, {BC}, {ABC}}

        How can we generate P(1) from P2,
                * iterate thorugh P(1) and for each element of P(1), add the new integer or Char, and join the sets
     *
     FUNCTION PROPTOTYPE
            function (SET, CHAR)

                // when set is empty, just return
                subset = {}
                for( set : SET)
                    subset =  function(SET


     *
     */

//   private static ArrayList<ArrayList<Integer>> getListPermutations(ArrayList<Integer> list, int index){
//
//       ArrayList<ArrayList<Integer>> allSubLists;
//
//       if(list.size() == index){
//           ArrayList<Integer> emptyArray = new ArrayList<>();
//           allSubLists = new ArrayList<>();
//           allSubLists.add(emptyArray);
//           return  allSubLists;
//       }
//
//       allSubLists = getListPermutations(list, index); // --> this list will contain the result of previous calls
//                                                        // we need to continue appending to it.
//       // [ [w,e,r], [t,y,u], [j,f,s] ], now what we are going to do is iterate through each of these list
//       // and append the new character that we are going to fetch from the list.
//
//       // For every recursive call we only add 1 and only 1 arrayList to allSubLists
//
//       // you may ask, why do we need to append to a new arrayList before, well if we don't and just add to allSubLists
//       // directly we will get something like this.
//       for(ArrayList<Integer> prev_list : allSubLists){
//           Integer value_to_add = list.get(index);
//           prev_list.add(value_to_add)
//       }
//
//
//   }


    public static int  getOverlapLength(String str1, String str2){

        // assumes lenA is the smallest
        int lenA = str1.length();
        int lenB = str2.length();

        int overlap = -1;

        int shortest_len = lenA;
        if(lenA >lenB){
            shortest_len = lenB;
        }
        for(int i = 0; i < shortest_len; i++){
            if(lenA <= lenB){
                String subA = str1.substring(i, shortest_len); // get tail of A
                String subB = str2.substring(0, shortest_len -i); // get head of B

                if(subA.equals(subB)){
                    overlap = subA.length();
                    break;
                }
            }else{
                String subA = str1.substring(lenA-shortest_len+i, lenA); // get tail of A
                String subB = str2.substring(0, shortest_len -i); // get head of B

                if(subA.equals(subB)){
                    overlap = subA.length();
                    break;
                }
            }


        }


        return overlap; // if no overlap



    }

    /**
     * Question: Given two arrays, one containing the labels of nodes of a tree and sorted in preorder traversal and
     * another array containing the edges between the nodes ( to basically tell you it's sorted in preorder traversal)
     * find the longest path with nodes that have the same label.
     * @param array
     * @param parent_label
     * @param current_index
     * @param length
     * @return
     */
    public static int getLabel(List<Integer> array, int parent_label, int current_index, int length){
        if(current_index >= length){
            return 0;
        }

        if(array.get(current_index) != parent_label){
            return  0;
        }

        int left_child = getLabel(array, parent_label, 2*current_index+1, length);
        int right_child = getLabel(array, parent_label, 2*current_index+2, length);

        return left_child + right_child +1;
    }

    public static int findLargestPath(){

        List<Integer> array = new ArrayList<Integer>(Arrays.asList(1,1,1,2,2));

        int lenght = array.size();

        int loop_len = lenght/2;

        int longest_path = 0;

        for(int i = 0; i < loop_len; i++){
            if(i !=0){  // --> if you are a child whose value is the same as parent, don't bother to calculate
                        // path since it has previously been calculated by its parent through the recursive call
                if(i%2 != 0 && array.get((i-1)/2) == array.get(i)){
                    continue;
                }else  if (i%2 == 0 && array.get((i-2)/2) == array.get(i)){
                    continue;
                }
            }
            int max_path = getLabel(array,array.get(i),i,lenght);

            if(max_path > longest_path){
                longest_path = max_path;
            }

        }
        return  longest_path -1; // --> there are always num_nodes-1 edges
    }

    /**
     * END OF QUESTION
     */


    public static int getStates(String A, String B){
        int overlap = getOverlapLength(A,B);
        if(overlap == -1){
            return -1;    // no overlap, so doesn't matter how many times it repeats
        }

        if(A.equals(B)) return 1;

        if(overlap == B.length()){ // B is contained in A (edge case)
            return  1;  // double check this.
        }

        int total_state = 1; // at least it must show once


        int lenA = A.length();
        int lenB = B.length();

        int B_remaining = lenB - overlap;

        if(B_remaining%lenA == 0){
            total_state += B_remaining/lenA;
        }else{
            total_state += (B_remaining/lenA +1);
        }

        return total_state;


    }
    public static void main(String[] args) {


        print("Largest path is: " + findLargestPath());
//        print(getOverlapLength("abcd", "cda"));
//        print(getOverlapLength("ABCDEF", "BCDEFASFDSADF"));

       // print(getStates("ab", "abc"));





      //  BinaryMinHeap
     //   HashMapUsage();
     //   HashTableUsage();
        // --> QueueUsage();
        // --> PriorityQueueUsage();


       // BinaryTreeUsage();


        //System.out.println(Arrays.deepToString(myset.toArray()));
//        List<Node> list = new ArrayList<>();
//
//        list.add(new Node(4,null));
//        list.add(new Node(6, null));
//        list.add(new Node(2,null));
//        list.add(new Node(8,null));
//
//        System.out.println(list.size());
//        printArrayList(list);
//        System.out.println(list.get(0).data);
//        list.remove(0);
//        list.remove(0);
//        printArrayList(list);
//
//        System.out.println(list.size());
//        list.set(0, new Node(9,null));
//        printArrayList(list);

//        int array [] [] = {{5,6,7,8}, {6,7,8}, {7,8,9}};
//
//        //Arrays.toString(array);
////        for(int i = 0; i < array.length; i++){
////            System.out.println(array[i]);
////        }
//
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.deepToString(array));

        // Manipulating AR

        /*********  Manipulating Linked Lists
        Node fifth = new Node(5, null);
        Node fourth = new Node(4, fifth);
        Node third = new Node(3, fourth);
        Node second = new Node(2, third);
        Node first = new Node(1, second);

        Integer numNodes = countNodes(first);
        print("Number of nodes: " + numNodes.toString());
        printList(first);
        print("===Removing Node====");
        removeNthNode(first, 3);
        numNodes = countNodes(first);
        print("Number of nodes: " + numNodes.toString());
        printList(first);
        print("===Adding Node  7 ====");
        addNode(first, 7, 3);
        numNodes = countNodes(first);
        print("Number of nodes: " + numNodes.toString());
        printList(first);

        */

//        revertList(null, first);
//
//        printList(fifth);
       // print("=======");




        /**
         * Using LinkedList Library, learning about using built in functions like .get .set
         *                           how to use an iterator of a collection  list.iterator(), it.hasNext, it.next
         *                           always do the casting to the right type when you fetch the value   (String)
         */

//        List<Nod2> list2 = new LinkedList<Nod2>();
//
//
//        list2.add(new Nod2('a'));
//        list2.add(new Nod2('b'));
//        list2.add(new Nod2('c'));
//        list2.add(new Nod2('d'));
//
//        Iterator<Nod2> it = list2.iterator();

       // System.out.println(list2);

//        while(it.hasNext()){
//            Nod2 n = it.next();
//            if(n.data == 'b'){
//                System.out.println("REMOVING B");
//                it.remove();
//            }
//            System.out.println(n.data);
//        }
//
//        it = list2.iterator();
//        while(it.hasNext()){
//            Nod2 n = it.next();
//            System.out.println(n.data);
//        }
//        System.out.println("============");
//        list2.get(2).data = 'C';
//
//        list2.set(2, second.data);
//
//        it = list2.iterator(); //--> resetting iterator
//
//        while(it.hasNext()){
//            Nod2 n = it.next();
//            System.out.println(n.data);
//        }
//
//        System.out.println("============");
//        List<String> strings = new LinkedList<>();
//
//        strings.add("aa");
//        strings.add("bb");
//        strings.add("cc");
//        strings.set(1, "CC");
//        strings.remove(2);
//        System.out.println(strings.get(1).);



        //System.out.println(list2.get(2).data);


//        list.add(ten);
//        list.add(nine);
//        list.add(eight);
//        list.add(seven);
//        list.add(six);
//        System.out.println(list.toString());
//        printList(six);
//
//
//
//        printList(six);

    }
}
