public class LinkedLists {
    static Node head;


    class Node {
        int data;
        Node next, prev;
        Node(int d) {
            data = d;
            next = prev = null;
        }
    }


    void push(int new_data) {
        /* allocate node */
        Node new_node = new Node(new_data);
        /* since we are adding at the beginning,
         prev is always NULL */
        new_node.prev = null;
        /* link the old list off the new node */
        new_node.next = head;
        /* change prev of head node to new node */
        if (head != null) {
            head.prev = new_node;
        }
        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked list */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    void reverseFromMid(){
        Node cur = head;
        Node next = null;
        Node prev = head;
        int count = 0;
        while(cur != null){
          //  next = cur.next;
            count++;
            if(count%2 == 0){
                prev = prev.next;
            }
            cur = cur.next;
        }
        cur = prev;
        prev = prev.prev;
        prev.next = null;
        while (cur != null){
            next = cur.next;
            cur.next = head;
            cur.prev = null;
            head.prev = cur;
            head = cur;
            cur = next;
        }
    }
    void removeZeroSumLists(){
        Node Head = new Node(0);
        Head.next = head;
        Node prev = Head;
        Node cur = Head;

        while (cur != null) {
           int sum=0;
            while (head != null) {
                sum += head.data;
                if (sum == 0) {
                    cur.next = head.next;
                }
                head = head.next;
            }
            cur = cur.next;
            if(cur != null){
                head = cur.next;
            }
        }
            Head = Head.next;
            while (Head != null) {
                System.out.println(Head.data + " ");
                Head = Head.next;
            }

    }
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        /* Let us create a sorted linked list to test the functions
         Created linked list will be 10->8->4->2 */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);
//
        System.out.println("Original linked list ");
        list.printList(head);
//
//        list.reverse();
//        System.out.println("");
//        System.out.println("The reversed Linked List is ");
//        list.printList(head);
        list.reverseFromMid();
        System.out.println("Reversed From Mid Linked List is ");
        list.printList(head);
        //Remove all nodes sums to zero
        LinkedLists linkedLists = new LinkedLists();

        linkedLists.push(6);
        linkedLists.push(-6);
        linkedLists.push(5);
        linkedLists.push(-7);
        linkedLists.push(4);
        linkedLists.push(3);
        linkedLists.removeZeroSumLists();
    }

}
