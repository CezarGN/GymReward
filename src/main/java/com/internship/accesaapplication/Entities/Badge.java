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
@Table(name="badge")
public class Badge {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private List<Quest> quests;
}
