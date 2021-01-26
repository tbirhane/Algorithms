package Screening;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScreeningFlecxton {
    public static void main(String[] args) {
        //1
        System.out.println(summation(new int[]{1,6,8,5,9,4,7,2}));
        //2
        System.out.println(returnMap("abbbcddddeffabbbbbb"));
        //3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        printTreeLineByLine(root);
        //4
        System.out.println(getFrequencyOfArray(new int[]{1,1,7,5,2,4,7,2}));
    }

    /**
     * 1
     * Given an array of integers, return an array of integers which contains
     * [1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)…]
     *
     * Input size n
     * [1,6,8,5,9,4,7,2]
     * Output size m
     * [1,14,18,9]
     */
    static private List<Integer> summation(int[] arr){
        List<Integer> list = new ArrayList<>();
        int k = 1;
        for(int i =0; i<arr.length;){
            int sum = 0;
            for(int j = 0; j<k && i< arr.length; j++){
                sum += arr[i];
                i++;
            }
            k++;
            list.add(sum);
        }
        return list;
    }

    /**2
     * For a given string "abbbcddddeffabbbbbb" return the characters who are consecutively repeated like "bbb" and how many times it appears on the string.
     * For example, return a HashMap like,
     * b -> 2 Note: (bbb & bbbbbb)
     * d -> 1
     * f -> 1
     * Note: “a” appears two times but it is not consecutively repeated so it is not included. The same is true for “e”.
     * @param str
     * @return
     */
    static private Map<Character , Integer> returnMap(String str) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            if(c == str.charAt(i+1)){
                count.put(c, count.getOrDefault(c,0)+1);
                while(i< str.length() && str.charAt(i) == c){
                    i++;
                }
                i--;
            }
        }
        return count;
    }
    /**
     * Given an binary Tree Print the Line by line
     *
     *      1
     *     / \
     *    0   3
     *   /\
     *  4  5
     *
     * output ::
     * 1
     * 03
     * 45
     */
    static class TreeNode{
        TreeNode left , right;
        int val;
        TreeNode(int val){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void printTreeLineByLine(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return;
        queue.add(root);
        while(!queue.isEmpty()){

            int count = queue.size();
            while(count > 0){
                TreeNode n = queue.poll();
                count--;
                System.out.print(n.val);
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            System.out.println();
        }
    }
    /**
     * Given a list of int, returns the all unique ints with no. of occurances in the list
     *
     * a = {1,2,3,2,4,1,1}
     * O/p:
     * 1 - 3
     * 2 - 2
     * 3 - 1
     * 4 - 1
     */
    static Map<Integer, Long> getFrequencyOfArray(int[] a){
        return Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
