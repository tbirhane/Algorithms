package Arrays;

import java.security.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndCommonAlgo {

    public static void main(String[] args) {

	// write your code here
        //Functional inteface

        Integer x = 8+5;
        x.toString();
        //Power
        System.out.println(mathPow(2,3));

        //duplicates
        System.out.println(duplicates(new int[]{1,2,5,6,2,4,5}));
        //remove dups
        System.out.println("Remove duplicates");
        System.out.println(Arrays.asList(removeDups(new Integer[]{1,2,5,6,2,4,5})));
        //Max object
        List<Student> students = Arrays.asList(new Student("A", 20),new Student("B", 30));
        System.out.println(maxObj(students).getName());
        //second largest
        System.out.println(secondLargest(new int[]{20,10,100,19,70,100}));
        //remove duplicate characters
        System.out.println(removeDupChar("aaabbccc"));
        System.out.println(removeDupCharJava8("aaabbccc"));
        System.out.println();
        System.out.println(Arrays.toString(sort0and1(new int[]{ 1,1,1,0,1,0,0})));
        // print duplicate characters
        printDupChar("How are You hOrD mAn");
        //segregate even odd
        List<Integer> l = new LinkedList<>();
        l.add(20);
        l.add(13);
        l.add(10);
        l.add(15);
        System.out.println("Segregate even and odd: "+segregateLinkedList(l));
        ArrayList<String> names = new ArrayList<>();
        names.add("Saron"); names.add("Saron"); names.add("Ama");names.add("Eron");
        System.out.println(sortRemoveDups(names));
        System.out.println(counter("ecliPse is not Eclipse ecliPse where It EClipse"));
        System.out.println(addSubArray(new int[]{1,2,3,4,5,6}));
        //
        System.out.println(" Rearranged: "+Arrays.toString(rearangePositiveAndNegative(new int[]{5,67,-2,5,7,-9,-45,20,3,78,-23})));
        System.out.println("Hamming distance: " + hammingDistance(1, 4));
        //
//        System.out.println("Time1: "+ Instant.now());
//        for(int k=3; k<=50; k++)
//            System.out.println("can win Nim: " + canWinNim( k));
//        System.out.println("Time2: "+Instant.now());
//        for(int k=3; k<=50; k++)
//            System.out.println("can win Nim: " + canWinNimDP( k));
//        System.out.println("Time2: "+Instant.now());
//        for(int k=3; k<=50; k++)
//            System.out.println("can win Nim: " + canWinNimNaive( k));
//        System.out.println("Time2: "+Instant.now());
        int[] nums1 = {4,1,2}; int[]nums2 = {1,3,4,2};
        System.out.println("next greater number: "+Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

/*
You are playing the following Nim Game with your friend:
There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
The one who removes the last stone will be the winner.
You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game.
Write a function to determine whether you can win the game given the number of stones in the heap.
Example:
Input: 4
Output: false
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be
             removed by your friend.
 */
//Using Dynamic programming
public static boolean canWinNim(int n) {
    return (n%4 != 0);
}
public static boolean canWinNimDP(int n) {
    boolean[] table = new boolean[n+1];
    for(int i=0; i<=3; i++)
        table[i] = true;
    for(int i=4; i<=n; i++){
        table[i] = !table[i-1] || !table[i-2] || !table[i-3];
    }
    return table[n];
}

public static boolean canWinNimNaive(int n) {
    if(n <= 3 ) return true;
    if(n == 4) return false;
    return !canWinNimNaive(n-1) || !canWinNimNaive(n-2) || !canWinNimNaive(n-3);
}
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

 */
public static int hammingDistance(int x, int y) {

    List<String> bx = new ArrayList<>();
    List<String> by = new ArrayList<>();
    int count =0;
    while(x > 0){
        bx.add(String.valueOf(x%2));
        x = x/2;
    }
    while(y > 0){
        by.add(String.valueOf(y%2));
        y = y/2;
    }
   // Collections.reverse(bx);
   // Collections.reverse(by);
    System.out.println();
    Iterator<String> xit = bx.iterator();
    Iterator<String> yit = by.iterator();
    while(xit.hasNext()&&yit.hasNext()){
        if(!xit.next().equals(yit.next()))
            count++;
    }
    if(xit.hasNext()){
        while(xit.hasNext()){
            String s = xit.next();
            if("1".equals(s)) {
                count++;
            }
        }
    }
    if(yit.hasNext()){
        while(yit.hasNext()){
        String s =  yit.next();
        if("1".equals(s)){
            count++;
        }
        }
    }
    return count;
}
    static int mathPow(int x, int n){
    if(n == 0) return 1;
        if(n == 1)
            return x;
        else {
            int tmp = mathPow(x, n/2);
            if(n>0){
                if(n%2 ==0) return tmp*tmp;
                else return x*tmp*tmp;
            } else
                 return (tmp*tmp)/x;
        }
    }


    static HashMap<Integer, Integer> duplicates(int[] arr){
        HashMap<Integer, Integer> m = new HashMap<>();
        HashMap<Integer, Integer> dup = new HashMap<>();
        for(int a:arr){
            if(m.containsKey(a)){
                dup.put(a, a);
            }
            else m.put(a,a);
        }
        return dup;
    }

    //remove duplicates
    static Object[] removeDups(Integer[] arr){
        LinkedHashSet<Integer> a = new LinkedHashSet<>(Arrays.asList(arr));
        return a.toArray();
       // return Arrays.stream(arr).distinct().collect(Collectors.toList()).toArray();
        //other way

    }
    static Student maxObj(List<Student> students){
//        return Collections.max(students, Comparator.comparing(s -> s.getAge()));
//      2 way
        List<Student> students1 = students.stream().sorted((s1, s2) -> s2.getAge() -s1.getAge()).limit(1).collect(Collectors.toList());
        return students1.get(0);
    }
    static int secondLargest(int[] a){
        int max = a[0];
        int max2 = a[0];
        for(int i=0; i<a.length;i++){
            if(max < a[i]){
                max2 = max;
                max = a[i];
            }
            else if(max2 < a[i] && a[i] != max){
                max2 = a[i];
            }
        }
        return max2;
    }

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] indices = new int[2];
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(!m.containsKey(nums[i]))
                m.put(nums[i], i);
        }
        for(int i = 0; i<nums.length;i++){
            if(m.containsKey(target-nums[i]) && i !=m.get(target-nums[i])){
                indices[count++] = i;
                indices[count] = m.get(target-nums[i]);
                return indices;
            }
        }
        return new int[]{};
    }

    static String removeDupChar(String str){
        char[] charArray = str.toCharArray();
        LinkedHashSet<Character> s = new LinkedHashSet<>();
        StringBuilder builder = new StringBuilder();
        for(char c:charArray){
            if(!s.contains(c)) {
                s.add(c);
                builder.append(c);
            }
        }
    return builder.toString();
    }
    static String removeDupCharJava8(String str){
        StringBuilder builder = new StringBuilder();
         str.chars().distinct().forEach(c -> builder.append((char) c));
         return builder.toString();
    }
    static int[] sort0and1(int[] arr){
        int a = 0;
        int b = arr.length -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                int tmp = arr[i];
                arr[i] = arr[a];
                arr[a] = tmp;
                a++;
            }
        }
        return arr;
}
    static void printDupChar(String str){
        HashMap<Character,Character> m =  new HashMap<>();
        String s = str.toUpperCase();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if(m.containsKey(c)){
                System.out.println(c);
            }
            else m.put(c,c);
        }
    }
    //segregate even and odd numbers of a LinkedList
    static List<Integer> segregateLinkedList(List<Integer> list){
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        for(int a: list) {
            if (a % 2 == 0) {
                even.add(a);
            }else  odd.add(a);
        }
        //System.out.println(even);
        even.addAll(odd);
        return even;

        }
        static ArrayList<String> sortRemoveDups(List<String> students){
        HashSet<String> st = new HashSet<>(students);
        ArrayList<String> sorted = new ArrayList<>();
        for (String s:st){
            sorted.add(s);
        }
         Collections.sort(sorted, Comparator.reverseOrder());
            return sorted;
        }
     static Map<String,Long> counter(String str){
        return Stream.of(str.split(" ")).filter(s -> s.toLowerCase().equals("eclipse"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
     }
     static Object[] addSubArray(int [] a){
        List<Integer> ints = new ArrayList<>();
        for (int i=0, k =1; i<a.length; k++){
            int subSum = 0;
            for(int j = 0;j<k && i < a.length; j++,i++){
                subSum += a[i];
            }
            ints.add(subSum);
        }
        return ints.toArray();
     }

private static List<Integer> sum(int[] arr){
    List<Integer> ints = new ArrayList<Integer>();
    for(int i=0, k =1; i< arr.length;k++){
        int subSum = 0;
        for(int j=0; j<k && i<arr.length; i++,j++){
            subSum += arr[i];
        }
        ints.add(subSum);
    }
    return ints;
}

static int[] rearangePositiveAndNegative(int[] arr) {
        //partition them
    int i=-1;
    for(int j=0; j<arr.length;j++){
        if(arr[j] < 0){
            i++;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
    int pos = i+1;
    int neg = 0;
    while(pos < arr.length && neg < pos && arr[neg] < 0){
        int tmp = arr[pos];
        arr[pos] = arr[neg];
        arr[neg] = tmp;
        neg += 2;
        pos++;
    }
    return arr;
    }
/*
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist,
output -1 for this number.
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
 */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length-1; i++){
            if(nums2[i] < nums2[i+1])
                map.put(nums2[i], nums2[i+1]);
            else map.put(nums2[i], -1);
        }
        map.put(nums2[nums2.length-1], -1);
        for(int i=0; i<nums1.length; i++){
            nextGreater[i] = map.get(nums1[i]);
        }
        return nextGreater;
    }
}


