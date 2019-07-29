package com.tron.gymservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private long id;
    private String role;
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role"
//            , cascade = CascadeType.ALL
//            , orphanRemoval = true)
//    private List<UserMasterInfo> userMasterInfo=new ArrayList<>();
}
