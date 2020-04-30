import java.util.*;

public class LRUcache {
    private Deque<Integer> dq;
    private HashMap<Integer,Integer> map;
    private List<Integer> doubleList;
    private int cacheSize;
    LRUcache(int n){
        dq = new LinkedList<>();

        map = new HashMap<>();
        cacheSize = n;

}
    public void refer(int x){
        if(map.containsKey(x)){
            //remove the element from queue
            dq.remove(x);

        }
        else{
            if(dq.size() == cacheSize){
                int last = dq.removeLast();
                map.remove(last);
            }
            //put it in hashmap
            map.put(x,x);
        }
        //put element in the head
        dq.push(x);
    }
    public int get(int x){
        if(map.containsKey(x)){
            dq.remove(x);
            dq.push(x);
            return 1;
        }
        else return -1;
    }
    public void put(int x){
        if(map.containsKey(x)){
            dq.remove(x);
        }
        if(dq.size() == cacheSize ){
           int last =  dq.removeLast();
            map.remove(last);
        }
        dq.push(x);
        map.put(x,x);
    }
    public void display()
    {
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUcache ca = new LRUcache(4);
        ca.put(1);
        ca.put(2);
        ca.put(3);
        ca.display();
        ca.get(1);
        ca.display();
        ca.put(4);
        ca.display();
        ca.get(5);
        ca.display();
    }
}
