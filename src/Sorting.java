import java.util.Arrays;

public class Sorting extends Thread{
    @Override
   public void run(){
    try{
        while(true) {
            Thread.sleep(5000);
            System.out.println("Hello");
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}
    public static void main(String[] args) {
        Sorting s = new Sorting();
        s.start();
//        Thread t1 = new Thread(s,"Thread : ");
//        t1.start();
        int[] arr = new int[]{2,12,5,7,9};
        //pmerge.sort(arr, 0, arr.length-1);
        //pmerge.heapSortMaxHeap(arr);
        s.heapSortMinHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int l, int m, int r)
    {// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        int[] L = new int [n1];
        int[] R = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        { if (L[i] <= R[j])
        { arr[k] = L[i];
            i++;
        }
        else
        { arr[k] = R[j];
            j++;
        }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        { arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        { arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int[] arr, int l, int r)
    {
        if (l < r)
        {// Find the middle point
            int m = (l+r)/2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void heapSortMax(int[] arr){
        int startIdx = (arr.length)/2 - 1;
        for(int i = startIdx; i >= 0; i--){
            heapifyMaxHeap(arr,arr.length, i);
        }
        //
        System.out.println(Arrays.toString(arr));
        for(int i = arr.length-1; i >=0; i--){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            heapifyMaxHeap(arr, i, 0);
        }
    }
    void heapifyMaxHeap(int[] arr, int n, int i){
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        int largest = i;

        if(leftChild < n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        //swap
        if(i != largest){
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapifyMaxHeap(arr, n, largest);
        }
    }
    void heapSortMinHeap(int[] arr){
        int startIndx = arr.length/2 -1;
        for(int i = startIndx; i >=0; i--){
            heapifyMinHeap(arr, i);
        }
    }
    void heapifyMinHeap(int[] arr, int i){
        int smallest  = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < arr.length && arr[left] < arr[smallest])
            smallest = left;
        if(right < arr.length && arr[right] < arr[smallest])
            smallest = right;
        if(i != smallest){
            int tmp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = tmp;

            heapifyMinHeap(arr, smallest);
        }
    }
}
