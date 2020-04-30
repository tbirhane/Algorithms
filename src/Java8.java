import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        byte x = 90;
        byte y = 10;
        int z = x*2;
        List<String> str = Arrays.asList("Hello", "Hello","hi","this","go");
        List<String> dup = str.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(dup);
        System.out.println(str.stream().distinct().collect(Collectors.toList()));
        System.out.println(str.stream().distinct().collect(Collectors.joining("-")));
        int[] a = {23,5,6,7,7,8};
        System.out.println(Arrays.stream(a).distinct().boxed().collect(Collectors.toList()));
        List<Employee> emps = Arrays.asList(new Employee("alem", new Department("CSE")),
                new Employee("alem", new Department("Eco")),
                new Employee("Jon", new Department("CSE"))
        );
        System.out.println(emps.stream().collect(Collectors.groupingBy(Employee::getName)));
    }
    static class Employee{
        String name;
        Department dpt;

        public Employee(String name, Department dpt) {
            this.name = name;
            this.dpt = dpt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department getDpt() {
            return dpt;
        }
        public String toString(){
            return dpt.name;
        }
    }
    static class Department{
        String name;

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String toString(){
            return name;
        }
    }
}

