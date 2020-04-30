import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndCommonAlgo {

    public static void main(String[] args) {
	// write your code here
        //Functional inteface
        BiFunction<Integer,Integer,Integer> f = (z,y) -> z+y;
        System.out.println(f.apply(4,4));
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
        int[] a = sort0and1(new int[]{ 1,1,1,0,1,0,0});
        for (int i:a)
            System.out.println(i);
        //System.out.println(sort0and1(new int[]{ 1,1,1,0,1,0,0}));
        // print duplicate characters
        printDupChar("How are You hOrD mAn");
        //segregate even odd
        List<Integer> l = new LinkedList<>();
        l.add(20);
        l.add(13);
        l.add(10);
        l.add(15);
        System.out.println(segregateLinkedList(l));
        ArrayList<String> names = new ArrayList<>();
        names.add("Saron"); names.add("Saron"); names.add("Ama");names.add("Eron");
        System.out.println(sortRemoveDups(names));
        System.out.println(counter("ecliPse is not Eclipse ecliPse where It EClipse"));
        System.out.println(addSubArray(new int[]{1,2,3,4,5,6}));
        //
        System.out.println(" Rearranged: "+Arrays.toString(rearangePositiveAndNegative(new int[]{5,67,-2,5,7,-9,-45,20,3,78,-23})));
    }




    static int mathPow(int x, int n){
        if(n == 1)
            return x;
        else {
            return x*mathPow(x, n-1);
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
//        LinkedHashSet<Integer> a = new LinkedHashSet<>(Arrays.asList(arr));
//        return a.toArray();
        return Arrays.stream(arr).distinct().collect(Collectors.toList()).toArray();
        //other way

    }
    static Object[] removeDupsJava8(Integer[] arr){

        List<Integer> ints = new ArrayList<>();
        Arrays.stream(arr).distinct().forEach(i ->ints.add(i));
        return ints.toArray();
    }
    static Student maxObj(List<Student> students){
//        return Collections.max(students, Comparator.comparing(s -> s.getAge()));
//      2 way
        List<Student> students1 = students.stream().sorted((s1,s2) -> s2.getAge() -s1.getAge()).limit(1).collect(Collectors.toList());
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
            s.add(c);
        }
        for(char c:s){
            builder.append(c);
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
        HashMap<Character,Character> dups = new HashMap<>();
        for (char c:chars){
            if(m.containsKey(c)){
               dups.put(c,c);
            }
            else m.put(c,c);
        }
        for(char c:dups.keySet()){
            System.out.println(c);
        }
    }
    static List<Integer> segregateLinkedList(List<Integer> list){
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        for(int a: list) {
            if (a % 2 == 0) {
                even.add(a);
            }else  odd.add(a);
        }
        //System.out.println(even);
        for (int a:odd){
            even.add(a);
        }
        return even;

        }
        static ArrayList<String> sortRemoveDups(List<String> students){
        HashSet<String> st = new HashSet<>(students);
        ArrayList<String> sorted = new ArrayList<>();
        for (String s:st){
            sorted.add(s);
        }
         Collections.sort(sorted);
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

static int[] rearangePositiveAndNegative(int[] arr){

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
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
 */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        for(int a:nums2){
            map.put(a, k++);
        }
        for(int i=0; i<nums1.length; i++){
            boolean flag = false;
            for(int j = map.get(nums1[i]) + 1; j<nums2.length; j++){
                if(nums1[i] < nums2[j]){
                    nextGreater[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nextGreater[i] = -1;
            }
        }
        return nextGreater;
    }
}
