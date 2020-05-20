package Java8.FunctionalInterface;

import Java8.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<List<String>>();
        BiFunction<Integer,Integer,Integer> f = (z, y) -> z+y;
        System.out.println(f.apply(4,4));

        Supplier<List<Integer>> suplier = () -> {return Arrays.asList(10,20,30);};
        Consumer<List<String>> consumer = (str) -> {str.forEach(s -> System.out.println(s));};
        System.out.println(suplier.get());
        consumer.accept(Arrays.asList("Jack", "Mulu", "Cisco"));
    }
}
