package com.example.computerStock.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Пожалуйста введите сообщение")
    @Length(max = 2048, message = "Сообщение больше 2048 символов")
    private String text;
    @NotBlank(message = "Пожалуйста введите тэг")
    @Length(max = 255, message = "Тэг больше 255 символов")
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    @NotBlank(message = "Введите получателя")
    private String messageFor;

    public Message(String text, String tag, User user, String messageFor) {
        this.text = text;
        this.tag = tag;
        this.author = user;
        this.messageFor = messageFor;
    }

    public Message() {
    }

    public String getMessageFor() {
        return messageFor;
    }

    public void setMessageFor(String messageFor) {
        this.messageFor = messageFor;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
