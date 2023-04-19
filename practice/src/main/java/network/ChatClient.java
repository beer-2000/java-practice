package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            Scanner scanner = new Scanner(System.in);
            chatClient.receive();

            System.out.print("이름을 입력하세요 : ");
            String chatName = scanner.nextLine();
            chatClient.send("이름: " + chatName);

            System.out.println("-----------------------------------");
            System.out.println("보낸 메시지를 입력하고 Enter");
            System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
            System.out.println("-----------------------------------");
            while (true) {
                String message = scanner.nextLine();
                if (message.toLowerCase().equals("q")) {
                    break;
                }
                chatClient.send(message);
            }
            scanner.close();
            chatClient.disconnect();
        } catch (IOException e) {
            System.out.println("[클라이언트] 서버 연결 안됨");
        }
    }

    public void connect() throws IOException {
        socket = new Socket("localhost", 50002);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }

    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String data = dataInputStream.readUTF();
                    System.out.println(data);
                }
            } catch (Exception e) {
                System.out.println("[클라이언트] 서버 연결 끊김");
                System.exit(0);
            }
        });
        thread.start();
    }

    public void send(String data) throws IOException {
        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
    }

    public void disconnect() throws IOException {
        socket.close();
    }
}
