
/*
* class Solution {
public:
    string customSortString(string S, string T) {
        int s[26] = { 0 };
        int t[26] = { 0 };
        for (const auto n: S) {
            s[n - 'a'] ++;
        }
        for (const auto n: T) {
            t[n - 'a'] ++;
        }
        string r = "";
        for (int i = 0; i < S.size(); ++ i) {
            for (int k = 0; k < t[S[i] - 'a']; ++ k) {
                r += S[i];
            }
        }
        for (int i = 0; i < T.size(); ++ i) {
            if (s[T[i] - 'a'] == 0) {
                r += T[i];
            }
        }
        return r;
    }
};
*
* class Solution {
public:
    string customSortString(string S, string T) {
        int t[26] = { 0 };
        for (const auto n: T) {
            t[n - 'a'] ++;
        }
        string r = "";
        for (int i = 0; i < S.size(); ++ i) {
            for (int k = 0; k < t[S[i] - 'a']; ++ k) {
                r += S[i];
            }
            t[S[i] - 'a'] = 0; // mark those used
        }
        for (char c = 'a'; c <= 'z'; ++ c) {
            for (int k = 0; k < t[c - 'a']; ++ k) {
                r += c;
            }
        }
        return r;
    }
};
* */
public class CustomStringSort {
    public static void main(String[] args) {
        System.out.println(customSort("akjbkjlclk","acb"));
        System.out.println(customSort2("akjbkjlclk","acb"));
    }
    static String customSort(String str, String pat){
        int[] st = new int[26];
        int[] pt = new int[26];
        /**
         * count the number of occurence for each character
         */
        for(int i=0; i<str.length();i++){
            st[str.charAt(i) - 'a']++;
        }
        /**
         * check if a character is present in the pattern string and increment the value by one to the index of the character
         */

        for(int i=0; i<pat.length();i++){
            pt[pat.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        /**
         * Traverse through the pattern string left to right and
         * for the number times the character appears in the string append to builder
         */
        for(int i = 0; i<pat.length(); i++){
            for(int j =0; j < st[pat.charAt(i) - 'a']; j++)
                builder.append(pat.charAt(i));
        }
        /**
         * For all the characters in the string if it is not in the pattern append to builder
         *
         */

        for(int i=0; i<str.length();i++){
            if(pt[str.charAt(i) - 'a'] == 0)
                builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    static String customSort2(String str, String pattern){
        int[] count = new int[26];
        for(int i =0; i < str.length(); i++){
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < pattern.length(); i++){
            for(int j = 0; j < count[pattern.charAt(i) - 'a']; j++){
                builder.append(pattern.charAt(i));
            }
            count[pattern.charAt(i) -'a'] = 0;
        }
        for(char c = 'a'; c<='z'; c++ ){
            for(int j = 0; j< count[c - 'a']; j++){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
