package com.tron.gymservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "QandA")
@Data
public class QandA {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "QandASequence")
    @SequenceGenerator(name = "QandASequence", sequenceName = "QandA_SEQ",allocationSize = 1)
    private long id;
    private String Question;
    private String Answer;
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "physical_info_id")
    private UserPhysicalInfo userPhysicalInfo;
}
