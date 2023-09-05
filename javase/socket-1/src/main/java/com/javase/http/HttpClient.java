package com.javase.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/7/24 14:03
 */
public class HttpClient {
    private Socket socket;
    private String ip;
    private int port;

    public HttpClient(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip, port);
    }

    /**
     * 模拟 GET 方法
     */
    public String get(String url) throws IOException {
        StringBuilder request = new StringBuilder();
        // 构造首行
        request.append("GET " + url + " HTTP/1.1\n");
        // 构造 header 请求报头
        request.append("Host: " + ip + ":" + port + "\n");
        // 构造 空行
        request.append("\n");
        //GET 请求中，一般没有 body 正文

        // 发送数据
        OutputStream outputStream = socket.getOutputStream();
        // 由于 outputStream 是一个字节流，以字节单位写入
        // 所以需要把 StingBuilder 类型转换成 String 类型，再转换成 byte[]
        outputStream.write(request.toString().getBytes());

        // 读取响应数据
        InputStream inputStream = socket.getInputStream();
        // 创建一个 1M 大小的缓冲区，用来存放响应数据
        byte[] buffer = new byte[1024 * 1024];
        int n = inputStream.read(buffer);
        return new String(buffer, 0, n, "utf-8");
    }

    /**
     * 模拟 POST 方法
     */
    public String post(String url, String body) throws IOException {
        StringBuilder request = new StringBuilder();
        // 构造首行
        request.append("POST " + url + " HTTP/1.1\n");
        // 构造 header 请求报头
        request.append("Host: " + ip + ":" + port + "\n");
        request.append("Content-Length: " + body.getBytes().length + "\n");
        request.append("Content-Type: text/plain\n");
        // 构造 空行
        request.append("\n");
        // 构造 body
        request.append(body);

        // 发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(request.toString().getBytes());
        // 读取响应数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        int n = inputStream.read(buffer);
        return new String(buffer, 0, n, "utf-8");
    }

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = new HttpClient("192.168.13.103",10003); //这里需要指定需要访问服务器的 IP 和 端口
        String getResp = httpClient.get("/openatc/auth/user/modifystatus"); //填写请求的 url
        System.out.println(getResp);
//
//        String postResp = httpClient.post("", "this is body"); //填写请求的 url 和 body 正文
//        System.out.println(postResp);
    }

}
