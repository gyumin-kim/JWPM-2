package my.examples.chat;

/**
 * ChatClient에게 ip, port를 전달해 생성하고 start한다.
 */
public class Main {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("127.0.0.1", 12000);
    }
}
