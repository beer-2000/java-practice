package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.List;

public class UdpClient {
    public static void main(String[] args) {
        try {
            // DatagramSocket 생성
            List<String> datas = List.of("정치", "경제", "사회", "문화", "스포츠");
            for (int i = 0; i < 100; i++) {
                for (String data : datas) {
                    DatagramSocket datagramSocket = new DatagramSocket();
                    // 구독하고 싶은 뉴스 주제 보내기
//                    String data = "정치";
                    byte[] bytes = data.getBytes("UTF-8");
                    DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,
                            new InetSocketAddress("localhost", 50001));
                    datagramSocket.send(sendPacket);

                    while (true) {
                        // 뉴스 받기
                        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                        datagramSocket.receive(receivePacket);

                        // 문자열로 변환
                        String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
                        System.out.println(news);

                        // 10번째 뉴스를 받으면 while 문 종료
                        if (news.contains("뉴스10")) {
                            break;
                        }
                    }
                    datagramSocket.close();
                }
            }
        } catch (Exception e) {
            System.out.println("[클라이언트] 에러 - " + e.getMessage());
        }
    }
}
