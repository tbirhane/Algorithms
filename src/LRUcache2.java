import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LRUcache2 {
    private final Node head;
    private final Node tail;
    private final HashMap<Integer, Node>  cache;
    private final int capacity;
    private  int size;
    LRUcache2(int n){
        size = 0;
        capacity = n;
        head = new Node();
        tail = new Node();
        cache = new HashMap<>();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }
    class Node{
        Node prev;
        Node next;
        int key;
        int data;

    }
    void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    void remove(Node node){
        Node prv = node.prev;
        Node next = node.next;
        prv.next = next;
        next.prev = prv;
    }
    void moveToHead(Node node){
        remove(node);
        add(node);
    }
    void removeFromTail(){
        Node node = tail.prev;
        remove(node);
    }
    int get(int key){
        Node node = cache.get(key);
        if(node == null) return -1;
       moveToHead(node);
       return node.data;
    }
    void put(int key, int value){

        Node node = cache.get(key);
        if(node == null) {
            node = new Node();
            node.key = key;
            node.data = value;
            cache.put(key, node);
            add(node);
            size++;
            if(size > capacity){
                //remove from tail
                removeFromTail();
                size--;
            }
        }
        else {
            //node is already there
            node.data = value;
            moveToHead(node);
        }
    }
    void printNodes(){
        System.out.println();
        Node node = head.next;
        while(node.next != null){
            System.out.println(node.data + "  ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LRUcache2 lrUcache2 = new LRUcache2(5);
        lrUcache2.put(1,1);
        lrUcache2.put(2,2);
        lrUcache2.put(3,3);
        lrUcache2.put(4,4);
        lrUcache2.put(5,5);
        lrUcache2.printNodes();
        lrUcache2.put(3,3);
        lrUcache2.printNodes();
        System.out.println(lrUcache2.get(2));
        lrUcache2.printNodes();
    }
}
