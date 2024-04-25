package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverIP = "192.169.0.100";
        int serverPort = 8001;

        try (Socket socket = new Socket(serverIP, serverPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // 连接成功后，进入循环接收数据
            while (true) {
                String receivedData = in.readLine();
                if (receivedData == null) {
                    // 如果接收到的数据为空，说明连接已关闭
                    System.out.println("连接已关闭。");
                    break;
                }
                System.out.println("Received data: " + receivedData);
                // 在这里处理接收到的数据，例如解析、存储等操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
