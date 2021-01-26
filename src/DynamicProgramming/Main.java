package DynamicProgramming;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fibonaci: "+ fibonaciDP(4));
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

}
