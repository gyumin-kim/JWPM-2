package my.examples.chat;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(11000);
        chatServer.start(); // 이후 ChatServer의 run() 호출
        System.out.println("서버가 실행됨!");
    }
}