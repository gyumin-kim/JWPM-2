package my.examples.guestbook.servlet;

import java.time.LocalDateTime;

public class Guestbook {
    private long id;
    private String name;
    private String content;
    private LocalDateTime regdate;

    public Guestbook() {
        this.regdate = LocalDateTime.now();
    }

    public Guestbook(String name, String content) {
        this();
        this.name = name;
        this.content = content;
    }

    public Guestbook(long id, String name, String content) {
        this(name, content);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }
}
