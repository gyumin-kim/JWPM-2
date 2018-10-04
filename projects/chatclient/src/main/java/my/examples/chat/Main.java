package my.examples.chat;

public class Main {
    public static void main(String[] args) {
        // ip: 서버가 사용 중인 ip 지정
        ChatClient chatClient = new ChatClient("127.0.0.1", 11000);
        chatClient.start();
    }
}