package MathematicalAlgo;

public class MathematicalAlgo {
    public static void main(String[] args) {
        System.out.println("Fibonaci  :" +fibonaci(10));
        System.out.println("Fibonaci DP  :" +fibonaciDP(10));
        try {
            System.out.println("Factorial: "+ factorial(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static int fibonaci(int n){
        if(n == 0) return 0;
        if (n == 1) return 1;
        int number = 1;
        int f1 = 0, f2 = 1;
        while(number < n){
            int f = f1+f2;
            f1=f2;
            f2=f;
            number++;
        }
        return f2;
    }

    static int fibonaciDP(int n){
        if(n == 2 || n== 1) return 1;
        int[] table = new int[n+1];
        table[1] = 1;
        table[2] = 1;
        if(table[n] != 0) return table[n];
        table[n] =  fibonaciDP(n-1) + fibonaciDP(n-2);
         return table[n];
        }

     static int factorial(int x) throws Exception {
        if(x < 0)  throw new Exception("Wrong input");
        if(x == 0|| x==1) return 1;
        int fact = x;
        while (x>1){
            x--;
            fact *= x;
        }
        return fact;
     }
}
