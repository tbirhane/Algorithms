package Stack;

public class LinkedListStack implements Stack1 {

    Node header = null;
    int size = 0;
    public static void main(String[] args) {
        LinkedListStack stk = new LinkedListStack(); // create stack of size 4
        Object item;
        stk.push('A'); // push 3 items onto stack
        stk.push('B');
        stk.push('C');
        stk.push('D');

        System.out.println("size(): " + stk.size());
        item = stk.pop(); // delete item
        System.out.println(item + " is deleted");
        stk.push('D'); // add three more items to the stack
        stk.push('E');
        System.out.println(stk.pop() + " is deleted");
        stk.push('G'); // push one item
        item = stk.peek(); // get top item from the stack
        System.out.println(item + " is on top of stack");
        System.out.println("Size of the Stack : " + stk.size());
        LinkedListStack stk1 = new LinkedListStack();
        stk1.push("Java");
        stk1.push(20);
        stk1.push(30);

    }
    @Override
    public void push(Object ob) {
        //  5->3->2
        if(header == null) header = new Node(null, ob);
        else {
            Node node = new Node(header, ob);
            header = node;
        }
        size++;
    }

    @Override
    public Object pop() {
        if(header == null) return null;
        else  {
            Object val = header.val;
            header = header.next;
            size--;
            return val;
            }
    }

    @Override
    public Object peek() {
        if(header == null) return null;
        else return header.val;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public int size() {
        return size;
    }
    class Node{
        Object val;
        Node next;
        Node(){}
        Node(Node next, Object str){
            this.next= next;
            this.val=str;
        }
    }
}
