package com.api.chat.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private String channel_id; // connect to channel
}
