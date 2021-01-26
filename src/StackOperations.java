import java.util.HashMap;
import java.util.Stack;

class StackOperations {

    public static void main(String[] args) throws Exception {
        MinStack m = new MinStack();
        m.push(3);
        m.push(1);
        m.push(5);
        System.out.println(m.min());
        m.pop();
        m.pop();
        m.push(2);
        System.out.println(m.min());
        System.out.println("Min number of Parentesis " + minAddToMakeValid("()))((") );


        ///
        System.out.println("Matching");
        System.out.println(matchParameter("{[]}"));
        System.out.println(matchParameter("{[}"));
        System.out.println(isValid("([)]"));
    }
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
     */
    public int evalRPN(String[] tokens) {

        if(tokens.length < 3) return Integer.parseInt(tokens[0]);
        Stack<String> stack = new Stack<>();

        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                Integer operand2 = Integer.parseInt(stack.pop());
                Integer operand1 = Integer.parseInt(stack.pop());
                switch(s){
                    case("+"): stack.push((new Integer(operand1 + operand2)).toString()); break;
                    case("-"): stack.push((new Integer(operand1 - operand2)).toString()); break;
                    case("*"): stack.push((new Integer(operand1 * operand2)).toString()); break;
                    case("/"): stack.push((new Integer(operand1 / operand2)).toString()); break;
                }
            } else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
/*
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
Input: "())"
Output: 1
Input: "()))(("
Output: 4
 */
    public static int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
Input: "([)]"
Output: false
Example 5:
Input: "{[]}"
Output: true

     */
    public static boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c =='{' || c == '['){
                stack.push(c);
            } else{
                if(stack.isEmpty()) return false;
                char match = stack.pop();
                if((c == ')' && match != '(') ||
                        (c == ']' && match !='[') ||
                        (c =='}' && match != '{') ) return false;


            }
        }
        return stack.isEmpty();

    }
    /*
 Stack, first in, last out.
 A stack can do push, pop, size function in constant time. All elements beneath the top elements are hidden
 Implement an enhanced stack, that can do push/pop/size/min, all in constant time.
 5
 1
 3

 */
   static class MinStack {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        java.util.Stack<Integer> enhanced = new java.util.Stack<Integer>();

        public void push(int n) {
            stack.push(n);
            if (enhanced.isEmpty()) {
                enhanced.push(n);
            } else {
                int value = enhanced.peek();
                if (value < n)
                    enhanced.push(value);
                else
                    enhanced.push(n);
            }
        }

        public int pop() throws Exception {
            if(!stack.isEmpty()) {
                int ret = stack.pop();
                enhanced.pop();
                return ret;
            } else throw new Exception("Empty Stack");
        }
       public int size() {
           return stack.size();
       }

       // return minimum value of all existing values in stack
       public int min() {
           return enhanced.peek();
       }
    }

    static boolean matchParameter(String str){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> match = new HashMap<>();
        match.put('}','{');
        match.put(')','(');
        match.put(']','[');
        for (int i =0; i <str.length(); i++){
            char c = str.charAt(i);
            if(!match.containsKey(c)) {
                stack.push(c);
            }
            else {
                if(!stack.empty()) {
                    char ch = stack.pop();
                    char open = match.get(c);
                    if(ch != open)
                        return false;
                }
                else return  false;
            }

        }
        return stack.isEmpty();
    }
}