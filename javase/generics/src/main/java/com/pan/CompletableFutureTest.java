package com.pan;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/9/8 16:27
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("11", "11");
        map.put("12", "11");

        System.out.println(map.get("11"));
    }


}
