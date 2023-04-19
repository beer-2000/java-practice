package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();

            System.out.println("-----------------------------------");
            System.out.println("서버를 종료하려면 q를 입력하고 Enter를 입력하세요.");
            System.out.println("-----------------------------------");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String key = scanner.nextLine();
                if (key.equals("q")) {
                    break;
                }
            }
            scanner.close();
            chatServer.stop();
        } catch (IOException e) {
            System.out.println("[서버] 에러 - " + e.getMessage());
        }
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(50002);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    SocketClient socketClient = new SocketClient(this, socket);
                }
            } catch (IOException e) {
            }
        });
        thread.start();
    }

    public void addSocketClient(SocketClient socketClient, String chatName) {
        String key = chatName + "@" + socketClient.clientIp;
        chatRoom.put(key, socketClient);
        System.out.println("입장: " + key);
        System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("나감: " + key);
        System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
    }

    public void sendToAll(SocketClient sender, String message) {
        String data = sender.chatName + "(" + sender.clientIp + ") : " + message;
        if (message.startsWith("이름")) {
            data = sender.chatName;
        }
        if (message.contains("입장하셨습니다.")) {
            data = message;
        }
        Collection<SocketClient> socketClients = chatRoom.values();
        for (SocketClient socketClient : socketClients) {
            if (socketClient == sender) {
                continue;
            }
            socketClient.send(data);
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            for (SocketClient socketClient : chatRoom.values()) {
                socketClient.close();
            }
            System.out.println("[서버] 종료됨");
        } catch (IOException e) {
        }
    }
}
