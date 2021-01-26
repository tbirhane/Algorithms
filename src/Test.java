import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        int[] arr = {34,7,8,9,3};
        Arrays.stream(arr).filter(a -> a>5).forEach(a -> System.out.println(a));
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
        System.out.println(Arrays.stream(arr).reduce(0, (x,y) -> x+y));
        int[] a = bestDaySellBuy(new int[]{7,1,5,3,6,4});
        for(int aa : a)
         System.out.println(aa);
        maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("Large Num :"+formLargestNum(new int[]{19,7,0,4}));
    }
    static String formLargestNum(int[]a){
        List<Integer> ints = new ArrayList<>();
        for(int b:a){
            while(b>0){
                ints.add(b%10);
                b = b/10;
            }
        }
        Collections.sort(ints);
        StringBuilder builder = new StringBuilder();
        for(int i:ints){
            builder.append(i);
        }
        return builder.reverse().toString();
    }
    static int[] bestDaySellBuy(int[] a){
        int [] days = new int[2];

        int maxProfit= 0;
        for(int i =0;i<a.length;i++){
            for(int j=i+1; j<a.length;j++){
                if(a[j] - a[i] > maxProfit) {
                    maxProfit = a[j] - a[i];
                    days[0] = i;
                    days[1] = j;
                }
            }
        }
        System.out.println("max profit: "+maxProfit);
        return days;
    }
    //Time: O(n)
    static int maxProfit(int[] a){
        int maxProfit = 0;
        int min = a[0];
        int[] days = new int[2];
        for(int i=1; i<a.length; i++){
            if(a[i] < min) {
                min = a[i];
                days[0] = i;
            }
            if((a[i] - min) > maxProfit){
                maxProfit = a[i] - min;
                days[1] = i;
            }
        }
        System.out.println("max Profit: "+ maxProfit + " Buy by day " + days[0] + " and sell by day " + days[1]);
        return maxProfit;
    }
}
