package common;

import Arrays.Student;

public class CoreJava {
    public static void main(String[] args) {
        Student s1 = new Student("joun",20);
        Student s2 = s1;
        System.out.println(s1.getAge());
        System.out.println(s2.getAge());
        s2.setAge(30);
        System.out.println(s1.getAge());
        System.out.println(s2.getAge());

        Long l1 = new Long(2);
        Long l2 =l1;
        l2+=1;
        System.out.println("long1 "+l1);
        System.out.println("long2 "+l2);

        Integer i1 = new Integer(1);
        Integer i2 = i1;
        System.out.println("Int1 "+i1);
        System.out.println("Int2 "+i2);
        i2++;
        System.out.println("Int1 "+i1);
        System.out.println("Int2 "+i2);

        String str1 = "My String";
        String str2 = new String("My String");
        String str3 = str2;
        String str4 = str1;
        System.out.println(str1==str2); // false
        System.out.println(str1.equals(str2)); // true
        System.out.println(str3==str2); // true
        System.out.println(str1==str4); // true

    }
}
