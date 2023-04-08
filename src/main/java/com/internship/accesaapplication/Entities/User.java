package com.internship.accesaapplication.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private int tokens;
    private int rank;
    @OneToMany
    public List<Badge> badges;
    @OneToMany
    public List<Quest> questsCompleted;
    @OneToMany
    public List<Quest> questsToBeCompleted;
}
