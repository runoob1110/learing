package com.pan.dom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/4/16 21:41
 */
public class Test02 {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student());

        ClassRoom classRoom = new ClassRoom();
        classRoom.setData(students);

        Class<?> aClass = classRoom.getData().getClass();
        System.out.println();

    }
}
