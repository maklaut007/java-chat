package com.api.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Message> messagesList;

    @OneToMany(mappedBy = "channel", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserChannel> userChannelList;

    public Channel() {
    }

    public Channel(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessagesList(List<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public List<Message> getMessagesList() {
        return messagesList;
    }

    public List<UserChannel> getUserChannelList() {
        return userChannelList;
    }

    public void setUserChannelList(List<UserChannel> userChannelList) {
        this.userChannelList = userChannelList;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messagesList=" + messagesList +
                '}';
    }
}
