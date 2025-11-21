package com.pan;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/4/10 10:19
 */
public class HexByteConvertor {
    // 十六进制字符串转byte数组
    public static byte[] hexToBytes(String hexString) {
        int len = hexString.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException("十六进制字符串长度必须为偶数");
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            String byteStr = hexString.substring(i, i + 2);
            int parsedValue = Integer.parseInt(byteStr, 16);
            data[i / 2] = (byte) parsedValue; // 强制转换保留符号位
        }
        return data;
    }

    // byte数组转十六进制字符串
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexStr = new StringBuilder();
        for (byte b : bytes) {
            int unsignedByte = b & 0xFF; // 去除符号扩展，保留无符号值
            String hex = Integer.toHexString(unsignedByte).toUpperCase();
            if (hex.length() == 1) {
                hexStr.append('0'); // 补零确保两位
            }
            hexStr.append(hex);
        }
        return hexStr.toString();
    }

    public static void main(String[] args) {
        // 示例1: 0xC0 转 -64
        String hexStr = "80";
        byte[] bytes = hexToBytes(hexStr);
        System.out.println(hexStr + " -> 字节数组: " + java.util.Arrays.toString(bytes));

//        // 示例2: -64 转 C0
//        byte b = -64;
//        String convertedHex = bytesToHex(new byte[]{b});
//        System.out.println(b + " -> 十六进制: " + convertedHex);
    }
}
