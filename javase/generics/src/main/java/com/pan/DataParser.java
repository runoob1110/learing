package com.pan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {

    public static void main(String[] args) {
        String hexString = "7e00490101010000000001012004010d07010001010000000000000000020d07010002020000000000000000030d07010003030000000000000000040d07010004040000000000000000d34b7d";

        byte[] dataSources = hexStringToByteArray(hexString);

        // 检查开始和结束标记
        if (dataSources[0] != 0x7E || dataSources[dataSources.length - 1] != 0x7D) {
            throw new RuntimeException("Invalid start or end marker");
        }

        // 数据内容从索引1开始到倒数第4个字节（跳过开始标记和校验和）
//        int dataStartIndex = 1;
//        int dataEndIndex = bytes.length - 4;
//        int dataContentLength = dataEndIndex - dataStartIndex + 1;
//        byte[] dataContent = new byte[dataContentLength];
//        System.arraycopy(bytes, dataStartIndex, dataContent, 0, dataContentLength);

        // 获取数据条数（数据内容的第13个字节，对应索引12）
        int numEntries = dataSources[13] & 0xFF;
        List<byte[]> dataList = new ArrayList<>();
        int currentIndex = 13; // 数据内容中的当前索引，从第一个数据索引开始

        for (int i = 0; i < numEntries; i++) {
            // 读取数据索引和长度
            int dataLength = dataSources[currentIndex + 2] & 0xFF;
            // 提取数据字节
            byte[] dataBytes = Arrays.copyOfRange(dataSources, currentIndex + 1, currentIndex + 1 + dataLength + 2);
//            System.arraycopy(dataSources, currentIndex + 5, dataBytes, 0, dataLength - 5);
            dataList.add(dataBytes);
            currentIndex += 2 + dataLength;
        }

        // 输出结果（用于验证）
        System.out.println("Number of data entries: " + numEntries);
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println("Data " + (i + 1) + " length: " + dataList.get(i).length);
            // 如果需要打印十六进制表示，可以取消注释以下代码
            System.out.println("Data " + (i + 1) + ": " + bytesToHex(dataList.get(i)));
        }
    }

    // 将十六进制字符串转换为字节数组
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    // 可选：将字节数组转换为十六进制字符串用于打印
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}