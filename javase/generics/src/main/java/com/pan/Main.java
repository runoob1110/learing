package com.pan;

import com.pan.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
//        functionAndThenTest();
//        functionComposeTest();
//        predicateAndTest();
//        predicateOrTest();
//        consumerAndThenTest();
//        mathTest();
//        streamTest();
//        System.out.println(null instanceof Integer);
//        Integer i = new Integer(1);
//        System.out.println(i.equals(null));
//        System.out.println(1 % 100);
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() + 3000);
        long t1 = System.currentTimeMillis() + 300;
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / 1000);

    }

    private static void streamTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3,"张三"));
        students.add(new Student(4,"李四"));
        students.add(new Student(5,"王五"));
        students.add(new Student(3,"赵六"));
        students.add(new Student(3,"赵六"));
        students.add(new Student(6,"赵八"));


        //1.先根据得到一个属于集合 姓名
        List<Integer> uniqueList = students.stream().collect(Collectors.groupingBy(Student::getId, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        uniqueList.forEach(p -> System.out.println(p));

        //计算两个list中的重复值  3条数据
        List<Student> reduce1 = students.stream().filter(item -> uniqueList.contains(item.getId())).collect(Collectors.toList());
        System.out.println(reduce1);

        // 求差集
        List<Student> difference = students.stream().filter(userInfo ->
                !reduce1.stream().map(Student::getId).collect(Collectors.toList()).contains(userInfo.getId())
        ).collect(Collectors.toList());
        System.out.println("A中B的补集：");
        difference.forEach(System.out::println);




    }

    private static void mathTest() {
//        (10 + 5) * 2 - 8
        Function<Integer,Integer> function1 = (value) -> value + 5;
        Function<Integer,Integer> function2 = (value) -> value * 2;
        Function<Integer,Integer> function3 = (value) -> value - 8;
        Function<Integer,Integer> function4 = function1.andThen(function2).andThen(function3);
        Integer apply = function4.apply(10);

//        Integer result = function1.andThen(function2).andThen(function3).apply(10);
        System.out.println("mathTest: " + apply);
    }


    public static void functionAndThenTest() {
        Function<Integer,Integer> function1 = (value) -> value + 2;
        Function<Integer,Integer> function2 = (value) -> value * 10;
        Function<Integer,Integer> function3 = function1.andThen(function2);
        Integer apply = function3.apply(100);
        System.out.println("andThen: " + apply);
    }

    public static void functionComposeTest() {
        Function<Integer,Integer> function1 = (value) -> value + 2;
        Function<Integer,Integer> function2 = (value) -> value * 10;
        Function<Integer,Integer> function3 = function1.compose(function2);
        Integer result = function3.apply(100);
        System.out.println("compose: " + result);
    }


    public static void predicateAndTest(){
        Predicate<Integer> predicate1 = (value) -> value > 0;
        Predicate<Integer> predicate2 = (value) -> value >= 10;
        Predicate<Integer> predicate3 = predicate1.and(predicate2);
        boolean test = predicate3.test(10);
        System.out.println("predicate and: " + test);
    }


    public static void predicateOrTest(){
        Predicate<Integer> predicate1 = (value) -> value > 0;
        Predicate<Integer> predicate2 = (value) -> value >= 10;
        Predicate<Integer> predicate3 = predicate1.or(predicate2);
        Boolean result = predicate3.test(5);
        System.out.println("predicate or: " + result);
    }


    public static void consumerAndThenTest(){
        Consumer<Integer> consumer1 = (value) -> System.out.println(value);
        Consumer<Integer> consumer2 = (value) -> System.out.println(value * value);
        Consumer<Integer> consumer3 = consumer1.andThen(consumer2);
        consumer3.accept(100);
//        consumer2.accept(100);
    }

}







