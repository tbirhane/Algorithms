package Java8.FunctionalInterface;

import Java8.Java8;

public class FunctionalInterface {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> f = (z, y) -> z+y;
        System.out.println(f.apply(4,4));
    }
}
