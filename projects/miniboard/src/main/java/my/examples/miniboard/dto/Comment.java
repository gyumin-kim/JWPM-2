package my.examples.miniboard.dto;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Long articleId;
    private Long userId;
    private String content;
    private LocalDateTime regDate;

    public Comment() {
    }

    public Comment(Long id, Long articleId, Long userId, String content, LocalDateTime regDate) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.content = content;
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

/*
CREATE TABLE comment(
id bigint not null auto_increment,  -- 각 댓글의 id
article_id bigint,                  -- 어떤 article의 댓글인지를 나타내는 article의 id
user_id bigint,                     -- 댓글을 남긴 user의 id
content text,
primary key(id),
foreign key(article_id) references article(id)
);
 */