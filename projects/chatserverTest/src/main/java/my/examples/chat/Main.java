package my.examples.chat;

/**
 * ChatServer에게 port 번호를 전달해 생성하고 start한다.
 */
public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(12000);
        chatServer.start();
    }
}
