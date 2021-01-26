// Java program to find a triplet using Hashing
import java.util.*;

class ThreeSum {

    // returns true if there is triplet
    // with sum equal to 'sum' present
    // in A[]. Also, prints the triplet
    static boolean find3Numbers(int[] A, int arr_size, int sum)
    {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != A[j]) {
                    System.out.printf("Triplet is %d, %d, %d", A[i],
                            A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }
        // If we reach here, then no triplet was found
        return false;
    }
    static String increment(String s){

//    Queue<Integer> q = new Queue<>();
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int j = s.length()-1;
        char c = s.charAt(j);
        while(Character.isDigit(c)){
            int num = Character.getNumericValue(c);
            num = num+carry+1;
            carry = num/10;
            num = num%10;
            c = s.charAt(--j);
            builder.append((char)(num+'0'));
        }
        String str = s.substring(0,s.length() - builder.length());
        str = str + builder.reverse().toString();
        return str;
    }
    /* Driver code */

    public static void main(String[] args)
    {
        int[] A = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
        System.out.println();
        System.out.println(increment("strign09"));
    }
}

// This code has been contributed by 29AjayKumar
