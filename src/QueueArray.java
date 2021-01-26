public class QueueArray {
    private int[] arr = new int[10];
    private int front = -1;
    private int rear =  0;
    public int peek() {
        // 10,11,   f=0, r=0 , r =1,r=2
        if(front == -1 || front>rear)
            return -1;
        return arr[front];
    }
    public void enqueue(int obj){
//implement
        if(front == -1) arr[++front] = obj;
        else{
            if(rear == arr.length)
                resize();
           arr[rear++] = obj;
        }
    }
    public int dequeue() {
        if(front == -1 )
        return -1;
        else{
            return arr[front++];
        }
//implement
    }
    public boolean isEmpty(){
//implement
        if(front == -1 || front > rear) return true;
        return false;
    }
    public int size(){
//implement
        return  rear - front +1;

    }
    private void resize(){
//implement
        int[] tmp = new int[2*arr.length];
        for(int i=0; i<arr.length; i++)
            tmp[i] = arr[i];
        arr=tmp;
    }

}
