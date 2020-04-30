import java.util.*;

public class TopKFrequentElements {
    //Given an array of integers, write a method to return the k most frequent elements.
    public static void main(String[] args) {
        int[] array ={1,5,89,3,5,3,4,3,1,6,7,5};

        System.out.println("Using heap: "+topKFrequentElements(array, 3));
        // will not work if two elements have same max count. also if 0 itself is part of the element it will not work.
        System.out.println("Using Bucketsort: "+topKfrequentElementsBucketSort(array, 3));
    }
    //using heap
    //Time complexity: O(NlogK)
    static List<Integer> topKFrequentElements(int[] a, int k){
        Map<Integer, Integer> map = new HashMap<>();
        //Count each element in a map
        for(int e:a){
            map.put(e, map.getOrDefault(e,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparing(e ->e.getValue()));

        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            priorityQueue.add(e);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            list.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }


    static List<Integer> topKfrequentElementsBucketSort(int[] a, int k){

        Map<Integer, Integer> map = new HashMap<>();
        //Count each element in a map
        for(int e:a){
            map.put(e, map.getOrDefault(e,0)+1);
        }
        //Find the maximum count for the top elment
        int max = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(max < e.getValue()) max=e.getValue();
        }
        int[] index = new int[max+1];
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            index[e.getValue()] = e.getKey();
        }
        List<Integer> list = new ArrayList<>();
        for(int i = max; i>=0 && k>0; i--){
            if(index[i] > 0) list.add(index[i]);
            k--;
        }
        return list;
    }

}
