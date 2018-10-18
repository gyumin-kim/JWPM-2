package my.examples.miniboard.dto;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private Long userId;
    private String country;
    private String category;
    private String title;
    private String content;
    private LocalDateTime regDate;

    public Article() {
        this.regDate = LocalDateTime.now();
    }

    public Article(Long userId, String country, String category, String title, String content) {
        this();
        this.userId = userId;
        this.country = country;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
