package com.internship.accesaapplication.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="quests")
public class Quest {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private int reward;
    @OneToOne
    private User leader;

    public Quest(String name, String description, int reward, User byId) {
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.leader = byId;
    }
}
