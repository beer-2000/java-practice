package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UdpServer {
    private static DatagramSocket datagramSocket = null;
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
                    // DatagramSocker 생성 및 Port 바인딩
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("[서버] 시작");

                    while (true) {
                        // 클라이언트가 구독하고 싶은 뉴스 주제 얻기
                        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                        datagramSocket.receive(receivePacket);

                        executorService.execute(() -> {
                            try {
                                System.out.println(Thread.currentThread().getName());
                                String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(),
                                        "UTF-8");

                                // 클라이언트의 IP와 Port 얻기
                                SocketAddress socketAddress = receivePacket.getSocketAddress();

                                // 10개의 뉴스를 클라이언트로 전송
                                for (int i = 1; i <= 10; i++) {
                                    String data = newsKind + ": 뉴스" + i;
                                    byte[] bytes = data.getBytes("UTF-8");
                                    DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, socketAddress);
                                    datagramSocket.send(sendPacket);
//                                    System.out.println("[서버] 데이터 전송 - " + data + " / 현재 시각 : " + LocalDate.now());
                                }
                            } catch (Exception e) {
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
        datagramSocket.close();
        executorService.shutdownNow();
        System.out.println("[서버] 종료됨");
    }
}
