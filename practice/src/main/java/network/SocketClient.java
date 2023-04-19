package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
    ChatServer chatServer;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String clientIp;
    String chatName;

    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = inetSocketAddress.getHostName();
            receive();
        } catch (IOException e) {
        }
    }

    public void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while (true) {
                    String receiveString = dataInputStream.readUTF();
                    if (receiveString.startsWith("이름")) {
                        this.chatName = receiveString.split(":")[1].trim();
                        chatServer.addSocketClient(this, this.chatName);
                        chatServer.sendToAll(this, (this.chatName + "님께서 입장하셨습니다."));
                        continue;
                    }
                    chatServer.sendToAll(this, receiveString);
                }
            } catch (IOException e) {
                chatServer.sendToAll(this, "나가셨습니다.");
                chatServer.removeSocketClient(this);
            }
        });
    }

    public void send(String data) {
        try {
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
        } catch (IOException e) {
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {
        }
    }
}
