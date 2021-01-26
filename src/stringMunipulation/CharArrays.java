package stringMunipulation;

public class CharArrays {
    public static void main(String[] args) {
        System.out.println(reverseStringMaintainingOrderOfWords("Lets go work"));
    }
    /*
    Given a string reverse each work in the string maintaining the order of words in the string
     */
    public static String reverseStringMaintainingOrderOfWords(String str) {
       if(str == null || str.length() < 2) return str;
       char [] strArray = str.toCharArray();
       int k;
       for(int i=0; i<str.length()-1; i++){
           int j = i;
           while(j < str.length() && strArray[j] != ' ') {
               j++;
           }
           if(j <= str.length()) {
               swap(strArray, i, j - 1);
               i = j+1;
           }
       }
       return (new StringBuilder()).append(strArray).toString();
    }
    //what is this -> tahw si siht
    static void swap(char[] charA, int i, int j) {
        while(i < j && j<charA.length){
            char tmp = charA[i];
            charA[i] = charA[j];
            charA[j] = tmp;
            i++;
            j--;
        }
    }
}
