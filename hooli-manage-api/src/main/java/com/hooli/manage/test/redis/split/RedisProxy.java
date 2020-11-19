package com.hooli.manage.test.redis.split;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/13 11:32 上午
 * @description：Redis分库
 */
public class RedisProxy {

    private static List<String> serverList = new ArrayList<>();

    static {
        serverList.add("127.0.0.1:6379");
        serverList.add("127.0.0.1:6380");
        serverList.add("127.0.0.1:6381");
    }

    // 简单的代理实现负载均衡
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(11000);
        Socket socket;
        while ((socket = serverSocket.accept()) != null) {
            try {
                while (true) {
                    System.out.println("一个链接....");
                    InputStream inputStream = socket.getInputStream();
                    byte[] request = new byte[1024];
                    inputStream.read(request);
                    // 解析请求RESP
                    String req = new String(request);
                    System.out.println("收到请求：");
                    System.out.println(req);

                    String[] params = req.split("\r\n");
                    // 获取key的长度
                    int keyLenth = Integer.parseInt(params[3].split("\\$")[1]);
                    // 根据key的长度取模
                    int mod = keyLenth % serverList.size();
                    // 根据取模结果获取地址
                    System.out.println("根据算法选择服务器：" + serverList.get(mod));
                    String[] serverInfo = serverList.get(mod).split(":");
                    // 处理请求
                    Socket client = new Socket(serverInfo[0], Integer.parseInt(serverInfo[1]));
                    client.getOutputStream().write(request);
                    // 返回结果
                    byte[] response = new byte[1024];
                    client.getInputStream().read(response);
                    client.close();
                    socket.getOutputStream().write(response);

                    System.out.println("############打印结束");
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
