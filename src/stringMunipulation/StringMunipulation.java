package stringMunipulation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringMunipulation {
    int x;
    public static void main(String[] args) {
        StringMunipulation munipulation = new StringMunipulation();
        System.out.println(munipulation.removeDuplicate("abcdddafff"));
        System.out.println("x = " + munipulation.x);
        int y=0;
        System.out.println("y = "+y);
        int[] a = new int[5];
        for(int b: a)
        System.out.println(b);
        System.out.println(munipulation.increamentLastChar("string099"));
//
        String str = "sams Sams is not The big sAms";
        StringBuilder builder = new StringBuilder();
        String[] st = str.split(" ");
//        Arrays.asList(str.split(" ")).stream()
        Arrays.stream(st)
                .map(s -> s.toLowerCase())
                .forEach(s -> {if(s.equals("sams")) builder.append("Walmart ");
                else builder.append(s+" ");});

//        str = Arrays.asList(st).stream().collect(Collectors.joining(" "));
//        System.out.println(str);
        System.out.println("Replace all Sams (case insensitive) to Walmart: "+builder.toString());
        System.out.println(munipulation.findPairs("I am this solving word count problem i this word i yes", 5));
        munipulation.wordFrequency("Hello world Hello Sam");
        //reverse string
        System.out.println(munipulation.reverseString("abcd"));
        //Longest plaindrome
        System.out.println("Longest Plain using Iterative: "+munipulation.logestPlaindrome("babad"));
        System.out.println("Longest Plain using DP: "+munipulation.longestPlaindromeDynamicProg("babad"));

        //reverse
        System.out.println(reverse("Hello Word,"));

        /**
         * Given a random alpha-numeric string with no special characters,
         * reformat the string without adding or removing any characters so
         * that no alphabet characters are adjacent to any other alphabet characters
         * and no numeric characters are adjacent to any other numeric characters, if possible,
         * and return the modified string. If it is not possible to reformat the string in that way,
         * then group all the alphabet characters at the beginning of the string and all numeric characters at the end of the string.
         * In either case keep all alphabet characters in the same order relative to each other before and
         * after the formatting and also keep all numeric characters in the same order releative to each other before and after the formatting.
         *
         *   // Example input1: "aabb12cc345"
         *     // Example output1: "a1a2b3b4c5c"
         *     // Example input2: "a1aa"
         *     // Example output2: "aaa1"
         */
        System.out.println("hello");
        System.out.println(reformatString2("aabb12cc345"));
        System.out.println(reformatString2("a1aa"));
        System.out.println(reformatString2("aabb12ccd345789"));

        System.out.println(reformatString("aabb12cc345"));
        System.out.println(reformatString("a1aa"));
        System.out.println(reformatString("aabb12ccd345789"));
        /**
         * Context switching
         * difference between createStatement and preparedStatement
         * what is jdbc
         * what is monitor in multithreading
         * Facade design pttatern and sigleton
         * kafka companents: zookepper, brocker, offset, consumer, producer
         * Hibernate
         * How form data transfered to backend?
         */
        System.out.println(getReverseMaintainSpace("I work in eBay"));
        int[][] arr = new int[2][3];
        System.out.println(arr.length);
    }
    void wordFrequency(String str){
        Map<String, Long> freq = Stream.of(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        OR
//        Map<String, Long> freq = Arrays.stream(str.split(" "))
//                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);

        //  Given a string return true if it contains all the alphabets from a-z
        String x =  "The quick brown fox jumps over the lazy dog";
        System.out.println(checkAlphabet(x));
        String all = "The quick brown fox jumps over the lazy do";
        System.out.println(checkAlphabet(all));

    }
    List<List<String>> findPairs(String str, long k){
        Map<String, Long> strCount = Arrays.stream(str.split(" ")).map(w -> w.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<List<String>> listPairs = new ArrayList<List<String>>();
        System.out.println("map: " + strCount);
        for(String k1 : strCount.keySet()){
//            List<String> pairs = new ArrayList<>();
            Set<String> keys = strCount.keySet();
            for(String k2 : strCount.keySet()){
                if(k1.equals(k2)) continue;
                boolean flag = false;
                List<String> pairs = new ArrayList<>();
               // System.out.println("get(k1) + get(k2) : " + strCount.get(k1) +" " + strCount.get(k2));
                if((strCount.get(k1) + strCount.get(k2))== k){
                   // System.out.println("("+ k1 + "," + k2 + ")");
                    pairs.add(k1);
                    pairs.add(k2);

                }
//                if(flag){
//                    listPairs.add(pairs);
//                }
            }
        }
        return listPairs;
    }
    String removeDuplicate(String str){
        HashSet<Character> ch = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<str.length();i++){
            if(!ch.contains(str.charAt(i))) {
                builder.append(str.charAt(i));
                ch.add(str.charAt(i));
            }
        }
        return builder.toString();
    }
    String increamentLastChar(String str){
       int i = str.length()-1;
       int carry  = 0;
       StringBuilder builder = new StringBuilder();
       if(Character.isDigit(str.charAt(i))){
           int v =  Character.getNumericValue(str.charAt(i)) + 1;
           carry = v/10;
           builder.append(v%10);
           i--;
       }
        while(Character.isDigit(str.charAt(i)) && carry > 0){
           int v =  Character.getNumericValue(str.charAt(i)) + carry;
           carry = v/10;
           builder.append(v%10);
           i--;
        }
        String s = str.substring(0, i+1);
        builder.reverse();
        return s + builder.toString();
    }
    String reverseString(String str){
        if(str == null || str.length() < 2)
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    //Find the logest palindrome substring iterative solution
    String logestPlaindrome(String str){
        if(str == null || str.length() < 1) return str;
        int start = 0, end = 0;
        for(int i=0; i<str.length(); i++) {
            int len = Math.max(expand(str, i, i), expand(str, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end+1);
    }
    int expand(String str, int i, int j){
        while(i >=0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    //Longest Plaindrome dynamic programming
    public String longestPlaindromeDynamicProg(String s) {
        if(s == null || s.length()<1) return s;
        boolean table[][] = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            table[i][i] = true;
        }
        int start=0, maxLen=1;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                start=i;
                maxLen=2;
            }
        }
        //
        for(int k=3; k<=s.length(); k++){

            for(int i=0; i<s.length()-k+1; i++){
                int j=i+k-1;
                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    table[i][j] = true;
                    if(k>maxLen){
                        start = i;
                        maxLen= k;
                    }
                }
            }
        }

        return s.substring(start, start+maxLen);
    }
// search for string pattern in string
    static List<Integer> getIndexPatternInString(String str, String pat){
        if(pat == null) return null;
        List<Integer> indexs = new ArrayList<>();
        if(str == null) return null;
        else{
            for(int i=0; i < str.length() - pat.length();i++){
                if(pat.equals(str.substring(i, i+pat.length()))){
                    indexs.add(i);
                }
            }
        }
        return indexs;
    }

    static boolean checkAlphabet(String s){
        boolean check[] = new boolean[26];
        for (int i = 0; i<check.length;i++)
            check[i] = false;
        for(int i = 0; i < s.length(); i++){
            char  ch = s.charAt(i);
            if( ch >= 'a' && ch <= 'z'){
                int index = ch - 'a';
                check[ch - 'a'] = true;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                check[ch - 'A'] = true;
            }
        }
        for (int i=0; i < check.length; i++){
            if(!check[i])
                return false;
        }
        return true;

    }
    static String reverse(String str){
        StringBuilder builder = new StringBuilder();
        //  builder.append(str);
        String[] s = str.split(" ");
        //   builder.append(s);
        for (int i = s.length - 1; i >= 0; i--){
            if(i != s.length - 1)
                builder.append(" ");
            builder.append(s[i]);

        }
        return builder.toString();
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    static String reformatString2(String s){
        if(s == null || s.length() < 2)
            return  s;
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for(int i=0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                builder2.append(c);
            }
            else builder1.append(c);
        }
        if(Math.abs(builder1.length() - builder2.length()) > 1) {
            return builder1.append(builder2.toString()).toString();
        }else {
            StringBuilder builder = new StringBuilder();
            boolean letter = false;
            if(builder1.length() > builder2.length()){
                letter = true;
            }
            int i = 0, j = 0;
            while (j < builder2.toString().length() && i < builder1.toString().length()) {
                if(letter) {
                    builder.append(builder1.toString().charAt(i));
                    i++;
                }
                else {
                    builder.append(builder2.toString().charAt(j));
                    j++;
                }
                letter = !letter;
            }
            if(i < builder1.length()) builder.append(builder1.toString().substring(i));
            if(j < builder2.length()) builder.append(builder2.toString().substring(j));
            return builder.toString();
        }
    }
    static String getReverseMaintainSpace(String str){
        if(str == null) return null;
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for(int i=str.length() - 1,  j = 0; j < str.length() && i>=0; j++, i--){
            if(str.charAt(i) == ' '){
                i--;
            }if(chars[j] == ' '){
                j++;
            }
            chars[j] = str.charAt(i);
        }
        return  builder.append(chars).toString();
    }
    private static String reformatString(String str) {
        // your solution here
        if(str == null || str.length() < 2) return str;
        int digts = 0, letters = 0;
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))) digts++;
            else letters++;
        }
        char[] charArray = new char[str.length()];
        //if it is not possible put all alphabets  first and then numerics
        if(Math.abs(digts - letters) > 1){
            int letterIndex =  0;
            int numIndxex = letters;
            for(int i = 0; i<charArray.length; i++){
                if(Character.isDigit(str.charAt(i))){
                    charArray[numIndxex++] = str.charAt(i);
                } else {
                    charArray[letterIndex++] = str.charAt(i);
                }
            }
        } else{
            //if it is possible
            int digitPointer = 0;
            int letterPointer = 0;
            boolean isLetter = false;
            if(letters >= digts){ isLetter = true; }
            for(int i=0; i<str.length(); i++){
                while(digitPointer < str.length() && !Character.isDigit(str.charAt(digitPointer))){ digitPointer++; }
                while(letterPointer < str.length() && !Character.isLetter(str.charAt(letterPointer))){ letterPointer++;}
                charArray[i] = isLetter? str.charAt(letterPointer++):str.charAt(digitPointer++);
                isLetter = !isLetter;
            }
        }
        return (new StringBuilder()).append(charArray).toString();
    }
}
