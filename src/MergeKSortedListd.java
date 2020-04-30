import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedListd {
    // Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

// Example:

// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6
public static void main(String[] args) {
//
//    List<Node> list1 = Arrays.asList(new Node(2),
//            new Node(4), new Node(6),new Node(20),new Node(40));
    Node list1 = new Node(2);
    list1.next = new Node(4);
    list1.next.next = new Node(6);
    list1.next.next.next = new Node(20);
//    List<Node> list2 = Arrays.asList(new Node(1),
//            new Node(4), new Node(7),new Node(25),new Node(30));
    Node list2 = new Node(1);
    list2.next = new Node(4);
    list2.next.next = new Node(7);
    list2.next.next.next = new Node(27);
//
//    List<Node> list3 = Arrays.asList(new Node(0),
//            new Node(3), new Node(6),new Node(16),new Node(45));
    Node list3 = new Node(0);
    list3.next = new Node(3);
    list3.next.next = new Node(6);
    list3.next.next.next = new Node((45));
    Node[] list = {list1,list2,list3};
    Node result = mergeKSortedList(list);
    while ((result != null)){
        System.out.println(result);
        result = result.next;
    }
}
public  static Node mergeKSortedList(Node[] list){
    Node head = new Node(0);
    Node merged = head;
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    for(Node n:list){
        priorityQueue.add(n);
    }
    while (!priorityQueue.isEmpty()){
        Node tmp = priorityQueue.poll();
        if(tmp.next != null)
            priorityQueue.add(tmp.next);
        merged.next = tmp;
        merged = merged.next;
    }
    return head.next;
}

static class Node implements Comparable<Node>{
    int val;
    Node next;
    Node(int x){
        this.val = x;
    }

    @Override
    public int compareTo(Node node) {
        return this.val - node.val;
    }
    @Override
    public String toString(){
        return val + " ";
    }
}
}
