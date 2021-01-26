package Screening;

import java.util.*;

public class FlextonEBayScreening {
    public static void main(String[] args) {
// return group of anagrams
        List<String> words=new ArrayList<String>();
        words.add("Rat");
        words.add("Car");
        words.add("Below");
        words.add("Tast");
        words.add("Cried");
        words.add("Study");
        words.add("Thing");
        words.add("Chin");
        words.add("Grab");
        words.add("Act");
        words.add("Robed");
        words.add("Vase");
        words.add("Glean");
        words.add("Desserts");
        words.add("Tar");
        words.add("Arc");
        words.add("Elbow");
        words.add("State");
        words.add("Cider");
        words.add("Dusty");
        words.add("Night");
        words.add("Inch");
        words.add("Brag");
        words.add("Cat");
        words.add("Bored");
        words.add("Save");
        words.add("Angel");
        words.add("Streseed");
        System.out.println(anagrams(words));

// Required to sort the map:
// Question: Sorted on the basis of values descending order (Z-->A)
// [109=Rebeca, 19=Rahim, 18=Mohan, 10=Krishna, 101=Hemendra, 111=David, 11=Christine, 103=Anish, 99=Andrew]
        Map< Integer, String> map=new HashMap<Integer, String>();
        map.put(101, "Hemendra");
        map.put(99, "Andrew");
        map.put(103, "Anish");
        map.put(18, "Mohan");
        map.put(11, "Christine");
        map.put(109, "Rebeca");
        map.put(111, "David");
        map.put(19, "Rahim");
        map.put(10, "Krishna");
        System.out.println(sortValuesDesc(map));

        System.out.println("k most frequent integers:"+ kMostFrequent(new int[]{2,2,4,5,5,8,9,9,9}, 3));
    }
    /*
    * Question: Given a non-empty array of integers, return the k most frequent elements.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 Ã¢â€°Â¤ k Ã¢â€°Â¤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
    //time: nlogk
    static List<Integer> kMostFrequent(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:a){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }

    static List<Map.Entry<Integer, String>> sortValuesDesc(Map<Integer, String> map){
         PriorityQueue<Map.Entry<Integer, String>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            pq.add(entry);
        }
        List<Map.Entry<Integer, String>> ans = new LinkedList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
         Collections.reverse(ans);
        return ans;
    }

    //
    static List<List<String>> anagrams(List<String> str){
        if(str == null) return null;

        Map<String, List<String>> map = new HashMap<>();
        for(String s: str){
            s = s.toLowerCase();
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            List<String> value;
            if(!map.containsKey(key)) {
                value = new ArrayList<>();
                value.add(s);
                map.put(key, value);
            } else{
                value = map.get(key);
                value.add(s);
            map.put(key, value);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

}
