package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FloorCelingOfNumberInSortedArray {
    public static void main(String[] args) {
        int[] result = floorAndCelling(new int[]{1,4,6,8,9}, 5);
        System.out.println(" Floor: "+result[0] + " Celling: "+ result[1]);
    }
    static int[] floorAndCelling(int[] arr, int n){
        int[] index = new int[2];
        findFloorAndCelling(arr, n, 0, arr.length, index);
        if(index[0] == 0 && n <=0) index[0] = -1;
        if(index[1] == 0 && n >=0) index[1] = -1;
        return index;
    }
    static void findFloorAndCelling(int[] a, int n, int i, int j, int[] index ){
        int m=(i+j)/2;
        if(n<=a[m]) {
            index[1] = a[m];
            if(i <= j)
            findFloorAndCelling(a, n, i, m-1, index);
        } else if(n>=a[m]){
            index[0] = a[m];
            if(i <= j)
            findFloorAndCelling(a, n, m+1, j, index );
        }
    }
}
