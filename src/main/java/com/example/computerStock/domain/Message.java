package com.example.computerStock.domain;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Entity
public class Message {




    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
