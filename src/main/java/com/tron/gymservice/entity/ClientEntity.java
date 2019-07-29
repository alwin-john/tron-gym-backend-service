package com.tron.gymservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "client_info")
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "clientIdSequence")
    @SequenceGenerator(name = "clientIdSequence", sequenceName = "ClientId_SEQ",allocationSize = 1)
    @Column(name = "clientInfo_id")
    private long id;
    private String name;
    private String bloodGroup;
    private int weight;
    private int height;
}
