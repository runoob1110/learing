package com.javase;


import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Test1{

    public static void main(String[] args) throws SQLException {
        Set<String> ids = new HashSet<>();
        ids.add("*");
        System.out.println(ids.contains("*"));

        ids.clear();
        ids.add("*ssss");
        System.out.println(ids.contains("*"));
    }
}