import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    public static void main(String[] args) {
        int[] array1 = {4,8,9,3,5,7};
        int[] array2 = {1,12,6,9,0,30};
        buildMaxHeap(array1);
        buildMaxHeap(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(mergeTwoMaxHeap(array1,array2)));
        //find continous median
        Heap heap = new Heap();
        heap.findContinousMedian(new int[]{5,15,1,3});
    }
    static void buildMaxHeap(int[] array){
        int length = array.length;
        //find the parent index for the last node
        int start = (length-1-1)/2;
        for(int i=start; i >= 0; i--){
            maxHeapify(array, i);
        }
    }
    static void maxHeapify(int[] array, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        //
        if(left < array.length && array[left] > array[largest]){
            largest = left;
        }
        if(right < array.length && array[right] > array[largest]){
            largest = right;
        }
        //swap
        if(largest != i){
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;
            maxHeapify(array, largest);
        }
    }
    static int[] mergeTwoMaxHeap(int[] heap1, int[] heap2){
        int length = heap1.length+heap2.length;
        int[] heap = new int[length];
       for(int i=0; i<heap1.length;i++){
            heap[i] = heap1[i];
        }
        for(int i=heap1.length, j = 0; i<heap.length && j<heap2.length;i++,j++){
            heap[i] = heap2[j];
        }
        buildMaxHeap(heap);
        return heap;
    }

    //Finding the continous median
    void findContinousMedian(int[] arr){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int a:arr){
            addNumber(a);
            System.out.println(findMedian());
        }
    }
    void addNumber(int n){
        minHeap.add(n);
        maxHeap.add(minHeap.poll());
        if(minHeap.size() < maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    double findMedian(){
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } else{
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
}
