package kim.myeongjae.springdatadynamodbexample.guestbook.api.dto;

import java.time.ZonedDateTime;

public class VisitorLogDto {
    private String id;
    private String name;
    private String content;
    private ZonedDateTime createdAt;

    public VisitorLogDto() {
    }

    public VisitorLogDto(String id, String name, String content, ZonedDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
