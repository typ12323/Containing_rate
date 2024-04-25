import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkDataSender {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // 服务器地址
        int serverPort = 80; // 服务器端口

        try {
            // 创建套接字并连接到服务器
            Socket socket = new Socket(serverAddress, serverPort);

            // 获取输出流
            OutputStream outputStream = socket.getOutputStream();

            // 要发送的数据
            String data = "测试数据123";

            // 将数据转换为字节数组并发送
            outputStream.write(data.getBytes());

            // 刷新输出流
            outputStream.flush();

            // 关闭输出流和套接字
            outputStream.close();
            socket.close();

            System.out.println("数据发送成功");
        } catch (IOException e) {
            System.err.println("发送数据时出现异常: " + e.getMessage());
        }
    }
}
