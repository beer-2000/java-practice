package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
    private static ServerSocket serverSocket = null;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        System.out.println("------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("------------------------");

        startServer();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }
        scanner.close();

        stopServer();
    }

    public static void startServer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작");
                    while (true) {
                        System.out.println("\n[서버] 연결 요청을 기다림");
                        Socket socket = serverSocket.accept();

                        executorService.execute(() -> {
                            try {
                                System.out.println("[서버] 쓰레드 이름 : " + Thread.currentThread().getName());
                                InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                                System.out.println("[서버] " + inetSocketAddress.getHostName() + "의 연결 요청 수락");

                                // 데이터 받기
                                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                                String message = dataInputStream.readUTF();

                                // 데이터 보내기
                                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                dataOutputStream.writeUTF(message);
                                dataOutputStream.flush();
                                System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);

                                // 연결 끊기
                                socket.close();
                                System.out.println("[서버] " + inetSocketAddress.getHostName() + "의 연결을 끊음");
                            } catch (IOException e) {
                            }
                        });
                    }
                } catch (IOException e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        try {
            serverSocket.close();
            executorService.shutdownNow();
            System.out.println("[서버] 종료됨");
        } catch (IOException ignored) {
        }
    }
}
